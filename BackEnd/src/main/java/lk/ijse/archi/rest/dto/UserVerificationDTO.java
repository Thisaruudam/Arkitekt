package lk.ijse.archi.rest.dto;

public class UserVerificationDTO {
    private String email;
    private String isAdmin;
    private String isClient;

    public UserVerificationDTO() {
    }

    public UserVerificationDTO(String email, String isAdmin, String isClient) {
        this.email = email;
        this.isAdmin = isAdmin;
        this.isClient = isClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsClient() {
        return isClient;
    }

    public void setIsClient(String isClient) {
        this.isClient = isClient;
    }
}
