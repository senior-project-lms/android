package umtkas.com.lms.models;

import java.io.Serializable;
import java.util.Random;

public class Course implements Serializable {


    private static final long serialVersionUID = -8626579255963630342L;


    private String publicKey;

    private String name;

    private int notifications;


    public Course(String publicKey, String name) {
        this.publicKey = publicKey;
        this.name = name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNotifications() {
        return new Random().nextInt(10);
        //return notifications;
    }

    public void setNotifications(int notifications) {
        this.notifications = notifications;
    }
}
