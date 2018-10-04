package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.UserDTO;
import lk.ijse.archi.rest.dto.UserVerificationDTO;
import lk.ijse.archi.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "api/v1/user",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PostMapping(value="api/v1/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVerificationDTO canAuthenticate(@RequestBody UserDTO user){
        return userService.canAuthenticate(user.getEmail(), user.getPassword());
    }
}
