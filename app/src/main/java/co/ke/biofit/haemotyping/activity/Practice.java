
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Practice {

    @SerializedName("location_slug")
    @Expose
    private String locationSlug;
    @SerializedName("within_search_area")
    @Expose
    private Boolean withinSearchArea;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lon")
    @Expose
    private Integer lon;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("npi")
    @Expose
    private Npi npi;
    @SerializedName("tin")
    @Expose
    private Tin tin;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("website")
    @Expose
    private Website website;
    @SerializedName("email")
    @Expose
    private Email email;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("accepts_new_patients")
    @Expose
    private Boolean acceptsNewPatients;
    @SerializedName("image_urls")
    @Expose
    private List<String> imageUrls = null;
    @SerializedName("insurance_uids")
    @Expose
    private List<String> insuranceUids = null;
    @SerializedName("visit_address")
    @Expose
    private VisitAddress visitAddress;
    @SerializedName("office_hours")
    @Expose
    private List<String> officeHours = null;
    @SerializedName("phones")
    @Expose
    private List<Phone> phones = null;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("media")
    @Expose
    private List<Medium> media = null;
    @SerializedName("total_doctors")
    @Expose
    private Integer totalDoctors;
    @SerializedName("doctors_pagination_url")
    @Expose
    private String doctorsPaginationUrl;
    @SerializedName("doctors")
    @Expose
    private List<Doctor> doctors = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Practice() {
    }

    /**
     * 
     * @param website
     * @param acceptsNewPatients
     * @param insuranceUids
     * @param distance
     * @param languages
     * @param locationSlug
     * @param npi
     * @param totalDoctors
     * @param description
     * @param phones
     * @param lon
     * @param officeHours
     * @param media
     * @param uid
     * @param doctors
     * @param imageUrls
     * @param withinSearchArea
     * @param tin
     * @param name
     * @param lat
     * @param slug
     * @param email
     * @param visitAddress
     * @param doctorsPaginationUrl
     */
    public Practice(String locationSlug, Boolean withinSearchArea, Integer distance, Integer lat, Integer lon, String uid, Npi npi, Tin tin, String slug, String name, Website website, Email email, Description description, Boolean acceptsNewPatients, List<String> imageUrls, List<String> insuranceUids, VisitAddress visitAddress, List<String> officeHours, List<Phone> phones, List<Language> languages, List<Medium> media, Integer totalDoctors, String doctorsPaginationUrl, List<Doctor> doctors) {
        super();
        this.locationSlug = locationSlug;
        this.withinSearchArea = withinSearchArea;
        this.distance = distance;
        this.lat = lat;
        this.lon = lon;
        this.uid = uid;
        this.npi = npi;
        this.tin = tin;
        this.slug = slug;
        this.name = name;
        this.website = website;
        this.email = email;
        this.description = description;
        this.acceptsNewPatients = acceptsNewPatients;
        this.imageUrls = imageUrls;
        this.insuranceUids = insuranceUids;
        this.visitAddress = visitAddress;
        this.officeHours = officeHours;
        this.phones = phones;
        this.languages = languages;
        this.media = media;
        this.totalDoctors = totalDoctors;
        this.doctorsPaginationUrl = doctorsPaginationUrl;
        this.doctors = doctors;
    }

    public String getLocationSlug() {
        return locationSlug;
    }

    public void setLocationSlug(String locationSlug) {
        this.locationSlug = locationSlug;
    }

    public Boolean getWithinSearchArea() {
        return withinSearchArea;
    }

    public void setWithinSearchArea(Boolean withinSearchArea) {
        this.withinSearchArea = withinSearchArea;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Npi getNpi() {
        return npi;
    }

    public void setNpi(Npi npi) {
        this.npi = npi;
    }

    public Tin getTin() {
        return tin;
    }

    public void setTin(Tin tin) {
        this.tin = tin;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Boolean getAcceptsNewPatients() {
        return acceptsNewPatients;
    }

    public void setAcceptsNewPatients(Boolean acceptsNewPatients) {
        this.acceptsNewPatients = acceptsNewPatients;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getInsuranceUids() {
        return insuranceUids;
    }

    public void setInsuranceUids(List<String> insuranceUids) {
        this.insuranceUids = insuranceUids;
    }

    public VisitAddress getVisitAddress() {
        return visitAddress;
    }

    public void setVisitAddress(VisitAddress visitAddress) {
        this.visitAddress = visitAddress;
    }

    public List<String> getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(List<String> officeHours) {
        this.officeHours = officeHours;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public Integer getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(Integer totalDoctors) {
        this.totalDoctors = totalDoctors;
    }

    public String getDoctorsPaginationUrl() {
        return doctorsPaginationUrl;
    }

    public void setDoctorsPaginationUrl(String doctorsPaginationUrl) {
        this.doctorsPaginationUrl = doctorsPaginationUrl;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
