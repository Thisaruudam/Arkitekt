package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.FreeLancerDTO;
import lk.ijse.archi.rest.service.FreeLancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/freeLancer")
public class FreeLancerController {

    @Autowired
    private FreeLancerService freeLancerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFreelancer(@RequestBody FreeLancerDTO freeLancerDTO){
        return freeLancerService.saveFreelancer(freeLancerDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FreeLancerDTO getFreelancer(@RequestParam("email") String email){
        return freeLancerService.getFreelancer(email);
    }

}
