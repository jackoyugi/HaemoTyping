
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Versions {

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("thumbnail2x")
    @Expose
    private String thumbnail2x;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("hero")
    @Expose
    private String hero;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Versions() {
    }

    /**
     * 
     * @param small
     * @param thumbnail
     * @param large
     * @param hero
     * @param medium
     * @param thumbnail2x
     */
    public Versions(String thumbnail, String thumbnail2x, String small, String medium, String large, String hero) {
        super();
        this.thumbnail = thumbnail;
        this.thumbnail2x = thumbnail2x;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.hero = hero;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail2x() {
        return thumbnail2x;
    }

    public void setThumbnail2x(String thumbnail2x) {
        this.thumbnail2x = thumbnail2x;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

}
