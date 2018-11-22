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

            // Tallaght
//             ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//             ods.setUser("pmagee");
//             ods.setPassword("tupulo");
            // Home Oracle XE
            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
            ods.setUser("x00149335");
            ods.setPassword("db01Nov99");

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
            String sql = "CREATE TABLE Employee (empid NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "fullName VARCHAR2(40),"
                    + "dob DATE,"
                    + "startDate DATE)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Employee table" + ex.getMessage());
        }
    }
    
    public void fillEmployeeTable() {
        try {
            // Insert data into table
            String sql = "INSERT INTO Employee(empid,fullName,dob,startDate) "
                    + "values(sid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1,"Karl Blair");
            pstmt.setDate(2, Date.valueOf("1999-11-01"));
            pstmt.setDate(3, Date.valueOf("2018-11-22"));
            pstmt.executeUpdate();

//            pstmt.setString(1, "Adam Brennan");
//            pstmt.setDate(2, Date.valueOf("1997-02-23"));
//            pstmt.setDate(3, Date.valueOf("2018-09-13"));
//            pstmt.executeUpdate();
//
//            pstmt.setString(1, "David Bird");
//            pstmt.setDate(2, Date.valueOf("1990-03-04"));
//            pstmt.setDate(3, Date.valueOf("2018-09-25"));
//            pstmt.executeUpdate();
//
//            pstmt.setString(1, "Paris Hilton");
//            pstmt.setDate(2, Date.valueOf("1996-02-19"));
//            pstmt.setDate(3, Date.valueOf("2018-09-28"));
//            pstmt.executeUpdate();
//
//            pstmt.setString(1, "John Joe");
//            pstmt.setDate(2, Date.valueOf("1980-08-16"));
//            pstmt.setDate(3, Date.valueOf("2018-09-25"));
//            pstmt.executeUpdate();

            System.out.println("Employee table populated");
        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Employee table" + ex.getMessage());
        }
    }
}