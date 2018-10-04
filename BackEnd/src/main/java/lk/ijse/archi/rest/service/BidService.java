package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.BidDTO;

import java.util.ArrayList;

public interface BidService {

    public boolean placeBid(BidDTO bidDTO);

    public ArrayList<BidDTO> getBidsForProject(String projectId);

}
