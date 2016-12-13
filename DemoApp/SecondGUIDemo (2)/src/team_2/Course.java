/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_2;

/**
 *
 * @author Germex
 */
public class Course {
    private String department; 
    private String prefix;
    private String number; 
    private String name; 
    private String description; 
    private String creditHours; 
    private String lectureHours; 
    private String labHours; 
    private String level; 
    private String scheduleType; 
    private String prerequistie; 
    private String coRequisite; 
    private String legacyNumber; 
    private String crossListed; 
    private String Restrictions; 
    private String courseAttributes; 

    public Course(String department, String prefix, String number, String name, String description, String creditHours, String lectureHours, String labHours, String level, String scheduleType, String prerequistie, String coRequisite, String legacyNumber, String crossListed, String Restrictions, String courseAttributes) {
        this.department = department;
        this.prefix = prefix;
        this.number = number;
        this.name = name;
        this.description = description;
        this.creditHours = creditHours;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
        this.level = level;
        this.scheduleType = scheduleType;
        this.prerequistie = prerequistie;
        this.coRequisite = coRequisite;
        this.legacyNumber = legacyNumber;
        this.crossListed = crossListed;
        this.Restrictions = Restrictions;
        this.courseAttributes = courseAttributes;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public String getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(String lectureHours) {
        this.lectureHours = lectureHours;
    }

    public String getLabHours() {
        return labHours;
    }

    public void setLabHours(String labHours) {
        this.labHours = labHours;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getPrerequistie() {
        return prerequistie;
    }

    public void setPrerequistie(String prerequistie) {
        this.prerequistie = prerequistie;
    }

    public String getCoRequisite() {
        return coRequisite;
    }

    public void setCoRequisite(String coRequisite) {
        this.coRequisite = coRequisite;
    }

    public String getLegacyNumber() {
        return legacyNumber;
    }

    public void setLegacyNumber(String legacyNumber) {
        this.legacyNumber = legacyNumber;
    }

    public String getCrossListed() {
        return crossListed;
    }

    public void setCrossListed(String crossListed) {
        this.crossListed = crossListed;
    }

    public String getRestrictions() {
        return Restrictions;
    }

    public void setRestrictions(String Restrictions) {
        this.Restrictions = Restrictions;
    }

    public String getCourseAttributes() {
        return courseAttributes;
    }

    public void setCourseAttributes(String courseAttributes) {
        this.courseAttributes = courseAttributes;
    }

}
