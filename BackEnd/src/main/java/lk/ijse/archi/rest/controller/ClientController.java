package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.ClientDTO;
import lk.ijse.archi.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "api/v1/clientSave",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveClient(@RequestBody ClientDTO clientDTO){
        return clientService.saveClient(clientDTO);
    }

    @PostMapping(value = "api/v1/clientGet",produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO getClient(@RequestParam("email") String email){
        return clientService.getClient(email);
    }

}
