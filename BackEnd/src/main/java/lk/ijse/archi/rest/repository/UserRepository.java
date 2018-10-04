package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
