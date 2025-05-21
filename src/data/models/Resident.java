package data.models;

public class Resident {
        private String FullName;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

        private String address;
        private int id;
        private String phoneNumber;
        private String email;
        private String occupation;
        private Visitor visitor;
        private AccessCode accessCode;
        private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
