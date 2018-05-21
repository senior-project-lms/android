package umtkas.com.lms.models;

import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = 4556897499041363554L;

    private String publicKey;

    private String username;

    private String name;
    private String surname;


    public User(String publicKey, String username, String name, String surname) {
        this.publicKey = publicKey;
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
