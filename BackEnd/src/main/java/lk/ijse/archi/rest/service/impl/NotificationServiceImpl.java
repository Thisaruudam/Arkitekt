package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.ClientDTO;
import lk.ijse.archi.rest.dto.FreeLancerDTO;
import lk.ijse.archi.rest.dto.NotificationDTO;
import lk.ijse.archi.rest.entity.Notifications;
import lk.ijse.archi.rest.repository.NotificationsRepository;
import lk.ijse.archi.rest.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Override
    public List<NotificationDTO> getAllNotification(String freelancerID) {

        List<Notifications> notificationsList = notificationsRepository.getNotificationsById(freelancerID);

        List<NotificationDTO> notificationDTOS = new ArrayList<>();

        for (Notifications notifications : notificationsList) {
            NotificationDTO notificationDTO = new NotificationDTO(
                    new ClientDTO(
                            notifications.getClient().getEmail(),
                            notifications.getClient().getName(),
                            notifications.getClient().getPhone(),
                            notifications.getClient().getAddress()
                    ),
                    new FreeLancerDTO(
                            notifications.getFreelancer().getEmail(),
                            notifications.getFreelancer().getName(),
                            notifications.getFreelancer().getPhone(),
                            notifications.getFreelancer().getAddress()
                    ),
                    notifications.getProjectId()
            );

            notificationDTOS.add(notificationDTO);
        }

        return notificationDTOS;
    }
}
