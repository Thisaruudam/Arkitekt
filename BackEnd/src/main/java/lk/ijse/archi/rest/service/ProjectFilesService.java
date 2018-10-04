package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.ProjectDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProjectFilesService {

    public void store(MultipartFile file, String projectId);

    public String getProjectFile(String projectID);


}
