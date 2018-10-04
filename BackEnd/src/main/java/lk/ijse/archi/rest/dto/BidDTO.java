package lk.ijse.archi.rest.dto;

public class BidDTO {
    private String bidId;
    private FreeLancerDTO freeLancerDTO;
    private ProjectDTO projectDTO;
    private String daysToComplete;
    private double amount;

    public BidDTO() {
    }

    public BidDTO(String bidId, FreeLancerDTO freeLancerDTO, ProjectDTO projectDTO, String daysToComplete, double amount) {
        this.bidId = bidId;
        this.freeLancerDTO = freeLancerDTO;
        this.projectDTO = projectDTO;
        this.daysToComplete = daysToComplete;
        this.amount = amount;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public FreeLancerDTO getFreeLancerDTO() {
        return freeLancerDTO;
    }

    public void setFreeLancerDTO(FreeLancerDTO freeLancerDTO) {
        this.freeLancerDTO = freeLancerDTO;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public String getDaysToComplete() {
        return daysToComplete;
    }

    public void setDaysToComplete(String daysToComplete) {
        this.daysToComplete = daysToComplete;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
