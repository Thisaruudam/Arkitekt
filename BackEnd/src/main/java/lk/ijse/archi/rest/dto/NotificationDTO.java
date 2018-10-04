package lk.ijse.archi.rest.dto;

public class NotificationDTO {

    private ClientDTO clientDTO;
    private FreeLancerDTO freeLancerDTO;
    private String projectID;

    public NotificationDTO() {
    }

    public NotificationDTO(ClientDTO clientDTO, FreeLancerDTO freeLancerDTO, String projectID) {
        this.clientDTO = clientDTO;
        this.freeLancerDTO = freeLancerDTO;
        this.projectID = projectID;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public FreeLancerDTO getFreeLancerDTO() {
        return freeLancerDTO;
    }

    public void setFreeLancerDTO(FreeLancerDTO freeLancerDTO) {
        this.freeLancerDTO = freeLancerDTO;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
}
