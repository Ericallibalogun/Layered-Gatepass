package dtos.responses;

public class LoginResidentResponse {
    private int id;
    private String fullName;
    private String message;

    public LoginResidentResponse(int id, String fullName, String message) {
        this.id = id;
        this.fullName = fullName;
        this.message = message;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getMessage() { return message; }
}
