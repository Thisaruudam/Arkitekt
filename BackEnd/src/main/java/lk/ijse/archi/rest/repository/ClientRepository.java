package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,String> {

    @Query(value = "Select * from client where email=:email",nativeQuery = true)
    Client getClient(@Param("email") String email);

}
