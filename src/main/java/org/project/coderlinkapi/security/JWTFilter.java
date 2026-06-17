package org.project.coderlinkapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestPath = httpServletRequest.getRequestURI();

        // Normaliza la ruta para evitar errores de comparación
        requestPath = requestPath.replaceAll("//", "/");

        // Permitir el acceso sin autenticación a los endpoints de login y registro
        if (requestPath.equals("/api/v1/auth/login") || requestPath.startsWith("/api/v1/auth/register")) {
            chain.doFilter(request, response);
            return;
        }

        // Permitir acceso a Swagger sin autenticación
        if (requestPath.startsWith("/swagger-ui") || requestPath.startsWith("/v3/api-docs")) {
            chain.doFilter(request, response);
            return;
        }

        // Obtener el token del encabezado Authorization
        String bearerToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);
            if (tokenProvider.validateToken(token)) {
                Authentication authentication = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().write("Invalid or expired token");
                return;
            }
        } else {
            // Si no hay token o es incorrecto, ignorar la solicitud solo para rutas autenticadas
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("Authorization header missing or malformed");
            return;
        }

        chain.doFilter(request, response);
    }

}



