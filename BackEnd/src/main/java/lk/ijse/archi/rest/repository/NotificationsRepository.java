package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications,Integer> {

    @Query(value = "SELECT * FROM Notifications where freeLancerID=:id ORDER BY createdAt DESC",nativeQuery = true)
    List<Notifications> getNotificationsById(@Param("id") String id);

}
