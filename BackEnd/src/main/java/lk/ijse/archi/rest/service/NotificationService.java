package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {

    public List<NotificationDTO> getAllNotification(String freelancerID);

}
