
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalAffiliation {

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
    private Address address;
    @SerializedName("phone")
    @Expose
    private Phone_ phone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HospitalAffiliation() {
    }

    /**
     * 
     * @param uid
     * @param address
     * @param phone
     * @param name
     * @param type
     */
    public HospitalAffiliation(String uid, String name, String type, Address address, Phone_ phone) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone_ getPhone() {
        return phone;
    }

    public void setPhone(Phone_ phone) {
        this.phone = phone;
    }

}
