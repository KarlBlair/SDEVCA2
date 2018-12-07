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
        boolean run = true;

        EmployeeOperations eo = new EmployeeOperations();

        //Had to drop the Manager table first before dropping Employee as Manager is dependant on Employee. 
        eo.openDB();
        eo.dropEmployeeSequence();
        eo.dropDeveloperSequence();
        eo.dropManagerSequence();
        eo.dropGamesSequence();
        System.out.println("");
        
        eo.createEmployeeSequence();
        eo.createDeveloperSequence();
        eo.createManagerSequence();
        eo.createGamesSequence();
        System.out.println("");
        
        eo.dropGamesTable();
        eo.dropDeveloperTable();
        eo.dropManagerTable();
        eo.dropEmployeeTable();
        System.out.println("");
        
        eo.createEmployeetable();
        eo.createDeveloperTable();
        eo.createManagerTable();
        eo.createGamesTable();
        System.out.println("");

        eo.fillEmployeeTable();
        eo.fillDeveloperTable();
//        eo.fillManagerTable();
        eo.fillGamesTable();
        System.out.println("");
        
        PersistanceOperations po = new PersistanceOperations();

        while (run) {
            System.out.println("Please press 1 to add a new Employee");
            System.out.println("Please press 2 to remove an Employee");
            System.out.println("Please press 3 to add a new Manager");
            System.out.println("Please press 4 to remove a Manager");
            System.out.println("Please press 5 to view all Employees");
            System.out.println("Please press 6 to view all Games on Record");
            System.out.println("Please press 7 to add a new game");
            System.out.println("Please press 8 to remove a game");
            System.out.println("Please press 9 to add a new developer record");
            System.out.println("Please press 10 to remove a developer record");
            System.out.println("Please press 11 to exit");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Employee you want to add ");
                    in.nextLine();
                    String name = in.nextLine();
                    po.addEmployee(name);
                    break;
                case 2:
                    System.out.println("Enter the ID of the Employee you want to remove ");
                    in.nextLine();
                    int empid = in.nextInt();
                    po.removeEmployee(empid);
                    break;
                case 3:
                    System.out.println("Enter the name of the Manger you want to add ");
                    in.nextLine();
                    String mName = in.nextLine();
                    po.addManager(mName);
                    break;
                case 4:
                    System.out.println("Enter the name of the Manager you want to remove ");
                    in.nextLine();
                    String mID = in.nextLine();
                    po.removeManager(mID);
                    break;
                case 5:
                    po.showAllEmployees();
                    break;
                case 6:
                    po.showAllGames();
                    break;
                case 7:
                    System.out.println("Please enter the name of the game you would like to add ");
                    in.nextLine();
                    String gameName = in.nextLine();

                    System.out.println("Please enter the name of the Game Genre for the game that you added ");
                    in.nextLine();
                    String gameGenre = in.nextLine();
                    po.addGame(gameName, gameGenre);
                    break;
                case 8:
                    System.out.println("Please enter the name of the game you would like to remove ");
                    in.nextLine();
                    gameName = in.nextLine();
                    gameGenre = in.nextLine();
                    po.removeGame(gameName, gameGenre);
                    break;
                case 9:
                    /* do we want to have the employee names? or just companies? ask tomorrow */
                    System.out.println("Please enter the name of the Developer you want to add ");
                    String devName = in.nextLine();
                    System.out.println("Please enter the Company your developer works for ");
                    String companyName = in.nextLine();
                    System.out.println("Ask about this");
                    //po.addDeveloper(mID,devName, companyName, yearsActive);
                    break;
                case 10:
                    System.out.println("Please enter the ID of the developer you wish to remove ");
                    int devID = in.nextInt();
                    // do this
                case 11:
                    po.close();
                    run = false;
                    break;
            }

        }

    }
}
