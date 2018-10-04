package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.UserDTO;
import lk.ijse.archi.rest.dto.UserVerificationDTO;

public interface UserService {

    public boolean saveUser(UserDTO userDTO);

    public UserVerificationDTO canAuthenticate(String email, String password);

}
