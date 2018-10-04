package lk.ijse.archi.rest.dto;

public class Message {

    private String message;
    private String time;

    public Message() {
    }

    public Message(String message, String time) {
        this.setMessage(message);
        this.setTime(time);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
