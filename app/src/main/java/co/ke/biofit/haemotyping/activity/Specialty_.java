
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specialty_ {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private Description__ description;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("actor")
    @Expose
    private String actor;
    @SerializedName("actors")
    @Expose
    private String actors;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Specialty_() {
    }

    /**
     * 
     * @param actor
     * @param uid
     * @param actors
     * @param name
     * @param description
     * @param category
     */
    public Specialty_(String uid, String name, Description__ description, String category, String actor, String actors) {
        super();
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.actor = actor;
        this.actors = actors;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Description__ getDescription() {
        return description;
    }

    public void setDescription(Description__ description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

}
