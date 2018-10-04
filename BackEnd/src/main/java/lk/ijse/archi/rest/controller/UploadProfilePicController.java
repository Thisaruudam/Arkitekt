package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.service.UploadProfileService;
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

@RestController
@CrossOrigin
public class UploadProfilePicController {

    @Autowired
    private UploadProfileService uploadProfileService;

    @PostMapping(value = "api/v1/uploadProfilePic")
    public ResponseEntity< String > uploadProfilePic(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        String message = "";
        try {
            uploadProfileService.uploadProfile(file,email);
            message = "You successfully uploaded Profile!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Fail to upload Profile Picture!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping(value = "api/v1/getProfilePic")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("email") String email) {

        File file = new File(uploadProfileService.getProfilePic(email));


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
