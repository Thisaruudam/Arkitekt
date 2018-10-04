package lk.ijse.archi.rest.dto;

public class FreeLancerDTO {
    private int freeLancerID;
    private String email;
    private String name;
    private String phone;
    private String address;

    public FreeLancerDTO() {
    }

    public FreeLancerDTO(int freeLancerID, String email, String name, String phone, String address) {
        this.freeLancerID = freeLancerID;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public FreeLancerDTO(String email, String name, String phone, String address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getFreeLancerID() {
        return freeLancerID;
    }

    public void setFreeLancerID(int freeLancerID) {
        this.freeLancerID = freeLancerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
