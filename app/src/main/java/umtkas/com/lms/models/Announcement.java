package umtkas.com.lms.models;

import com.google.gson.annotations.SerializedName;

import org.jsoup.Jsoup;

import java.io.Serializable;
import java.util.Date;

public class Announcement implements Serializable {

    private static final long serialVersionUID = 2893075226293359287L;

    @SerializedName("publicKey")
    private String publicKey;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("createdBy")
    private User createdBy;


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
        return Jsoup.parse(content).text();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        long time = Long.parseLong(createdAt);

        return new Date(time);
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
