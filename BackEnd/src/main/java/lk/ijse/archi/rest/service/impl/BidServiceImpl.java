package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.BidDTO;
import lk.ijse.archi.rest.dto.ClientDTO;
import lk.ijse.archi.rest.dto.FreeLancerDTO;
import lk.ijse.archi.rest.dto.ProjectDTO;
import lk.ijse.archi.rest.entity.*;
import lk.ijse.archi.rest.repository.BidRepository;
import lk.ijse.archi.rest.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean placeBid(BidDTO bidDTO) {
        FreeLancer freeLancer = new FreeLancer(
                bidDTO.getFreeLancerDTO().getEmail(),
                bidDTO.getFreeLancerDTO().getName(),
                bidDTO.getFreeLancerDTO().getPhone(),
                bidDTO.getFreeLancerDTO().getAddress()
        );

        Client client=new Client(
                bidDTO.getProjectDTO().getClientDTO().getEmail(),
                bidDTO.getProjectDTO().getClientDTO().getName(),
                bidDTO.getProjectDTO().getClientDTO().getPhone(),
                bidDTO.getProjectDTO().getClientDTO().getAddress()
        );

        Project project=new Project(
                bidDTO.getProjectDTO().getProjectId(),
                bidDTO.getProjectDTO().getProjectDetails(),
                bidDTO.getProjectDTO().getRequiredSkills(),
                client,
                bidDTO.getProjectDTO().getPaymentMethod(),
                bidDTO.getProjectDTO().getDuration(),
                bidDTO.getProjectDTO().getBudget()
        );

        Bid bid = new Bid(bidDTO.getBidId(), freeLancer, project, bidDTO.getDaysToComplete(), bidDTO.getAmount());

        bidRepository.save(bid);
        return true;
    }

    @Override
    public ArrayList<BidDTO> getBidsForProject(String projectId) {

        List<Bid>bidList=bidRepository.getBIds(projectId);

        ArrayList<BidDTO>bidDTOS=new ArrayList<>();

        for (Bid bid : bidList) {

            BidDTO bidDTO=new BidDTO(
                    bid.getBidId(),
                    new FreeLancerDTO(
                            bid.getFreelancer().getEmail(),
                            bid.getFreelancer().getName(),
                            bid.getFreelancer().getPhone(),
                            bid.getFreelancer().getAddress()
                    ),
                    new ProjectDTO(
                            bid.getProject().getProjectId(),
                            bid.getProject().getProjectDetails(),
                            bid.getProject().getRequiredSkills(),
                            new ClientDTO(
                                    bid.getProject().getClient().getEmail(),
                                    bid.getProject().getClient().getName(),
                                    bid.getProject().getClient().getPhone(),
                                    bid.getProject().getClient().getAddress()
                            ),
                            bid.getProject().getPaymentMethod(),
                            bid.getProject().getDuration(),
                            bid.getProject().getBudget()
                    ),
                    bid.getDaysToComplete(),
                    bid.getAmount()
            );

            bidDTOS.add(bidDTO);

        }

        return bidDTOS;
    }
}
