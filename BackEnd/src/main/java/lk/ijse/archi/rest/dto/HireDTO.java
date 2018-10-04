package lk.ijse.archi.rest.dto;

public class HireDTO {
    private String projectId;
    private String freelancerId;

    public HireDTO() {
    }

    public HireDTO(String projectId, String freelancerId) {
        this.projectId = projectId;
        this.freelancerId = freelancerId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }
}
