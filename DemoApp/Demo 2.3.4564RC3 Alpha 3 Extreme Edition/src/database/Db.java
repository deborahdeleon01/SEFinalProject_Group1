/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

//import static Database.DB.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.util.List;


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
    protected static final String PASS = "";
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
           dbCheck(DriverManager.getConnection(DB_URL,USER,PASS)); // Check to see if the database exists
           conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS); // Connection that connects to our database.
       }
       catch (SQLException e) 
       {
           
           System.out.println("There is an error HERE: "+e.getMessage());
           
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
   private void dbCheck(Connection connectionTest)
   {
       try 
       {
           // Bool variable that will change depending if the database is there. We assume the database does not exist.
           Boolean exist = false;
           rs = connectionTest.getMetaData().getCatalogs();
           if(!rs.first()) //Check if database is empty.
           {
               System.out.println("NO DB!!!!!!!!!!!!!!!!!");
               dbInit(connectionTest);
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
               dbInit(connectionTest);
       }
       catch (SQLException e)
       {
           System.out.println("Error could not access the database.");
       }
   }
   /**
    * @author Juan Delgado
    * initializes the Database for the VaqPaq project.
    * @param connect 
    */
   
   private void dbInit(Connection connect)
   {
       try 
       {
           String sql = "CREATE DATABASE "+DB_NAME;
           stmt = connect.createStatement();
           int holder = stmt.executeUpdate(sql);
           dbInitTables();
           
       }
       catch (SQLException e)
       {
           System.out.println("ERROR Could not access the database");
       }
   
   }
   
   /* @author eli */ 
  private void dbInitTables()
   {
       try 
       {
           
           
           String sql=null;
           Connection conn2 = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS);
           sql = "CREATE TABLE Users ( email varchar(20), first varchar(10), last varchar(15),"
                   + "password varchar(20), salt varchar(256), pos varchar(56), permission BIT,pic BLOB, PRIMARY KEY (email))";
           
           pstmt=conn2.prepareStatement(sql);
           pstmt.executeUpdate();
           
           sql="CREATE TABLE Courses (prefix varchar(4), courseNumber varchar(4), name varchar(30), xml LONGTEXT"
                   +",FOREIGN KEY (courseNumber) REFERENCES Users (email), PRIMARY KEY (courseNumber) )";
           
           pstmt=conn2.prepareStatement(sql);
           pstmt.executeUpdate();
           
           sql="CREATE TABLE Style (name varchar(56), category varchar(56), FOREIGN KEY (name) REFERENCES Users (email),"+
                   "PRIMARY KEY (name) )";
          pstmt=conn2.prepareStatement(sql);
           pstmt.executeUpdate();
           
           sql="CREATE TABLE Reminders (reminderName varchar(20), message varchar(256), DATE date, TIME time, PRIMARY KEY (reminderName)  "
                   + ", FOREIGN KEY (reminderName ) REFERENCES Users (email) )";
           
           pstmt=conn2.prepareStatement(sql);
           pstmt.executeUpdate();
           /*
           sql="CREATE TABLE Xml ( name varchar(56), cat(56) "+" PRIMARY KEY name, FOREIGN KEY name)";
           
           pstmt.executeUpdate(sql); */
           
           pstmt.close();
           
       } catch (SQLException e) {
           System.out.println("Error creating table: "+e.getMessage());       
       }
   } 

    
    /*@author eli */     
    public User login(String email, String pass)
    {
      String sql;
      String dbPass=null;
      String dbSalt=null;
      String dbFirst=null;
      String dbLast=null;
      String dbEmail=null;
      String dbPos=null;
      List<String> courses=null;
      
      User u = new User();

      sql="SELECT * FROM Users WHERE email= ?";

      try
      {   conn = DriverManager.getConnection(DB_URL + DB_NAME,USER,PASS);
          pstmt=conn.prepareStatement(sql);
          pstmt.setString(1, email);
          rs=pstmt.executeQuery();
          
         if(rs.first())
         {
             dbPass=rs.getString("password");
             dbSalt=rs.getString("salt");
             dbFirst=rs.getString("first");
             dbLast=rs.getString("last");
             dbEmail=rs.getString("email");
             dbPos=rs.getString("pos");
         }
      }
      catch(SQLException e)
      {
      }
     
      pass=pass+dbSalt;
      dbPass+=dbSalt;
      
      
      if((pass).equals(dbPass))
         {
             u.setFirst(dbFirst);
             u.setLast(dbLast);
             u.setEmail(dbEmail);
             u.setPos(dbPos);
             //u.setCourses();
         }
      
      return u;
        
    }

    /* @author Eli */
    public boolean register(User u) 
    {
       String sql;
        int rowCount=0;
        try 
        {
            sql="SELECT email FROM Users WHERE email = ? ";
            conn=DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, u.getEmail());
            rs=pstmt.executeQuery();
            
            if(!rs.first())
            {
                sql="INSERT INTO Users (email, first, last, password, salt, pos) VALUES (?,?,?,?,?,?)";
                
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1, u.getEmail());
                pstmt.setString(2, u.getFirst());
                pstmt.setString(3, u.getLast());
                pstmt.setString(4, u.getPass());
                pstmt.setString(5, u.getSalt());
                pstmt.setString(6, u.getPos());
                
                pstmt.execute();
                rowCount=pstmt.getUpdateCount();
            }
        } 
        catch (SQLException e) 
        {

            System.out.println("There is an error: " + e.getMessage());

        } 
        if(rowCount==1)
        return true; 
        else 
        return false;
    }   

    public void newXml(/*xml file or appropriate strings like "prefix", "number", "hours". or an object with this info*/) {
        /* 
            Extract info from object, array, xml file or get info from strings passed.
            try to open connection to db.
            if success, check table COURSES for the existence of the current xml attempting to be inserted
            if duplicate return false
            ELSE    INSERT new ROW INTO TABLE COURSES with info like "prefix", "number", "hours".
            close connection, return TRUE
        
         */
    }

    public void addCourse(String department, String prefix, String number, String name, String description, 
            String creditHours, String lectureHours, String labHours, String level, String scheduleType,
            String prerequiste, String corequisite, String courseAttributes) {
        /*
            Open connection to DB
            SELECT from USER TABLE the ROW which has the CREDENTIAL of the USER passed above.
            SELECT from the RESULT SET the "courses" column.
            LOOP through the "coures" for that user and make sure no instance of the NEW course that is attempting to be added.
            IF no instance, search for the new course attempting to be added within the COURSES table.
            IF NOT FOUND, return false
            IF FOUND, create a foreign key/link from the USER in question to the appropriate course ROW in the COURSES TABLE
            ON success return TRUE
            close connection, exit
         */

    }

    public void edCourse(/*OBJECT containing xml info like PREFIX, COURSE NUMBER, something unique*/) {
        /*
            Our COURSES table only keeps track of vital details of a course. LIke prefix, number, hours, type of class...lecture or lab
            EXTRACT the info from the object, WHERE "INFO" is PREFIX, COURSES NUMBER, HOURS...
            OPEN DB CONNECTION
            TRY
            SELECT ROW form TABLE WHERE PREFIX is object.PREFIX
            IF FAIL->reurn false, COURSE is not in DATABASE
            ELSE INSERT into SELECTED ROW the updated info
            CLOSE DB CONNECITON
            
        
         */

    }

    public void rmCourse(/* OBJECT contaiing USER credentials, COURSE to be removed. WHERE COURSE CAN be a string wtth course prefix or maybe a OBJECT itself*/) {
        /* 
            EXTRACT USER credentials
            Open DB connection
            TRY SELECT FROM USER "user crednetial"
            FROM selected USER row, remove the above listed course from the COURSES COLUMN of the USER row
            This will probably be done via "remove foreign key", seperate the link from the COURSES column of the specified USER and the specific course WITHIN THE COURSES TABLE.
            Sever the link.
            RETURN TRUE FOR SUCCESS, FALSE FOR FAILURE
        
         */
    }

    public void addRem(/*object/container with details concerning the reminder to be added, USER OBJ */) {
        /*
                TRY OPEN connection to DB
                TRY INSERT INTO "REMINDER" TABLE, NEW ROW, contating detials from reminder object passed.
                CHECK that the "reminder" to be added doesnt exist.
                IF DOES NOT EXIST-> insert into table new row containing details from reminder object
                
                extract crednetials from USER OBJ
                SELECT FROM USER TABLE, row THAT CONTAINS USER crednetials
                
                FROM that row, go to COLUMN "reminder". 
                Check that there is no link to the new reminder to be added.
                return false if there is.
                else
                Create a link from "reminder" column to the correct row in REMINDER TABLE containg the USERS reminder item.
                return true
        
                * make sure the "reminder name" in the REMINDER TABLE CLOUMN "reminer_name" is unique. Extract from USER obj the email, extract from REMINDER obj the reminder name.
                  combinde like <email@>_<reminder_name>
        
                 
                
                
         */
    }

    public void rmRem(/*object/container with details concerning the reminder to be removed */) {
        /* same as addRem, just the delte version, prety much*/
    }
}
