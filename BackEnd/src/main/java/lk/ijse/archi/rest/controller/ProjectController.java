package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.ProjectDTO;
import lk.ijse.archi.rest.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "api/v1/project",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveProject(@RequestBody ProjectDTO projectDTO){
        return projectService.saveProject(projectDTO);
    }

    @GetMapping(value = "api/v1/project",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping(value = "api/v1/getProjects",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProjectDTO> getProjects(@RequestParam("email") String email){
        return projectService.getProjects(email);
    }

    @GetMapping(value = "api/v1/getProject",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDTO getProject(@RequestParam("projectId") String projectID){
        return projectService.getProject(projectID);
    }

}
