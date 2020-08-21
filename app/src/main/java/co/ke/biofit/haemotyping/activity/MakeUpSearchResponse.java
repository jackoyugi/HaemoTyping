
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MakeUpSearchResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("price_sign")
    @Expose
    private String priceSign; //changed
    @SerializedName("currency")
    @Expose
    private String currency; //changed
    @SerializedName("image_link")
    @Expose
    private String imageLink;
    @SerializedName("product_link")
    @Expose
    private String productLink;
    @SerializedName("website_link")
    @Expose
    private String websiteLink;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("category")
    @Expose
    private String category; //changed
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("tag_list")
    @Expose
    private List<String> tagList = null; //changed
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("product_api_url")
    @Expose
    private String productApiUrl;
    @SerializedName("api_featured_image")
    @Expose
    private String apiFeaturedImage;
    @SerializedName("product_colors")
    @Expose
    private List<ProductColor> productColors = null;

    /**
     * No args constructor for use in serialization
     *
     * @param name
     * @param brand
     * @param apiFeaturedImage
     */
    public MakeUpSearchResponse() {
    }


    /**
     * @param brand
     * @param name
     * @param price
     */


    public MakeUpSearchResponse(int id, String brand, String name, String price, String priceSign, String currency, String imageLink, String productLink, String websiteLink,
    String description, Double rating, String category, String productType, List tagList, String createdAt, String updatedAt, String productApiUrl, String apiFeaturedImage,  List productColors  ) {
        super();
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.priceSign = priceSign;
        this.currency = currency;
        this.imageLink = imageLink;
        this.productLink = productLink;
        this.websiteLink = websiteLink;
        this.description = description;
        this.rating =  rating;
        this.category = category;
        this.productType = productType;
        this.tagList = tagList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productApiUrl = productApiUrl;
        this.apiFeaturedImage = apiFeaturedImage;
        this.productColors = productColors;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSign() {
        return priceSign;
    }

    public String setPriceSign(String priceSign) {  //changed
        return priceSign = priceSign;
    } //changed

    public String getCurrency() {
        return currency;
    } //changed

    public String setCurrency(String currency) {
        return currency = currency; // changed
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    } //changed

    public String setCategory(String category) { //changed
        return this.category = category;
    } //changed

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;  //changed
    }

    public List<String> getTagList() {
        return tagList;
    }

    public List<String> setTagList(List<String> tagList) {   //changed
        return  tagList = tagList;
    } //changed

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        createdAt = createdAt;
    } //changed

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProductApiUrl() {
        return productApiUrl;
    }

    public void setProductApiUrl(String productApiUrl) {
        this.productApiUrl = productApiUrl;
    }

    public String getApiFeaturedImage() {
        return apiFeaturedImage;
    }

    public void setApiFeaturedImage(String apiFeaturedImage) {
        this.apiFeaturedImage = apiFeaturedImage;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }


}
