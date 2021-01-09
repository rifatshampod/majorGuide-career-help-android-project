package fsktm.um.edu.mymajor;

public class AgentModel {
    private String name;
    private String description;
    private String email;
    private String location;
    private String phoneNumber;

    public AgentModel() {

    }

    public AgentModel(String name, String description, String email, String location, String phoneNumber) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
