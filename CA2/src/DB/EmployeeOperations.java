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
            
            if(inCollege) {
                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
                ods.setUser("x00149335");
                ods.setPassword("db01Nov99");
            } else {
                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
                ods.setUser("sysdb");
                ods.setPassword("db01Nov99");
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
            String sql = "CREATE TABLE Game (" +
                    "gameid NUMBER PRIMARY KEY NOT NULL," +
                    "gameName VARCHAR2(255)," +
                    "gameDeveloper VARCHAR2(255)" + // Maybe have seperate class for this
                    "releaseDate DATE)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Employee table" + ex.getMessage());
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
            String sql = "INSERT INTO Employee(id,name,dob,sdate) "
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
            
            System.out.println("Employee table populated");
        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Employee table" + ex.getMessage());
        }
    }
}
