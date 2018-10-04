package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.HireDTO;
import lk.ijse.archi.rest.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/hire")
public class HireController {

    @Autowired
    private HireService hireService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean hire(@RequestBody HireDTO hireDTO){
        return hireService.hireFreelancer(hireDTO);
    }

}
