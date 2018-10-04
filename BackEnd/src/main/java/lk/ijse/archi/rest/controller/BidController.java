package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.BidDTO;
import lk.ijse.archi.rest.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeBid(@RequestBody BidDTO bidDTO){
        return bidService.placeBid(bidDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<BidDTO> getBidsForProject(@RequestParam("projectID") String projectID){
        return bidService.getBidsForProject(projectID);
    }

}
