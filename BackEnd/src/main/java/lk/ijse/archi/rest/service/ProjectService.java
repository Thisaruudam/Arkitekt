package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.ProjectDTO;

import java.util.ArrayList;

public interface ProjectService {

    public boolean saveProject(ProjectDTO projectDTO);

    public ArrayList<ProjectDTO> getAllProjects();

    public ArrayList<ProjectDTO> getProjects(String email);

    public ProjectDTO getProject(String projectID);

}
