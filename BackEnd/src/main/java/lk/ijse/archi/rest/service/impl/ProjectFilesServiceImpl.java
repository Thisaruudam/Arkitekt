package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.ProjectDTO;
import lk.ijse.archi.rest.entity.Client;
import lk.ijse.archi.rest.entity.Project;
import lk.ijse.archi.rest.entity.ProjectFiles;
import lk.ijse.archi.rest.repository.ProjectFilesRepository;
import lk.ijse.archi.rest.service.ProjectFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ProjectFilesServiceImpl implements ProjectFilesService {

    private final Path rootLocation = Paths.get("D://INTELLIJ/ArKiTeKt/BackEnd/UploadedFiles");

    @Autowired
    private ProjectFilesRepository projectFilesRepository;

    @Override
    public void store(MultipartFile file, String projectId) {
        try {

            ProjectFiles projectFiles = new ProjectFiles(0,
                    projectId,
                    file.getOriginalFilename(),
                    rootLocation.toAbsolutePath().toString());
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            projectFilesRepository.save(projectFiles);
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public String getProjectFile(String projectID) {
        ProjectFiles projectFiles =projectFilesRepository.getProjectFiles(projectID);
        String fileName= projectFiles.getUrl() + "\\" + projectFiles.getFilename();
        return fileName;
    }


}
