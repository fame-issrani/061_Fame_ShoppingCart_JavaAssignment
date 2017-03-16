package Domain;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class User {
    private int userId;
    private String name;
    private String address;
    private String email;

    public User() {
    }

    public User(int userId, String name, String address, String email) {
        this.userId=userId;
        this.name = name;
        this.address = address;
        this.email = email;
    }

public User(String name, String address, String email) {
    this.name = name;
    this.address = address;
    this.email = email;
}

public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
