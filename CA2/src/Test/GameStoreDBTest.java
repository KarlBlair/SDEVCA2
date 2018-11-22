package Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x00149335
 */

import DB.EmployeeOperations;
import java.util.Scanner;
public class GameStoreDBTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        EmployeeOperations eo = new EmployeeOperations();
        
        eo.openDB();
        eo.dropEmployeeSequence();
        eo.createEmployeeSequence();
        eo.dropEmployeeTable();
        eo.createEmployeetable();
        eo.fillEmployeeTable();
        
    }
}
