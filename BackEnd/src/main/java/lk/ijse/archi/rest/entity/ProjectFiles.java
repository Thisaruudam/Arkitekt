package lk.ijse.archi.rest.entity;

import javax.persistence.*;

@Entity
public class ProjectFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectFileID;
    private String projectId;
    private String filename;
    private String url;

    public ProjectFiles() {
    }

    public ProjectFiles(String projectId, String filename, String url) {
        this.projectId = projectId;
        this.filename = filename;
        this.url = url;
    }

    public ProjectFiles(int projectFileID, String projectId, String filename, String url) {
        this.projectFileID = projectFileID;
        this.projectId = projectId;
        this.filename = filename;
        this.url = url;
    }

    public int getProjectFileID() {
        return projectFileID;
    }

    public void setProjectFileID(int projectFileID) {
        this.projectFileID = projectFileID;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProjectFiles{" +
                "projectFileID=" + projectFileID +
                ", projectId='" + projectId + '\'' +
                ", filename='" + filename + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
