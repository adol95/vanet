package software.uok.vanet.model;

import java.util.Date;

/**
 * Created by Mr648 on 5/3/2017.
 */
public class LoginInfo {

    private int id;
    private int clerkId;
    private Date logingInTime;
    private Date logingOutTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }

    public Date getLogingInTime() {
        return logingInTime;
    }

    public void setLogingInTime(Date logingInTime) {
        this.logingInTime = logingInTime;
    }

    public Date getLogingOutTime() {
        return logingOutTime;
    }

    public void setLogingOutTime(Date logingOutTime) {
        this.logingOutTime = logingOutTime;
    }
}
