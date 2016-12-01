
package database;
/**
 *
 * @author juand This class will hold all the course info to make storing and
 * querying from database.
 */
public class Course {

    // Course fields
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
    private String prerequisite;
    private String corequisite;
    private String courseAttributes;
    private String legacyNumber;
    private String crossListed;
    private String restricted;
    public Course() {
        department = " ";
        prefix = " ";
        number = " ";
        name = " ";
        description = " ";
        creditHours = " ";
        lectureHours = " ";
        labHours = " ";
        level = " ";
        scheduleType = " ";
        prerequisite = " ";
        corequisite = " ";
        courseAttributes = " ";
        legacyNumber = " ";
        crossListed = " ";
        restricted = " ";

    }

    public Course(String department, String prefix, String number, String name, String description,
            String creditHours, String lectureHours, String labHours, String level, String scheduleType,
            String prerequisite, String corequisite, String courseAttributes, String legacyNumber, String crossListed, String restricted) {
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
        this.prerequisite = prerequisite;
        this.corequisite = corequisite;
        this.courseAttributes = courseAttributes;
        this.legacyNumber = legacyNumber;
        this.crossListed = crossListed;
        this.restricted = restricted;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public void setLectureHours(String lectureHours) {
        this.lectureHours = lectureHours;
    }

    public void setLabHours(String labHours) {
        this.labHours = labHours;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public void setCorequisite(String corequisite) {
        this.corequisite = corequisite;
    }

    public void setCourseAttributes(String courseAttributes) {
        this.courseAttributes = courseAttributes;
    }

    public void setLegacyNumber(String legacyNumber) {
        this.legacyNumber = legacyNumber;
    }

    public void setCrossListed(String crossListed) {
        this.crossListed = crossListed;
    }

    public void setRestricted(String restricted) {
        this.restricted = restricted;
    }
    
    public String getDepartment() {
        return department;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public String getLectureHours() {
        return lectureHours;
    }

    public String getLabHours() {
        return labHours;
    }

    public String getLevel() {
        return level;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getCorequisite() {
        return corequisite;
    }

    public String getCourseAttributes() {
        return courseAttributes;
    }

    public String getLegacyNumber() {
        return legacyNumber;
    }

    public String getCrossListed() {
        return crossListed;
    }

    public String getRestricted() {
        return restricted;
    }
    
}