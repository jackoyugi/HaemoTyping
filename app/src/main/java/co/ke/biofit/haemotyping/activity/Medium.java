
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("versions")
    @Expose
    private Versions versions;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param uid
     * @param versions
     * @param url
     * @param status
     * @param tags
     */
    public Medium(String uid, String status, String url, List<String> tags, Versions versions) {
        super();
        this.uid = uid;
        this.status = status;
        this.url = url;
        this.tags = tags;
        this.versions = versions;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

}
