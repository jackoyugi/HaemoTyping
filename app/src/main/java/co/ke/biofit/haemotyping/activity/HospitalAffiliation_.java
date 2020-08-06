
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalAffiliation_ {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address")
    @Expose
    private Address__ address;
    @SerializedName("phone")
    @Expose
    private Phone___ phone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HospitalAffiliation_() {
    }

    /**
     * 
     * @param uid
     * @param address
     * @param phone
     * @param name
     * @param type
     */
    public HospitalAffiliation_(String uid, String name, String type, Address__ address, Phone___ phone) {
        super();
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address__ getAddress() {
        return address;
    }

    public void setAddress(Address__ address) {
        this.address = address;
    }

    public Phone___ getPhone() {
        return phone;
    }

    public void setPhone(Phone___ phone) {
        this.phone = phone;
    }

}
