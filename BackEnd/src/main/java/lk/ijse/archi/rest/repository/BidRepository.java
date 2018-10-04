package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface BidRepository extends JpaRepository<Bid,String> {

    @Query(value = "select * from bid where projectID=:projectId",nativeQuery = true)
    ArrayList<Bid> getBIds(@Param("projectId") String projectId);

}
