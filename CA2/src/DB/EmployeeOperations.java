/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author x00149335
 */
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class EmployeeOperations {

    private Connection conn;
    private PreparedStatement pstmt;

    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();
            boolean inCollege = true;

            if (inCollege) {
                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
                ods.setUser("x00149335");
                ods.setPassword("db01Nov99");
            } else {
                ods.setURL("jdbc:oracle:thin:@//192.168.0.8:1521/xe");
                ods.setUser("SYSTEM");
                ods.setPassword("w34r3numb3r3500");
            }

            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (SQLException e) {
            System.out.print("Unable to load driver " + e.getMessage());
        }
        return conn;
    }

    public void dropEmployeeSequence() {
        try {
            String s2 = "drop sequence eid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Employee Sequence dropped");
        } catch (SQLException ex) {
            System.out.println("ERROR while dropping Employee Sequence" + ex.getMessage());
        }
    }

    public void dropDeveloperSequence() {
        try {
            String s4 = "drop sequence did_seq";
            pstmt = conn.prepareStatement(s4);
            pstmt.executeUpdate();
            System.out.println("Developer Sequence dropped");
        } catch (SQLException e) {
            System.out.println("ERROR while dropping Developer sequence" + e.getMessage());
        }
    }

    public void createDeveloperSequence() {
        try {
            String createseq4 = "create sequence did_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq4);
            pstmt.executeUpdate();
            System.out.println("Developer Sequence created");
        } catch (SQLException e) {
            System.out.println("ERROR while creating the Developer sequence " + e.getMessage());
        }
    }

    public void createGamesSequence() {
        try {
            String createseq2 = "create sequence gid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq2);
            pstmt.executeUpdate();
            System.out.println("Game Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Game Sequence " + ex.getMessage());
        }
    }

    public void dropGamesSequence() {
        try {
            String s3 = "drop sequence gid_seq";
            pstmt = conn.prepareStatement(s3);
            pstmt.executeUpdate();
            System.out.println("Game Sequence Dropped");
        } catch (SQLException e) {
            System.out.println("ERROR while dropping Game sequence() method");
        }
    }

    public void createEmployeeSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence eid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Employee Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Employee Sequence " + ex.getMessage());
        }
    }

    public void dropEmployeeTable() {
        System.out.println("Checking for existence of Employee table");
        try {
            String s1 = "DROP TABLE Employee";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Employee table dropped");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void dropGamesTable() {
        System.out.println("Checking for existence of Game table");
        try {
            String s2 = "DROP TABLE Games";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Games table dropped");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void createDeveloperTable() {
        try {
            String sql = "CREATE TABLE Developer (did NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "companyName VARCHAR2(35),"
                    + "role VARCHAR2(25),"
                    + "yearsActive NUMBER)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e ) {
            System.out.println("SQL Exception creating "
                    + "Developer table" + e.getMessage());
        }
    }
    
    public void dropDeveloperTable() {
           System.out.println("Checking for existence of Developer table");
        try {
            String s4 = "DROP TABLE Developer";
            pstmt = conn.prepareStatement(s4);
            pstmt.executeUpdate();
            System.out.println("Developer table dropped");
        } catch (SQLException e) {
            System.out.println("ERROR dropping Developer table() method "+e.getMessage());
        }
    }

    public void createEmployeetable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE Employee (id NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "name VARCHAR2(40),"
                    + "dob DATE,"
                    + "sdate DATE)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Employee table" + ex.getMessage());
        }
    }

    public void createGamesTable() {
        try {
            String sql = "CREATE TABLE Games "
                    + "(ID NUMBER PRIMARY KEY NOT NULL,"
                    + "gameName VARCHAR2(255),"
                    + "gameGenre VARCHAR2(255),"
                    + "releaseDate DATE)"; // Maybe have seperate class for this
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Games table" + ex.getMessage());
        }
    }

    public void dropManagerTable() {
        System.out.println("Checking for existence of Manager table");
        try {
            String s2 = "DROP TABLE Manager";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Manager table dropped");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void dropManagerSequence() {
        try {
            String s3 = "drop sequence mid_seq";
            pstmt = conn.prepareStatement(s3);
            pstmt.executeUpdate();
            System.out.println("Manager Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void createManagerSequence() {
        try {
            String createseq2 = "create sequence mid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq2);
            pstmt.executeUpdate();
            System.out.println("Manager Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Manager Sequence " + ex.getMessage());
        }
    }

    public void createManagerTable() {
        try {

            String sq2 = "CREATE TABLE Manager (mID NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "id NUMBER NOT NULL,"
                    + "type VARCHAR2(40),"
                    + "FOREIGN KEY (id) REFERENCES Employee(id))";
            pstmt = conn.prepareStatement(sq2);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Manager table" + ex.getMessage());
        }
    }

    public void fillEmployeeTable() {
        try {
            // Insert data into table
            String sql = "INSERT INTO Employee(id,name,dob,sdate)"
                    + "values(sid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Karl Blair");
            pstmt.setDate(2, Date.valueOf("1999-11-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            //pstmt.setString(4, "FullTimeEmployee");
            pstmt.executeUpdate();

            pstmt.setString(1, "Adam Brennan");
            pstmt.setDate(2, Date.valueOf("1999-05-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            //pstmt.setString(4, "FullTimeEmployee");
            pstmt.executeUpdate();

            pstmt.setString(1, "David Bird");
            pstmt.setDate(2, Date.valueOf("1998-11-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            //pstmt.setString(4, "ParTimeEmployee");
            pstmt.executeUpdate();

            pstmt.setString(1, "John Joe");
            pstmt.setDate(2, Date.valueOf("1999-11-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            //pstmt.setString(4, "ParTimeEmployee");
            pstmt.executeUpdate();

            pstmt.setString(1, "Joe Bloggs");
            pstmt.setDate(2, Date.valueOf("1999-11-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            //pstmt.setString(4, "FullTimeEmployee");
            pstmt.executeUpdate();

            
//            System.out.println("it is working");
            System.out.println("Employee table populated");
        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Employee table" + ex.getMessage());
        }
    }

    public void fillGamesTable() {
        try {
            // Insert data into table
            String sql = "INSERT INTO Games(ID,gameName,gameGenre,releaseDate) "
                    + "values(gid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Fortnite");
            pstmt.setString(2, "Shooter");
            pstmt.setDate(3, Date.valueOf("2018-11-01"));
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Minecraft");
            pstmt.setString(2, "Indie");
            pstmt.setDate(3, Date.valueOf("2009-07-23"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Club Penguin");
            pstmt.setString(2, "Adventure");
            pstmt.setDate(3, Date.valueOf("2007-11-16"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Call of Duty");
            pstmt.setString(2, "Shooter");
            pstmt.setDate(3, Date.valueOf("2018-10-13"));
            pstmt.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println("SQL Exception inserting values into "
                    + "Games table() method" + e.getMessage());
        }
    }

    //this is commented so that we can change the manager clas and make it somewhat useful.
//    public void fillManagerTable() {
//        try {
//            String sql = "INSERT INTO Manager(mID, type,"
//                    + "values(mid_seq.nextVal,?)";
//            pstmt = conn.prepareStatement(sql);
//            
//            pstmt.setString(1, );
//            
//        } catch (SQLException e ) {
//            System.out.println("SQL Exception inserting values into "
//                    + "Manager table() method " + e.getMessage());
//        }
//    }
    
    public void fillDeveloperTable() {
        try {
            String sql = "INSERT INTO Developer(did,companyName,yearsActive, role)"
                    + "values(did_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, "Nintendo");
            pstmt.setString(2, "14");
            pstmt.setString(3, "Software Engineer");
            //pstmt.setString(4, "Jimmy");
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Epic Games");
            pstmt.setString(2, "4");
            pstmt.setString(3, "Database Technician");
            //pstmt.setString(4, "John");
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Rockstar");
            pstmt.setString(2, "6");
            pstmt.setString(3, "Animator");
            //pstmt.setString(4, "Same");
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Ubisoft");
            pstmt.setString(2, "9");
            pstmt.setString(3, "Lead Programmer");
            //pstmt.setString(4, "Joe");
            pstmt.executeUpdate();

            pstmt.setString(1, "Blizzard Entertainment");
            pstmt.setString(2, "3");
            pstmt.setString(3, "Level Designer");
            //pstmt.setString(4, "Paul");
            pstmt.executeUpdate();
            
            System.out.println("Developer table populated");
            
        } catch (SQLException e) {
            System.out.println("ERROR while filling the Developer table() method " + e.getMessage());
        }
    }
}
