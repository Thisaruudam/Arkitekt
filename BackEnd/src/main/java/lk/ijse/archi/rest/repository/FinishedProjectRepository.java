package lk.ijse.archi.rest.repository;

import lk.ijse.archi.rest.entity.FinishedProjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinishedProjectRepository extends JpaRepository<FinishedProjects,String> {
}
