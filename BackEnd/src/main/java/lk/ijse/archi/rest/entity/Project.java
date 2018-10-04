package lk.ijse.archi.rest.entity;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    private String projectId;
    private String projectDetails;
    private String requiredSkills;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientID",referencedColumnName = "email")
    private Client client;
    private String paymentMethod;
    private String duration;
    private String budget;

    public Project(String projectId, String projectDetails, String requiredSkills, Client client, String paymentMethod, String duration, String budget) {
        this.setProjectId(projectId);
        this.setProjectDetails(projectDetails);
        this.setRequiredSkills(requiredSkills);
        this.setClient(client);
        this.setPaymentMethod(paymentMethod);
        this.setDuration(duration);
        this.setBudget(budget);
    }

    public Project() {
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
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectDetails='" + projectDetails + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", clientDTO=" + client.getAddress() +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", duration='" + duration + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
