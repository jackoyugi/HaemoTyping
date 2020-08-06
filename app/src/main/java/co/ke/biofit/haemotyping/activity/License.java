
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("number")
    @Expose
    private Number number;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("end_date")
    @Expose
    private EndDate endDate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public License() {
    }

    /**
     * 
     * @param number
     * @param endDate
     * @param state
     */
    public License(Number number, State state, EndDate endDate) {
        super();
        this.number = number;
        this.state = state;
        this.endDate = endDate;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate endDate) {
        this.endDate = endDate;
    }

}
