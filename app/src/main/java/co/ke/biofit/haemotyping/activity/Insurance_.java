
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Insurance_ {

    @SerializedName("insurance_plan")
    @Expose
    private InsurancePlan_ insurancePlan;
    @SerializedName("insurance_provider")
    @Expose
    private InsuranceProvider_ insuranceProvider;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Insurance_() {
    }

    /**
     * 
     * @param insuranceProvider
     * @param insurancePlan
     */
    public Insurance_(InsurancePlan_ insurancePlan, InsuranceProvider_ insuranceProvider) {
        super();
        this.insurancePlan = insurancePlan;
        this.insuranceProvider = insuranceProvider;
    }

    public InsurancePlan_ getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(InsurancePlan_ insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public InsuranceProvider_ getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(InsuranceProvider_ insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

}
