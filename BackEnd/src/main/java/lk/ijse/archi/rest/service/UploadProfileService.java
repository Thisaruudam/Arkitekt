package lk.ijse.archi.rest.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadProfileService {

    public void uploadProfile(MultipartFile file, String email);

    public String getProfilePic(String email);

}
