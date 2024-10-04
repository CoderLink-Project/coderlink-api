package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.AuthResponseDTO;
import org.project.coderlinkapi.dto.LoginDTO;
import org.project.coderlinkapi.dto.UserProfileDTO;
import org.project.coderlinkapi.dto.UserRegistrationDTO;
import org.project.coderlinkapi.exception.BadRequestException;
import org.project.coderlinkapi.exception.InvalidCredentialsException;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.exception.RoleNotFoundException;
import org.project.coderlinkapi.mapper.UserMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Role;
import org.project.coderlinkapi.model.entity.User;
import org.project.coderlinkapi.model.enums.ERole;
import org.project.coderlinkapi.repository.RoleRepository;
import org.project.coderlinkapi.repository.UserRepository;
import org.project.coderlinkapi.security.TokenProvider;
import org.project.coderlinkapi.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final DeveloperRepository developerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager; // Necesario para la autenticación
    private final TokenProvider tokenProvider; // Necesario para la creación de tokens JWT

    @Transactional
    @Override
    public UserProfileDTO registerCustomer(UserRegistrationDTO registrationDTO) {
        return registerUserWithRole(registrationDTO, ERole.CUSTOMER);
    }

    @Transactional
    @Override
    public UserProfileDTO registerDeveloper(UserRegistrationDTO registrationDTO) {
        return registerUserWithRole(registrationDTO, ERole.DEVELOPER);
    }

    @Transactional
    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        // Buscar el usuario por email
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email: " + loginDTO.getEmail()));

        // Verificar si la contraseña es correcta
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Credenciales incorrectas");
        }

        // Autenticar al usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );

        // Generar el token JWT usando el TokenProvider
        String token = tokenProvider.createAccessToken(authentication);

        // Generar la respuesta de autenticación, con el rol correspondiente
        AuthResponseDTO response = userMapper.toAuthResponseDTO(user, token);

        // Retornar la respuesta
        return response;
    }


    // Método genérico para registrar un usuario con un rol específico
    private UserProfileDTO registerUserWithRole(UserRegistrationDTO registrationDTO, ERole roleEnum) {

        // Verificar si el email ya está registrado o si ya existe un usuario con el mismo nombre y apellido
        boolean emailExists = userRepository.existsByEmail(registrationDTO.getEmail());
        boolean existsAsCustomer = customerRepository.existsByFirstNameAndLastName(registrationDTO.getFirstName(), registrationDTO.getLastName());
        boolean existsAsDeveloper = developerRepository.existsByFirstNameAndLastName(registrationDTO.getFirstName(), registrationDTO.getLastName());

        if (emailExists) {
            throw new UsernameNotFoundException("El email ya está registrado");
        }

        if (existsAsCustomer || existsAsDeveloper) {
            throw new BadRequestException("Ya existe un usuario con el mismo nombre y apellido");
        }


        // Asignar el rol del usuario
        Role role = roleRepository.findByName(roleEnum)
                .orElseThrow(() -> new RoleNotFoundException("Rol no encontrado"));

        // Cifrar la contraseña
        registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        // Convertir el DTO a una entidad User
        User user = userMapper.toUserEntity(registrationDTO);
        user.setRole(role); // Asignar el rol al usuario

        // Asignar la entidad específica basada en el rol
        if (roleEnum == ERole.CUSTOMER) {
            // Crear un cliente
            Customer customer = new Customer();
            customer.setFirstname(registrationDTO.getFirstName());
            customer.setLastname(registrationDTO.getLastName());
            customer.setCreatedAt(LocalDateTime.now());
            customer.setUser(user);  // Enlazar el cliente con el usuario
            user.setCustomer(customer);
        } else if (roleEnum == ERole.DEVELOPER) {
            // Crear un developer
            Developer developer = new Developer();
            developer.setFirstName(registrationDTO.getFirstName());
            developer.setLastName(registrationDTO.getLastName());
            developer.setDescription(registrationDTO.getDescription());
            developer.setPortfolio(registrationDTO.getPortafolio());
            developer.setSkill(registrationDTO.getSkill());
            developer.setWorkExperience(registrationDTO.getWorkExperience());
            developer.setPaymentRate(registrationDTO.getPaymentRate());
            developer.setCreatedAt(LocalDateTime.now());
            developer.setUser(user);  // Enlazar el autor con el usuario
            user.setDeveloper(developer);
        }

        // Guardar el usuario en la base de datos
        User savedUser = userRepository.save(user);

        // Convertir el usuario registrado a UserProfileDTO para la respuesta
        return userMapper.toUserProfileDTO(savedUser);
    }


    @Transactional
    @Override
    public UserProfileDTO updateUserProfile(Integer id, UserProfileDTO userProfileDTO) {
        // Buscar el usuario por su ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        // Verificar si ya existe un cliente o autor con el mismo nombre y apellido (excepto el usuario actual)
        // La verificación se realiza excluyendo el usuario actual para permitir que actualice su propio perfil
        // sin que se genere un conflicto de duplicidad en los nombres y apellidos.
        boolean existsAsCustomer = customerRepository.existsByFirstNameAndLastNameAndUserIdNot(userProfileDTO.getFirstName(), userProfileDTO.getLastName(), id);
        boolean existsAsDeveloper = developerRepository.existsByFirstNameAndLastNameAndUserIdNot(userProfileDTO.getFirstName(), userProfileDTO.getLastName(), id);

        if (existsAsCustomer || existsAsDeveloper) {
            throw new BadRequestException("Ya existe un usuario con el mismo nombre y apellido");
        }


        // Actualizar los campos específicos del perfil
        if (user.getCustomer() != null) {
            user.getCustomer().setFirstname(userProfileDTO.getFirstName());
            user.getCustomer().setLastname(userProfileDTO.getLastName());
        }

        if (user.getDeveloper() != null) {
            user.getDeveloper().setFirstName(userProfileDTO.getFirstName());
            user.getDeveloper().setLastName(userProfileDTO.getLastName());
            user.getDeveloper().setDescription(userProfileDTO.getDescription());
            user.getDeveloper().setSkill(userProfileDTO.getSkill());
            user.getDeveloper().setPortfolio(userProfileDTO.getPortafolio());
            user.getDeveloper().setWorkExperience(userProfileDTO.getWorkExperience());
            user.getDeveloper().setPaymentRate(userProfileDTO.getPaymentRate());
        }

        // Guardar los cambios en la base de datos
        User updatedUser = userRepository.save(user);

        // Convertir el usuario actualizado a UserProfileDTO para la respuesta
        return userMapper.toUserProfileDTO(updatedUser);
    }

    @Transactional
    @Override
    public UserProfileDTO getUserProfileById(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        // Convertir a UserProfileDTO para la respuesta
        return userMapper.toUserProfileDTO(user);
    }
}