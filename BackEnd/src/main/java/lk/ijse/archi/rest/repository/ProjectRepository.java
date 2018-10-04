package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProjectRepository extends JpaRepository<Project,String> {

    @Query(value = "select * from project where clientID=:email",nativeQuery = true)
    ArrayList<Project> getProjects(@Param("email") String email);

}
