package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HireRepository extends JpaRepository<Bid,String> {

    @Query(value = "delete from bid where projectID=:projectId",nativeQuery = true)
    boolean deleteBIds(@Param("projectId") String projectId);

    @Query(value = "delete from project where projectID=:projectId",nativeQuery = true)
    boolean deleteProject(@Param("projectId") String projectId);

}
