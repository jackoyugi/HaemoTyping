
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Education_ {

    @SerializedName("school")
    @Expose
    private School_ school;
    @SerializedName("graduation_year")
    @Expose
    private GraduationYear_ graduationYear;
    @SerializedName("degree")
    @Expose
    private String degree;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Education_() {
    }

    /**
     * 
     * @param school
     * @param degree
     * @param graduationYear
     */
    public Education_(School_ school, GraduationYear_ graduationYear, String degree) {
        super();
        this.school = school;
        this.graduationYear = graduationYear;
        this.degree = degree;
    }

    public School_ getSchool() {
        return school;
    }

    public void setSchool(School_ school) {
        this.school = school;
    }

    public GraduationYear_ getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(GraduationYear_ graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
