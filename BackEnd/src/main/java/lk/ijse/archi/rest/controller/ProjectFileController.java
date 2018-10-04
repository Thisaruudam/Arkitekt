package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.ProjectDTO;
import lk.ijse.archi.rest.service.ProjectFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@CrossOrigin
public class ProjectFileController {

    @Autowired
    private ProjectFilesService projectFilesService;

    @PostMapping(value = "api/v1/upload")
    public ResponseEntity < String > handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("projectID") String projectId) {
        String message = "";
        try {
            projectFilesService.store(file,projectId);
            message = "You successfully uploaded!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Fail to upload Picture!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping(value = "api/v1/getProjectFile")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("projectID") String projectId) {

        File file = new File(projectFilesService.getProjectFile(projectId));


        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length())
                .body(resource);
    }


}
