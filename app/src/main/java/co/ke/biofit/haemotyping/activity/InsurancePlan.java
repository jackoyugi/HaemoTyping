
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsurancePlan {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private List<String> category = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InsurancePlan() {
    }

    /**
     * 
     * @param uid
     * @param name
     * @param category
     */
    public InsurancePlan(String uid, String name, List<String> category) {
        super();
        this.uid = uid;
        this.name = name;
        this.category = category;
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

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

}
