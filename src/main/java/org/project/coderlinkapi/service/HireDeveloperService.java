package org.project.coderlinkapi.service;
import org.project.coderlinkapi.dto.HireDeveloperDTO;
import java.util.List;

public interface HireDeveloperService {
    //metodo para contratar desarrollador
    HireDeveloperDTO hireDeveloper(HireDeveloperDTO hireDeveloperDTO);

   //metodo para buscar un desarrollador por su id
    HireDeveloperDTO getDeveloperByid(Integer id);
}
