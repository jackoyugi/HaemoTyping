
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("practices")
    @Expose
    private List<Practice> practices = null;
    @SerializedName("educations")
    @Expose
    private List<Education_> educations = null;
    @SerializedName("profile")
    @Expose
    private Profile_ profile;
    @SerializedName("ratings")
    @Expose
    private List<Rating_> ratings = null;
    @SerializedName("insurances")
    @Expose
    private List<Insurance_> insurances = null;
    @SerializedName("specialties")
    @Expose
    private List<Specialty_> specialties = null;
    @SerializedName("hospital_affiliations")
    @Expose
    private List<HospitalAffiliation_> hospitalAffiliations = null;
    @SerializedName("group_affiliations")
    @Expose
    private List<GroupAffiliation_> groupAffiliations = null;
    @SerializedName("claims")
    @Expose
    private List<Claim_> claims = null;
    @SerializedName("licenses")
    @Expose
    private List<License_> licenses = null;
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
    public Datum() {
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
     * @param practices
     */
    public Datum(List<Practice> practices, List<Education_> educations, Profile_ profile, List<Rating_> ratings, List<Insurance_> insurances, List<Specialty_> specialties, List<HospitalAffiliation_> hospitalAffiliations, List<GroupAffiliation_> groupAffiliations, List<Claim_> claims, List<License_> licenses, String uid, String npi) {
        super();
        this.practices = practices;
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

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public List<Education_> getEducations() {
        return educations;
    }

    public void setEducations(List<Education_> educations) {
        this.educations = educations;
    }

    public Profile_ getProfile() {
        return profile;
    }

    public void setProfile(Profile_ profile) {
        this.profile = profile;
    }

    public List<Rating_> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating_> ratings) {
        this.ratings = ratings;
    }

    public List<Insurance_> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance_> insurances) {
        this.insurances = insurances;
    }

    public List<Specialty_> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty_> specialties) {
        this.specialties = specialties;
    }

    public List<HospitalAffiliation_> getHospitalAffiliations() {
        return hospitalAffiliations;
    }

    public void setHospitalAffiliations(List<HospitalAffiliation_> hospitalAffiliations) {
        this.hospitalAffiliations = hospitalAffiliations;
    }

    public List<GroupAffiliation_> getGroupAffiliations() {
        return groupAffiliations;
    }

    public void setGroupAffiliations(List<GroupAffiliation_> groupAffiliations) {
        this.groupAffiliations = groupAffiliations;
    }

    public List<Claim_> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim_> claims) {
        this.claims = claims;
    }

    public List<License_> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License_> licenses) {
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
