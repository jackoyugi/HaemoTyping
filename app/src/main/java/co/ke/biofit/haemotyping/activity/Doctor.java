
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("educations")
    @Expose
    private List<Education> educations = null;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("ratings")
    @Expose
    private List<Rating> ratings = null;
    @SerializedName("insurances")
    @Expose
    private List<Insurance> insurances = null;
    @SerializedName("specialties")
    @Expose
    private List<Specialty> specialties = null;
    @SerializedName("hospital_affiliations")
    @Expose
    private List<HospitalAffiliation> hospitalAffiliations = null;
    @SerializedName("group_affiliations")
    @Expose
    private List<GroupAffiliation> groupAffiliations = null;
    @SerializedName("claims")
    @Expose
    private List<Claim> claims = null;
    @SerializedName("licenses")
    @Expose
    private List<License> licenses = null;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("npi")
    @Expose
    private String npi;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Doctor() {
    }

    /**
     * 
     * @param uid
     * @param specialties
     * @param hospitalAffiliations
     * @param licenses
     * @param insurances
     * @param groupAffiliations
     * @param ratings
     * @param npi
     * @param profile
     * @param claims
     * @param educations
     */
    public Doctor(List<Education> educations, Profile profile, List<Rating> ratings, List<Insurance> insurances, List<Specialty> specialties, List<HospitalAffiliation> hospitalAffiliations, List<GroupAffiliation> groupAffiliations, List<Claim> claims, List<License> licenses, String uid, String npi) {
        super();
        this.educations = educations;
        this.profile = profile;
        this.ratings = ratings;
        this.insurances = insurances;
        this.specialties = specialties;
        this.hospitalAffiliations = hospitalAffiliations;
        this.groupAffiliations = groupAffiliations;
        this.claims = claims;
        this.licenses = licenses;
        this.uid = uid;
        this.npi = npi;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public List<HospitalAffiliation> getHospitalAffiliations() {
        return hospitalAffiliations;
    }

    public void setHospitalAffiliations(List<HospitalAffiliation> hospitalAffiliations) {
        this.hospitalAffiliations = hospitalAffiliations;
    }

    public List<GroupAffiliation> getGroupAffiliations() {
        return groupAffiliations;
    }

    public void setGroupAffiliations(List<GroupAffiliation> groupAffiliations) {
        this.groupAffiliations = groupAffiliations;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

}
