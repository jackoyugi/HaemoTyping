
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address__ {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lon")
    @Expose
    private Integer lon;
    @SerializedName("slug")
    @Expose
    private Slug___ slug;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("state_long")
    @Expose
    private String stateLong;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("street2")
    @Expose
    private String street2;
    @SerializedName("zip")
    @Expose
    private String zip;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address__() {
    }

    /**
     * 
     * @param zip
     * @param city
     * @param stateLong
     * @param street
     * @param lon
     * @param state
     * @param street2
     * @param lat
     * @param slug
     */
    public Address__(String city, Integer lat, Integer lon, Slug___ slug, String state, String stateLong, String street, String street2, String zip) {
        super();
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.slug = slug;
        this.state = state;
        this.stateLong = stateLong;
        this.street = street;
        this.street2 = street2;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Slug___ getSlug() {
        return slug;
    }

    public void setSlug(Slug___ slug) {
        this.slug = slug;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateLong() {
        return stateLong;
    }

    public void setStateLong(String stateLong) {
        this.stateLong = stateLong;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
