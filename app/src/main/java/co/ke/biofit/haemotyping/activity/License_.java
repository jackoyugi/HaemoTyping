
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License_ {

    @SerializedName("number")
    @Expose
    private Number_ number;
    @SerializedName("state")
    @Expose
    private State_ state;
    @SerializedName("end_date")
    @Expose
    private EndDate_ endDate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public License_() {
    }

    /**
     * 
     * @param number
     * @param endDate
     * @param state
     */
    public License_(Number_ number, State_ state, EndDate_ endDate) {
        super();
        this.number = number;
        this.state = state;
        this.endDate = endDate;
    }

    public Number_ getNumber() {
        return number;
    }

    public void setNumber(Number_ number) {
        this.number = number;
    }

    public State_ getState() {
        return state;
    }

    public void setState(State_ state) {
        this.state = state;
    }

    public EndDate_ getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate_ endDate) {
        this.endDate = endDate;
    }

}
