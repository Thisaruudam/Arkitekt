package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.ClientDTO;
import lk.ijse.archi.rest.dto.ProjectDTO;
import lk.ijse.archi.rest.entity.Client;
import lk.ijse.archi.rest.entity.Project;
import lk.ijse.archi.rest.repository.ProjectRepository;
import lk.ijse.archi.rest.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveProject(ProjectDTO projectDTO) {

        Client client=new Client(
                projectDTO.getClientDTO().getEmail(),
                projectDTO.getClientDTO().getName(),
                projectDTO.getClientDTO().getPhone(),
                projectDTO.getClientDTO().getAddress()
        );

        Project project=new Project(projectDTO.getProjectId(),projectDTO.getProjectDetails(),projectDTO.getRequiredSkills(),
                client,
                projectDTO.getPaymentMethod(),
                projectDTO.getDuration(),
                projectDTO.getBudget()
        );

        projectRepository.save(project);
        return true;
    }

    @Override
    public ArrayList<ProjectDTO> getAllProjects() {

        List<Project>projectList=projectRepository.findAll();

        ArrayList<ProjectDTO>projectDTOS=new ArrayList<>();

        for (Project project : projectList) {
            ProjectDTO projectDTO=new ProjectDTO(
                    project.getProjectId(),
                    project.getProjectDetails(),
                    project.getRequiredSkills(),
                    new ClientDTO(
                            project.getClient().getEmail(),
                            project.getClient().getName(),
                            project.getClient().getPhone(),
                            project.getClient().getAddress()
                    ),
                    project.getPaymentMethod(),
                    project.getDuration(),
                    project.getBudget()
            );

            projectDTOS.add(projectDTO);
        }

        return projectDTOS;

    }

    @Override
    public ArrayList<ProjectDTO> getProjects(String email) {

        List<Project>projectList=projectRepository.getProjects(email);

        ArrayList<ProjectDTO>projectDTOS=new ArrayList<>();

        for (Project project : projectList) {
            ProjectDTO projectDTO=new ProjectDTO(
                    project.getProjectId(),
                    project.getProjectDetails(),
                    project.getRequiredSkills(),
                    new ClientDTO(
                            project.getClient().getEmail(),
                            project.getClient().getName(),
                            project.getClient().getPhone(),
                            project.getClient().getAddress()
                    ),
                    project.getPaymentMethod(),
                    project.getDuration(),
                    project.getBudget()
            );

            projectDTOS.add(projectDTO);
        }

        return projectDTOS;

    }

    @Override
    public ProjectDTO getProject(String projectID) {

        Project project=projectRepository.findById(projectID).get();
        return new ProjectDTO(
                project.getProjectId(),
                project.getProjectDetails(),
                project.getRequiredSkills(),
                new ClientDTO(
                        project.getClient().getEmail(),
                        project.getClient().getName(),
                        project.getClient().getPhone(),
                        project.getClient().getAddress()
                ),
                project.getPaymentMethod(),
                project.getDuration(),
                project.getBudget()
                );
    }
}
