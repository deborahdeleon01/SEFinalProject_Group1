/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

//import static Database.DB.JDBC_DRIVER;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
* @author Eli function protoyping
*/
public class Db
{

    private static Db databaseSingleton = new Db();

    // JDBC driver name and database URL
    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    protected static final String USER = "root";

    protected static final String PASS = "dr3100575!";

    protected static final String DB_NAME = "vaqpack";

    //Fields required for queries
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement pstmt;

    /**
     * @author Juan Delgado
     * Constructor.
     * This constructor will automatically connect to the database and check the
     * server and check if the database exist. If not it will create it.
     */
    private Db()
    {
        try
        {
            Class.forName(JDBC_DRIVER); // Load the driver
            dbCheck(); // Check to see if the database exists
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Please ensure you have mysql connector jar linked to the project.");
        }
    }

    /**
     * @author Juan Delgado
     * returns the database object. Which is a singleton.
     * @return
     */
    public static Db theDatabase()
    {
        return databaseSingleton;
    }

    /**
     * @author Juan Delgado
     * This function will check if the database exist. If not it will call another
     * function to create it.
     * @param Connection
     */
    private void dbCheck(){
        Connection connectionTest = null;
        try
        {
            connectionTest = DriverManager.getConnection(DB_URL,USER,PASS);
            // Bool variable that will change depending if the database is there. We assume the database does not exist.
            Boolean exist = false;
            rs = connectionTest.getMetaData().getCatalogs();
            if(!rs.first()) //Check if database is empty.
            {
                System.out.println("NO DB!!!!!!!!!!!!!!!!!");
                dbInit();
                return; //Exit the function since we have just created the database.No need for iteration of the rest of the rows.
            }
            rs.beforeFirst(); //Moves the cursor to the front of this ResultSet object, just before the first row to prepare for iteration.
            while(rs.next())
            {
                if(rs.getString(1).equalsIgnoreCase(DB_NAME))

                {
                    exist = true;
                    break;
                }

            }
            if(!exist)
                dbInit();
        }
        catch (SQLException e)
        {
            System.out.println("Error could not access the database.");
        }
        finally {
            closeConnection(connectionTest);
        }
    }
    
    /**
     * @author Juan Delgado
     * initializes the Database for the VaqPaq project.
     * @param connect
     */
    private void dbInit(){
        Connection connect  = null;
        try {
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "CREATE DATABASE "+DB_NAME;
            stmt = connect.createStatement();
            int holder = stmt.executeUpdate(sql);
            dbInitTables();

        }
        catch (SQLException e)
        {
            System.out.println("ERROR Could not access the database");
        }
        finally {
            closeConnection(connect);
        }

    }
    
