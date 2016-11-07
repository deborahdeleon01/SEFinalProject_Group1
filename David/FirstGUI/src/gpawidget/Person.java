/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

/**
 *
 * @author MQ0162246
 */
public class Person {
    private String fName;
    private String lName;
    private String Id;
    private String Semester;

    public Person() {
    }

    public Person(String fName, String lName, String Id, String Semester) {
        this.fName = fName;
        this.lName = lName;
        this.Id = Id;
        this.Semester = Semester;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Semester
     */
    public String getSemester() {
        return Semester;
    }

    /**
     * @param Semester the Semester to set
     */
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
@Override
public String toString() 
{
    String s = "";

    s+=getfName()+ " "+ getlName();
    return s;
}
    
    
    
}
