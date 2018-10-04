package lk.ijse.archi.rest.dto;

public class ProjectDTO {
    private String projectId;
    private String projectDetails;
    private String requiredSkills;
    private ClientDTO clientDTO;
    private String paymentMethod;
    private String duration;
    private String budget;

    public ProjectDTO(String projectId, String projectDetails, String requiredSkills, ClientDTO clientDTO, String paymentMethod, String duration, String budget) {
        this.setProjectId(projectId);
        this.setProjectDetails(projectDetails);
        this.setRequiredSkills(requiredSkills);
        this.setClientDTO(clientDTO);
        this.setPaymentMethod(paymentMethod);
        this.setDuration(duration);
        this.setBudget(budget);
    }

    public ProjectDTO() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
