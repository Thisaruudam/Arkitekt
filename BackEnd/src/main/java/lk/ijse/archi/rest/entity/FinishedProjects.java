package lk.ijse.archi.rest.entity;

import javax.persistence.*;

@Entity
public class FinishedProjects {

    @Id
    private String projectId;
    private String projectDetails;
    private String requiredSkills;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientID",referencedColumnName = "email")
    private Client client;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "freeLancerID",referencedColumnName = "email")
    private FreeLancer freelancer;
    private String paymentMethod;
    private String duration;
    private String budget;

    public FinishedProjects() {
    }

    public FinishedProjects(String projectId, String projectDetails, String requiredSkills, Client client, FreeLancer freelancer, String paymentMethod, String duration, String budget) {
        this.projectId = projectId;
        this.projectDetails = projectDetails;
        this.requiredSkills = requiredSkills;
        this.client = client;
        this.freelancer = freelancer;
        this.paymentMethod = paymentMethod;
        this.duration = duration;
        this.budget = budget;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public FreeLancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreeLancer freelancer) {
        this.freelancer = freelancer;
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

    @Override
    public String toString() {
        return "FinishedProjects{" +
                "projectId='" + projectId + '\'' +
                ", projectDetails='" + projectDetails + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", client=" + client +
                ", freelancer=" + freelancer +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", duration='" + duration + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
