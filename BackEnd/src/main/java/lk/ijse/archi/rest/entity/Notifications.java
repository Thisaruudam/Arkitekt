package lk.ijse.archi.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int id;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientID",referencedColumnName = "email")
    private Client client;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "freeLancerID",referencedColumnName = "email")
    private FreeLancer freelancer;
    private String projectId;
    private Date createdAt;

    public Notifications(Client client, FreeLancer freelancer, String projectId, Date createdAt) {
        this.client = client;
        this.freelancer = freelancer;
        this.projectId = projectId;
        this.setCreatedAt(createdAt);
    }

    public Notifications() {
    }

    public Notifications(int id,Client client, FreeLancer freelancer, String projectId,Date createdAt) {
        this.setId(id);
        this.setClient(client);
        this.setFreelancer(freelancer);
        this.setProjectId(projectId);
        this.setCreatedAt(createdAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", client=" + client +
                ", freelancer=" + freelancer +
                ", projectId='" + projectId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
