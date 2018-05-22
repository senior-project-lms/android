package umtkas.com.lms.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Resource implements Serializable {


    private static final long serialVersionUID = 1563747927754467865L;

    @SerializedName("publicKey")
    private String publicKey;

    @SerializedName("url")
    private String url;

    @SerializedName("originalFileName")
    private String originalFileName;


    public Resource(String publicKey, String url, String originalFileName) {


        this.publicKey = publicKey;
        this.url = url;
        this.originalFileName = originalFileName;
    }


    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
}
