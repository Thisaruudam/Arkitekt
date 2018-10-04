package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.NotificationDTO;
import lk.ijse.archi.rest.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "api/v1/notify",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NotificationDTO> getAllNotifications(@RequestParam("id") String freelancerId){
        return notificationService.getAllNotification(freelancerId);
    }

}
