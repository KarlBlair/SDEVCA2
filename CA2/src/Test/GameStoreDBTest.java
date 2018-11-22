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
import DB.PersistanceOperations;
import java.util.Scanner;

public class GameStoreDBTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        EmployeeOperations eo = new EmployeeOperations();

        //Had to drop the Manager table first before dropping Employee as Manager is dependant on Employee. 
        eo.openDB();
        eo.dropEmployeeSequence();
        eo.dropManagerSequence();
        eo.dropManagerTable();
        eo.dropEmployeeTable();

        eo.createEmployeeSequence();
        eo.createEmployeetable();
        eo.createManagerSequence();
        eo.createManagerTable();

        eo.fillEmployeeTable();

        PersistanceOperations po = new PersistanceOperations();

        while (true) {
            System.out.println("Please press 1 to add a new Employee");
            System.out.println("Please press 2 to add a new Manager");
            System.out.println("Please press 3 to remove an Employee");
            System.out.println("Please press 4 to remove a Manager");
            System.out.println("Please press 5 to view all Full Time Employees");
            System.out.println("Please press 5 to view all Part Time Employees");
            System.out.println("Please press 6 to view all Employees");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Employee you want to add ");
                    String name = in.nextLine();
                    po.addEmployee(name);
                case 2:
                    System.out.println("Enter the name of the Manger you want to add ");
                    String mName = in.nextLine();
                    po.addManager(mName);
            }

        }

    }
}
