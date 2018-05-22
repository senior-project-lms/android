package umtkas.com.lms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Grade implements Serializable {


    private static final long serialVersionUID = -2772008447545907956L;

    @SerializedName("publicKey")
    private String publicKey;
    @SerializedName("name")
    private String name;
    @SerializedName("score")
    private double score;
    @SerializedName("average")
    private double average;
    @SerializedName("maxScore")
    private double maxScore;
    @SerializedName("weight")
    private double weight;

    public Grade(String name, double score, double maxScore, double average, double weight) {
        this.name = name;
        this.score = score;
        this.maxScore = maxScore;
        this.average = average;
        this.weight = weight;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }
}
