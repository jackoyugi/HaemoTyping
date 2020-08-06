
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Claim {

    @SerializedName("hcpcs")
    @Expose
    private String hcpcs;
    @SerializedName("hcpcs_description")
    @Expose
    private String hcpcsDescription;
    @SerializedName("service_cnt")
    @Expose
    private Integer serviceCnt;
    @SerializedName("bene_uniq_cnt")
    @Expose
    private Integer beneUniqCnt;
    @SerializedName("avg_allowed_amt")
    @Expose
    private Integer avgAllowedAmt;
    @SerializedName("avg_charge_amt")
    @Expose
    private Integer avgChargeAmt;
    @SerializedName("avg_payment_amt")
    @Expose
    private Integer avgPaymentAmt;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Claim() {
    }

    /**
     * 
     * @param avgAllowedAmt
     * @param serviceCnt
     * @param beneUniqCnt
     * @param hcpcsDescription
     * @param avgChargeAmt
     * @param avgPaymentAmt
     * @param hcpcs
     */
    public Claim(String hcpcs, String hcpcsDescription, Integer serviceCnt, Integer beneUniqCnt, Integer avgAllowedAmt, Integer avgChargeAmt, Integer avgPaymentAmt) {
        super();
        this.hcpcs = hcpcs;
        this.hcpcsDescription = hcpcsDescription;
        this.serviceCnt = serviceCnt;
        this.beneUniqCnt = beneUniqCnt;
        this.avgAllowedAmt = avgAllowedAmt;
        this.avgChargeAmt = avgChargeAmt;
        this.avgPaymentAmt = avgPaymentAmt;
    }

    public String getHcpcs() {
        return hcpcs;
    }

    public void setHcpcs(String hcpcs) {
        this.hcpcs = hcpcs;
    }

    public String getHcpcsDescription() {
        return hcpcsDescription;
    }

    public void setHcpcsDescription(String hcpcsDescription) {
        this.hcpcsDescription = hcpcsDescription;
    }

    public Integer getServiceCnt() {
        return serviceCnt;
    }

    public void setServiceCnt(Integer serviceCnt) {
        this.serviceCnt = serviceCnt;
    }

    public Integer getBeneUniqCnt() {
        return beneUniqCnt;
    }

    public void setBeneUniqCnt(Integer beneUniqCnt) {
        this.beneUniqCnt = beneUniqCnt;
    }

    public Integer getAvgAllowedAmt() {
        return avgAllowedAmt;
    }

    public void setAvgAllowedAmt(Integer avgAllowedAmt) {
        this.avgAllowedAmt = avgAllowedAmt;
    }

    public Integer getAvgChargeAmt() {
        return avgChargeAmt;
    }

    public void setAvgChargeAmt(Integer avgChargeAmt) {
        this.avgChargeAmt = avgChargeAmt;
    }

    public Integer getAvgPaymentAmt() {
        return avgPaymentAmt;
    }

    public void setAvgPaymentAmt(Integer avgPaymentAmt) {
        this.avgPaymentAmt = avgPaymentAmt;
    }

}