    /**
     * @author Juan Delgado
     * Takes a connection object and closes it.
     * @param cn
     */
    private void closeConnection(Connection cn){
        try {
            cn.close();
            cn = null;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @author Juan Delgado
     * Closes either a statement or prepared statement.
     * @param st
     */
    private void closeStatement(Statement st){
        try {
            st.close();
            st = null;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    /* @author eli */
    /**
     * 
     */
    private void dbInitTables() {
        try {


            String sql = null;
            Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            sql = "CREATE TABLE Users ( id int NOT NULL AUTO_INCREMENT, email VARCHAR(255), first varchar(255), last varchar(255),"
                    + "password nvarchar(255), salt nvarchar(255), pos varchar(255), permission int(1), pic LONGBLOB, PRIMARY KEY (id))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            sql = "CREATE TABLE Courses (prefix varchar(4), course_number varchar(4), name varchar(30), course_xml LONGBLOB,"
                    + "PRIMARY KEY (course_number) )";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            sql = "CREATE TABLE Style (name varchar(56), category varchar(56)," +
                    "PRIMARY KEY (name) )";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            sql = "CREATE TABLE Reminders (reminder_id int, reminderName varchar(20), message varchar(256), DATE date, TIME time, PRIMARY KEY (reminderName),  "
                    + " FOREIGN KEY (reminder_id) REFERENCES Users(id ))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            sql = "CREATE TABLE User_Courses( user_id int, course_prefix varchar(4), course_number varchar(4), course_name varchar(255), grade varchar(1), active int(2), hours FLOAT"
                    + ", FOREIGN KEY (user_id) REFERENCES Users(id))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
           /*
           sql="CREATE TABLE Xml ( name varchar(56), cat(56) "+" PRIMARY KEY name, FOREIGN KEY name)";

           pstmt.executeUpdate(sql); */

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }


    /*@author eli */
    /**
     * 
     * @param email
     * @param password
     * @param u
     * @return 
     */
    public boolean login(String email, String password, User u) {
        String sql;
        String dbPass = null;
        String dbSalt = null;
        String dbFirst = null;
        String dbLast = null;
        String dbEmail = null;
        String dbPos = null;
        List<String> courses = null;

        Util util = new Util();
        String[] hashpass = new String[2];

        sql = "SELECT * FROM Users WHERE email= ?";

        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.first()) {
                dbPass = rs.getString("password");
                dbSalt = rs.getString("salt");
                dbFirst = rs.getString("first");
                dbLast = rs.getString("last");
                dbEmail = rs.getString("email");
                dbPos = rs.getString("pos");
            } else
                return false;
        } catch (SQLException e) {

        }

        try {
            u = new User();
            hashpass = util.encrypt(password, dbSalt);
            if ((hashpass[0].equals(dbPass) && email.equals(dbEmail))) {
                u.setEmail(dbEmail);
                u.setFirst(dbFirst);
                u.setLast(dbLast);
                u.setPos(dbPos);
                return true;
            }
            else
                return false;


        } catch (Exception ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    /* @author Eli */
    /**
     * 
     * @param u
     * @return 
     */
    public boolean register(User u) {
        String sql;
        int rowCount = 0;
        Util util = new Util();
        String[] passhash = new String[2];

        try {
            sql = "SELECT email FROM Users WHERE email = ? ";
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getEmail());
            rs = pstmt.executeQuery();

            if (!rs.first()) {
                sql = "INSERT INTO Users (email, first, last, password, salt, pos) VALUES (?,?,?,?,?,?)";


                try {
                    passhash = util.encrypt(u.getPass(), u.getSalt());
                    System.out.println("passwordlogin__>" + passhash[0] + "  salt__" + passhash[1]);

                } catch (Exception ex) {
                    Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
                }

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, u.getEmail());
                pstmt.setString(2, u.getFirst());
                pstmt.setString(3, u.getLast());
                pstmt.setString(4, passhash[0]);
                pstmt.setString(5, passhash[1]);
                pstmt.setString(6, u.getPos());

                pstmt.execute();
                rowCount = pstmt.getUpdateCount();
            }
        } catch (SQLException e) {

            System.out.println("There is an error: " + e.getMessage());

        }
        if (rowCount == 1)
            return true;
        else
            return false;
    }

    /**
     * @author Juan Delgado
     * Create a new entry in the courses table with the specified prefix, number,
     * and name. It will also store the xml files that have been generated. Note that the
     * xml files must exist already in order for this function to work.
     * @param prefix
     * @param courseNumber
     */
    public void newXml(String prefix, String courseNumber) {
        String courseXMLPath = DirectoryStructure.getVACPAC_XML() + prefix + "-" + courseNumber + ".xml";
        String sql = "INSERT INTO Courses(prefix, course_number, course_xml)"
                + "VALUES(?, ?, ?)";
        try{
            conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS); //Connect to the database.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prefix);
            pstmt.setString(2, courseNumber);
            pstmt.setBinaryStream(3, new BufferedInputStream(new FileInputStream( new File(courseXMLPath))));
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(pstmt);
        }
    }
    
    /**
     * @author Juan Delgado
     * Automatically populates the xml files contained in the database.
     */
    public void populateXMLFiles()
    {
        String sql = "SELECT * FROM Courses";
        File xmlFile;
        InputStream is;
        BufferedOutputStream fs;
        byte[] buffer; //Buffer to write the file.
        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS); //Connect to the database
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                //Read the course XML file
                xmlFile = new File(DirectoryStructure.getVACPAC_XML() + rs.getString(1) + "-" + rs.getString(2) + ".xml");
                xmlFile.createNewFile(); // Create the file if it does not exist;
                fs = new BufferedOutputStream(new FileOutputStream(xmlFile));
                is = rs.getBinaryStream(3);
                buffer = rs.getBytes(3); //Get size of the file in bytes
                while(is.read(buffer) > 0){
                    fs.write(buffer);
                }
                fs.close();
                is.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
        }
    }
    
    /**
     * @author Juan Delgado
     * This function will upload all the XML files to the database.
     */
    public void uploadXMLFromDirectoryToTheDatabase(){
        String[] fileNames;
        String[] currentFile;
        String sql;
        File dir;
        try {
            dir = new File(DirectoryStructure.getVACPAC_XML());
            fileNames = dir.list();
            System.out.println(fileNames.length);
            for(int i = 0; i < fileNames.length; i+=3)
            {
                conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
                currentFile = fileNames[i].split("-");
                sql = "SELECT course_number FROM Courses WHERE "
                        + "course_number = " + currentFile[1].split("\\.")[0]; //Use split to ensure the .xml part is left out of the prefix.
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if(!rs.first())
                    newXml(currentFile[0], currentFile[1].split("\\.")[0]); //Use split to ensure the .xml part is left out of the prefix.
                rs.close();
                stmt.close();
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
    }
    
    /**
     * @author Juan Delgado
     * Function to retrieve the css files from the database.
     */
    public void populateCSSFiles(){
        String sql = "SELECT * FROM Style";
        File styleFile;
        InputStream is;
        BufferedOutputStream fs;
        byte[] buffer;

        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                styleFile = new File(DirectoryStructure.getVACPAC_CSS()); //Get path to file.
                styleFile.createNewFile(); //Create file if it does not exist.
                fs = new BufferedOutputStream(new FileOutputStream(styleFile));
                is = rs.getBinaryStream(2);
                buffer = rs.getBytes(2);
                while(is.read(buffer) > 0) {
                    fs.write(buffer);
                }
                fs.close();
                is.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
        }
    }
    
    /**
     * 
     */
    public void uploadStyleFiles() {
        String[] fileNames;
        File dir;
        File styleFile;
        InputStream is;
        BufferedInputStream fs;
        try {
            dir = new File(DirectoryStructure.getVACPAC_CSS());
            fileNames = dir.list();
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            for(int i = 0; i < fileNames.length; i++){
                String sql = "SELECT name FROM Style WHERE name = " + fileNames[i];
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if(!rs.first()) {
                    sql = "INSERT INTO Style(name, style_sheet)VALUES(?,?)";
                    pstmt.setString(1, fileNames[i]);
                    pstmt.setBinaryStream(2,fs = new BufferedInputStream(new FileInputStream(DirectoryStructure.getVACPAC_CSS() + fileNames[i])));
                    pstmt.close();
                    fs.close();
                }
                stmt.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
        }
    }
    
    /**
     * @author Juan Delgado will add the specified course to the user_courses tables that corresponds to the user id.
     * @param user
     * @param courseToAdd
     */
    public void addCourse(User user, Course courseToAdd) {
        String sql = "INSERT INTO User_Courses(user_id, course_prefix, course_number, coursse_name, grade, active, hours)Values"
                + "((SELECT user_id FROM Users WHERE user_id = ?), ?, ?, ?";
        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, courseToAdd.getCoursePrefix());
            pstmt.setString(3, courseToAdd.getCourseNumber());
            pstmt.setString(4, courseToAdd.getCourseName());
            pstmt.setString(5, String.valueOf(courseToAdd.getGrade()));
            pstmt.setInt(6, courseToAdd.getActive());
            pstmt.setDouble(7, courseToAdd.getHours());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public User retrieveUserInfo(String email){
        User retrievedUser = null;
        ArrayList<Course> pastCourses = new ArrayList<>();
        ArrayList<Course> currentCourses = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Users WHERE email = ?";
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,email);
            rs = pstmt.executeQuery();
            while(rs.next()){
                retrievedUser = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(1));
            }
            stmt.close();
            sql = "SELECT * FROM User_Courses WHERE user_id = " + retrievedUser.getId();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(6) == 0)
                    pastCourses.add( new Course(rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(6),rs.getString(5).charAt(0),rs.getDouble(7)));
                else
                    currentCourses.add( new Course(rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(6),rs.getString(5).charAt(0),rs.getDouble(7)));
            }
            retrievedUser.addCurrentCourses(currentCourses);
            retrievedUser.addPastCourses(pastCourses);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            closeConnection(conn);
            closeStatement(stmt);
            closeStatement(pstmt);
        }

