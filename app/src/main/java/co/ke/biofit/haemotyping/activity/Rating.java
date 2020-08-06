
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("provider_uid")
    @Expose
    private String providerUid;
    @SerializedName("provider_url")
    @Expose
    private String providerUrl;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("image_url_small")
    @Expose
    private String imageUrlSmall;
    @SerializedName("image_url_small_2x")
    @Expose
    private String imageUrlSmall2x;
    @SerializedName("image_url_large")
    @Expose
    private String imageUrlLarge;
    @SerializedName("image_url_large_2x")
    @Expose
    private String imageUrlLarge2x;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rating() {
    }

    /**
     * 
     * @param imageUrlLarge
     * @param provider
     * @param reviewCount
     * @param imageUrlLarge2x
     * @param rating
     * @param active
     * @param imageUrlSmall2x
     * @param imageUrlSmall
     * @param providerUrl
     * @param providerUid
     */
    public Rating(Boolean active, String provider, String providerUid, String providerUrl, Integer rating, Integer reviewCount, String imageUrlSmall, String imageUrlSmall2x, String imageUrlLarge, String imageUrlLarge2x) {
        super();
        this.active = active;
        this.provider = provider;
        this.providerUid = providerUid;
        this.providerUrl = providerUrl;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.imageUrlSmall = imageUrlSmall;
        this.imageUrlSmall2x = imageUrlSmall2x;
        this.imageUrlLarge = imageUrlLarge;
        this.imageUrlLarge2x = imageUrlLarge2x;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderUid() {
        return providerUid;
    }

    public void setProviderUid(String providerUid) {
        this.providerUid = providerUid;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getImageUrlSmall() {
        return imageUrlSmall;
    }

    public void setImageUrlSmall(String imageUrlSmall) {
        this.imageUrlSmall = imageUrlSmall;
    }

    public String getImageUrlSmall2x() {
        return imageUrlSmall2x;
    }

    public void setImageUrlSmall2x(String imageUrlSmall2x) {
        this.imageUrlSmall2x = imageUrlSmall2x;
    }

    public String getImageUrlLarge() {
        return imageUrlLarge;
    }

    public void setImageUrlLarge(String imageUrlLarge) {
        this.imageUrlLarge = imageUrlLarge;
    }

    public String getImageUrlLarge2x() {
        return imageUrlLarge2x;
    }

    public void setImageUrlLarge2x(String imageUrlLarge2x) {
        this.imageUrlLarge2x = imageUrlLarge2x;
    }

}
