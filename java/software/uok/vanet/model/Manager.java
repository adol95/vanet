package software.uok.vanet.model;

/**
 * Created by Mr648 on 5/4/2017.
 */
public class Manager extends RealPerson {
    protected String username;
    protected String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
