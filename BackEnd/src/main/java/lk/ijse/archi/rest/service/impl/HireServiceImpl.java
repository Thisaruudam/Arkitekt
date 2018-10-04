package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.HireDTO;
import lk.ijse.archi.rest.entity.*;
import lk.ijse.archi.rest.repository.*;
import lk.ijse.archi.rest.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class HireServiceImpl implements HireService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private FinishedProjectRepository finishedProjectRepository;

    @Autowired
    private FreeLancerRepository freeLancerRepository;

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Override
    public boolean hireFreelancer(HireDTO hireDTO) {

        Date date=new Date();

        Project project=projectRepository.findById(hireDTO.getProjectId()).get();

        FreeLancer freeLancer=freeLancerRepository.findById(hireDTO.getFreelancerId()).get();

        FinishedProjects finishedProjects=new FinishedProjects(
                project.getProjectId(),
                project.getProjectDetails(),
                project.getRequiredSkills(),
                new Client(
                        project.getClient().getEmail(),
                        project.getClient().getName(),
                        project.getClient().getPhone(),
                        project.getClient().getAddress()
                ),
                new FreeLancer(
                        freeLancer.getEmail(),
                        freeLancer.getName(),
                        freeLancer.getPhone(),
                        freeLancer.getAddress()
                ),
                project.getPaymentMethod(),
                project.getDuration(),
                project.getBudget()
        );

        Notifications notifications=new Notifications(
                0,
                new Client(
                        project.getClient().getEmail(),
                        project.getClient().getName(),
                        project.getClient().getPhone(),
                        project.getClient().getAddress()
                ),
                new FreeLancer(
                        freeLancer.getEmail(),
                        freeLancer.getName(),
                        freeLancer.getPhone(),
                        freeLancer.getAddress()
                ),
                project.getProjectId(),
                date
        );

//        finishedProjectRepository.save(finishedProjects);
//
        notificationsRepository.save(notifications);
//
//        bidRepository.deleteInBatch(bidRepository.getBIds(hireDTO.getProjectId()));
//
//        projectRepository.deleteById(hireDTO.getProjectId());

        return true;
    }
}
