
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private MiddleName middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("languages")
    @Expose
    private List<Language_> languages = null;
    @SerializedName("bio")
    @Expose
    private String bio;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Profile() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param gender
     * @param languages
     * @param imageUrl
     * @param bio
     * @param middleName
     * @param title
     * @param slug
     */
    public Profile(String firstName, MiddleName middleName, String lastName, String slug, String title, String imageUrl, String gender, List<Language_> languages, String bio) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.slug = slug;
        this.title = title;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.languages = languages;
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public MiddleName getMiddleName() {
        return middleName;
    }

    public void setMiddleName(MiddleName middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Language_> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language_> languages) {
        this.languages = languages;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
