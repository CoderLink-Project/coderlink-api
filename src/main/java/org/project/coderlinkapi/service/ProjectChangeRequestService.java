package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.RequestDTO;

import java.util.List;

public interface ProjectChangeRequestService {
    RequestDTO requestProjectChange(int projectId, RequestDTO requestDTO);
    void deleteChangeRequest(int projectId);
    List<RequestDTO> getAllChangeRequests();


}
