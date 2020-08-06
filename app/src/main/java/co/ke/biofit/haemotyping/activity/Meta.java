
package co.ke.biofit.haemotyping.activity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("data_type")
    @Expose
    private String dataType;
    @SerializedName("item_type")
    @Expose
    private String itemType;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("skip")
    @Expose
    private Integer skip;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("fields_requested")
    @Expose
    private String fieldsRequested;
    @SerializedName("ignored_query_parameters")
    @Expose
    private List<String> ignoredQueryParameters = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param itemType
     * @param total
     * @param dataType
     * @param count
     * @param limit
     * @param skip
     * @param fieldsRequested
     * @param ignoredQueryParameters
     */
    public Meta(String dataType, String itemType, Integer total, Integer count, Integer skip, Integer limit, String fieldsRequested, List<String> ignoredQueryParameters) {
        super();
        this.dataType = dataType;
        this.itemType = itemType;
        this.total = total;
        this.count = count;
        this.skip = skip;
        this.limit = limit;
        this.fieldsRequested = fieldsRequested;
        this.ignoredQueryParameters = ignoredQueryParameters;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getFieldsRequested() {
        return fieldsRequested;
    }

    public void setFieldsRequested(String fieldsRequested) {
        this.fieldsRequested = fieldsRequested;
    }

    public List<String> getIgnoredQueryParameters() {
        return ignoredQueryParameters;
    }

    public void setIgnoredQueryParameters(List<String> ignoredQueryParameters) {
        this.ignoredQueryParameters = ignoredQueryParameters;
    }

}
