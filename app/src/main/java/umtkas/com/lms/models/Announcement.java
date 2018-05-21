package umtkas.com.lms.models;

import java.io.Serializable;
import java.util.Date;

public class Announcement implements Serializable {

    private static final long serialVersionUID = 2893075226293359287L;

    private String publicKey;
    private String title;
    private String content;
    private Date createdAt;
    private User createdBy;


    public Announcement(String publicKey, String title, String content, Date createdAt, User createdBy) {
        this.publicKey = publicKey;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
