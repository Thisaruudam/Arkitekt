package lk.ijse.archi.rest.repository;


import lk.ijse.archi.rest.entity.ProjectFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProjectFilesRepository extends JpaRepository<ProjectFiles,Integer> {

    @Query(value = "select * from ProjectFiles where projectId=:projectID",nativeQuery = true)
    ProjectFiles getProjectFiles(@Param("projectID") String projectID);

}