        return retrievedUser;
    }
    
    /**
     * 
     * @param user
     * @param grade
     * @param prefix 
     */
    public void editCourse(User user, char grade, String prefix) {
        String sql = "UPDATE user_courses SET grade = ? WHERE user_id = ? AND course_prefix = ?";
        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Character.toString(grade));
            pstmt.setInt(2, user.getId());
            pstmt.setString(3, prefix);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(pstmt);
        }
    }
    
    /**
     * 
     * @param user
     * @param prefix 
     */
    public void removemCourse(User user, String prefix) {
        String sql = "SELECT * FROM user_courses WHERE user_id = " + user.getId();
        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString(3).equalsIgnoreCase(prefix)) {
                    sql = "DELETE FROM user_courses WHERE user_id = " + user.getId()
                            + " AND course_prefix = " + prefix;
                    stmt.executeUpdate(sql);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
        }
    }
    
    /**
     * 
     * @param start
     * @param end
     * @param message
     * @param u
     * @return 
     */
    public Reminder addRem(String start, String end, String message, User u) {
        int id;
        String sql;
        String name;

        Timestamp startTime = Timestamp.valueOf(start);
        Timestamp endTime = Timestamp.valueOf(end);
        name = UUID.randomUUID().toString();

        Reminder r = new Reminder(startTime, endTime, message, name, "");

        sql = "SELECT * FROM Users WHERE email = ? ";

        try{
            conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS); //Connect to the database.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getEmail());
            rs = pstmt.executeQuery();

            if(rs.first()){
                id = rs.getInt(1);
                rs = pstmt.executeQuery();

                sql = "INSERT INTO Reminders () SELECT * FROM (SELECT ?,?,?,?,?) AS tmp WHERE NOT EXISTS ("
                        + "SELECT reminder_id,StartTime,EndTime FROM Reminders WHERE reminder_id = ? "
                        + "AND ((StartTime = ?) OR (StartTime < ? AND EndTime > ?))"
                        + "OR ((EndTime = ?) OR (StartTime < ? AND EndTime > ?))"
                        + "OR (StartTime > ? AND EndTime < ?)) LIMIT 1";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, message);
                pstmt.setTimestamp(4, startTime);
                pstmt.setTimestamp(5, endTime);
                pstmt.setInt(6, id);
                pstmt.setTimestamp(7, startTime);
                pstmt.setTimestamp(8, startTime);
                pstmt.setTimestamp(9, startTime);
                pstmt.setTimestamp(10, endTime);
                pstmt.setTimestamp(11, endTime);
                pstmt.setTimestamp(12, endTime);
                pstmt.setTimestamp(13, startTime);
                pstmt.setTimestamp(14, endTime);
                int i = pstmt.executeUpdate();
                if(i == 1){
                    System.out.println("Reminder added");
                }
                else{
                    System.out.println("Time frame for reminder already occupied");
                    r = null;
                }
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(pstmt);

        }
        return r;
    }

    /**
     * @author Josue Rodriguez
     * Remove the reminder from the user in the database
     * @param r Reminder to remove
     */
    public void rmRem(Reminder r) {
        String sql;

        sql = "DELETE FROM Reminders WHERE reminderName = ?";

        try{
            conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS); //Connect to the database.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, r.getReminderName());
            int i = pstmt.executeUpdate();

            if(i ==1){
                System.out.println("Reminder deleted");
            }
            else{
                System.out.println("Reminder could not be deleted");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(pstmt);
        }
    }
}