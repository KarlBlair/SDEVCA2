/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x00149335
 */
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
public class GameStoreDB {
    
    private Connection conn;
    private ResultSet rset;
    private PreparedStatement pstmt;
    
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            // Tallaght
//             ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//             ods.setUser("");
//             ods.setPassword("");
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
    
    public void dropStudentSequence() {
        try {
            String s2 = "drop sequence sid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Student Sequence dropped");
        } catch (SQLException ex) {

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

        }

    }
    
    public void createEmployeeTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE Employee (id NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "name VARCHAR2(40),"
                    + "dob DATE,"
                    + "startDate DATE)";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Employee table" + ex.getMessage());
        }
    }
    
    public void fillStudentTable() {
        try {
            // Insert data into table
            String sql = "INSERT INTO Employee(id,name,dob,startDate) "
                    + "values(sid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Karl Blair");
            pstmt.setDate(2, Date.valueOf("1999-01-23"));
            pstmt.setDate(3, Date.valueOf("2018-09-13"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Adam Brennan");
            pstmt.setDate(2, Date.valueOf("1997-02-23"));
            pstmt.setDate(3, Date.valueOf("2018-09-13"));
            pstmt.executeUpdate();

            pstmt.setString(1, "David Bird");
            pstmt.setDate(2, Date.valueOf("1990-03-04"));
            pstmt.setDate(3, Date.valueOf("2018-09-25"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Paris Hilton");
            pstmt.setDate(2, Date.valueOf("1996-02-19"));
            pstmt.setDate(3, Date.valueOf("2018-09-28"));
            pstmt.executeUpdate();

            pstmt.setString(1, "John Joe");
            pstmt.setDate(2, Date.valueOf("1980-08-16"));
            pstmt.setDate(3, Date.valueOf("2018-09-25"));
            pstmt.executeUpdate();

            System.out.println("Employee table populated");
        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Employee table" + ex.getMessage());
        }
    }
    
    public void addStudent() {
        try {
            String sq5 = "INSERT INTO Employee(id,name,dob,regDate) "
                    + "VALUES(sid_seq.nextVal,?,?,?)";

            pstmt = conn.prepareStatement(sq5);
            
            pstmt.setString(1, "Testing test");
            pstmt.setDate(2, Date.valueOf("1999-01-11"));
            pstmt.setDate(3, Date.valueOf("2017-09-13"));
            pstmt.executeUpdate();
            

        } catch (SQLException ex) {
            System.out.println("ERROR in getMaxEmployee() method " + ex.getMessage());
        }
    }
    
    public void deleteRecord(int id) {
        try {
            // Create a string with an DELETE statement.
            String sqlStatement = "DELETE FROM Employee WHERE id = ?";

            pstmt = conn.prepareStatement(sqlStatement);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            // Display the results.
            System.out.println(" row deleted to the table.");
        } catch (SQLException ex) {
            System.out.println("ERROR in deleteRecord() method " + ex.getMessage());
        }
    }
    
    public void closeDB() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (rset != null) {
                rset.close();
            }
            if (conn != null) {
                conn.close();
                System.out.print("Connection closed");
            }

        } catch (SQLException e) {
            System.out.print("Could not close connection ");
        }
    }
}

