package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.entity.ProfileClient;
import lk.ijse.archi.rest.repository.ProfileClientRepository;
import lk.ijse.archi.rest.service.UploadProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UploadProfileServiceImpl implements UploadProfileService {

    private final Path rootLocationProfile = Paths.get("D://INTELLIJ/ArKiTeKt/BackEnd/UploadedProfilePic");

    @Autowired
    private ProfileClientRepository profileClientRepository;

    @Override
    public void uploadProfile(MultipartFile file, String email) {
        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(email);
            System.out.println(rootLocationProfile.toAbsolutePath());
            ProfileClient profileClient = new ProfileClient(email, file.getOriginalFilename(), rootLocationProfile.toAbsolutePath().toString());
            Files.copy(file.getInputStream(), this.rootLocationProfile.resolve(file.getOriginalFilename()));
            profileClientRepository.save(profileClient);
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public String getProfilePic(String email) {
        ProfileClient profileClient=profileClientRepository.findById(email).get();
        String fileName=profileClient.getUrl() + "\\" + profileClient.getFilename();
        return fileName;
    }
}
