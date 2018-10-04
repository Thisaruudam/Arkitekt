package lk.ijse.archi.rest.entity;

import javax.persistence.*;

@Entity
public class Bid {
    @Id
    private String bidId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "freeLancerID",referencedColumnName = "email")
    private FreeLancer freelancer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID",referencedColumnName = "projectId")
    private Project project;
    private String daysToComplete;
    private double amount;

    public Bid(String bidId, FreeLancer freelancer, Project project, String daysToComplete, double amount) {
        this.bidId = bidId;
        this.freelancer = freelancer;
        this.project = project;
        this.daysToComplete = daysToComplete;
        this.amount = amount;
    }

    public Bid() {
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public FreeLancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreeLancer freelancer) {
        this.freelancer = freelancer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    @Override
    public String toString() {
        return "Bid{" +
                "bidId='" + bidId + '\'' +
                ", freelancer=" + freelancer +
                ", project=" + project +
                ", daysToComplete='" + daysToComplete + '\'' +
                ", amount=" + amount +
                '}';
    }
}
