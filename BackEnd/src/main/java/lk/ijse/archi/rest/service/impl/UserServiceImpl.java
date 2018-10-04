package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.UserDTO;
import lk.ijse.archi.rest.dto.UserVerificationDTO;
import lk.ijse.archi.rest.entity.User;
import lk.ijse.archi.rest.repository.UserRepository;
import lk.ijse.archi.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveUser(UserDTO userDTO) {
        User user=new User(userDTO.getEmail(),userDTO.getPassword(),userDTO.getIsAdmin(),userDTO.getIsClient());
        userRepository.save(user);
        return true;
    }

    @Override
    public UserVerificationDTO canAuthenticate(String email, String password) {
        boolean exists = userRepository.existsById(email);
        if (!exists){
            return null;
        }

        User user = userRepository.findById(email).get();

        if(user.getPassword().equals(password)){
            return new UserVerificationDTO(user.getEmail(),user.getIsAdmin(),user.getIsClient());
        }else {
            return null;
        }

    }

}
