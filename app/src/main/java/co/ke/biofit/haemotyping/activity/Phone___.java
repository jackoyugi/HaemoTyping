
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone___ {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Phone___() {
    }

    /**
     * 
     * @param number
     * @param type
     */
    public Phone___(String number, String type) {
        super();
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
