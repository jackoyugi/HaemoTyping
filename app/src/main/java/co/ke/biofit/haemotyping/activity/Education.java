
package co.ke.biofit.haemotyping.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Education {

    @SerializedName("school")
    @Expose
    private School school;
    @SerializedName("graduation_year")
    @Expose
    private GraduationYear graduationYear;
    @SerializedName("degree")
    @Expose
    private String degree;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Education() {
    }

    /**
     * 
     * @param school
     * @param degree
     * @param graduationYear
     */
    public Education(School school, GraduationYear graduationYear, String degree) {
        super();
        this.school = school;
        this.graduationYear = graduationYear;
        this.degree = degree;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public GraduationYear getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(GraduationYear graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
