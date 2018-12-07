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
        eo.dropOrderSequence();
        System.out.println("");

        eo.createEmployeeSequence();
        eo.createDeveloperSequence();
        eo.createManagerSequence();
        eo.createGamesSequence();
        eo.createOrderSequence();
        System.out.println("");

        eo.dropGamesTable();
        eo.dropDeveloperTable();
        eo.dropManagerTable();
        eo.dropEmployeeTable();
        eo.dropOrderTable();
        System.out.println("");

        eo.createEmployeetable();
        eo.createDeveloperTable();
        eo.createManagerTable();
        eo.createGamesTable();
        eo.createOrderTable();
        System.out.println("");

        eo.fillEmployeeTable();
        eo.fillDeveloperTable();
        eo.fillGamesTable();
        eo.fillOrderTable();

        System.out.println("zz4");

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
            System.out.println("Please press 9 to view all available Developers");
            System.out.println("Please press 10 to add a new developer record");
            System.out.println("Please press 11 to remove a developer record");
            System.out.println("Please press 12 to update a Developer ");
            System.out.println("13 for orders");
            System.out.println("Please press 16 to exit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Employee you want to add ");
                    String name = in.nextLine();
                    po.addEmployee(name);
                    break;
                case 2:
                    System.out.println("Enter the ID of the Employee you want to remove ");
                    int empid = in.nextInt();
                    po.removeEmployee(empid);
                    break;
                case 3:
                    System.out.println("Enter the name of the Manger you want to add ");
                    String mName = in.nextLine();
//                    po.addManager(mName);
                    break;
                case 4:
                    System.out.println("Enter the name of the Manager you want to remove ");
                    String mID = in.nextLine();
//                    po.removeManager(mID);
                    break;
                case 5:
                    po.showAllEmployees();
                    break;
                case 6:
                    po.showAllGames();
                    break;
                case 7:
                    System.out.println("Please enter the name of the game you would like to add ");
                    String gameName = in.nextLine();

                    System.out.println("Please enter the name of the Game Genre for the game that you added ");
                    String gameGenre = in.nextLine();
                    po.addGame(gameName, gameGenre);
                    break;
                case 8:
                    System.out.println("Please enter the ID of the game you would like to remove ");
                    int gameID = in.nextInt();
                    po.removeGame(gameID);
                    break;
                case 9:
                    po.showAllDevelopers();
                    break;
                case 10:
                    /* do we want to have the employee names? or just companies? ask tomorrow */
                    System.out.println("Please enter the name of the development company ");
                    String companyName = in.nextLine();
                    System.out.println("How many years has this company been in business ");
                    int yearsActive = in.nextInt();

                    po.addDeveloper(companyName, yearsActive);
                    break;
                case 11:
                    System.out.println("Please enter the ID of the developer you wish to remove ");
                    int devID = in.nextInt();
                    po.removeDeveloper(devID);
                    break;
                case 12:
                    System.out.println("Please enter the ID of the Developer you want to update");
                    int ID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the new name");
                    String newName = in.nextLine();
                    System.out.println("Please enter the new years active");
                    int newYears = in.nextInt();
                    
                    po.updateDeveloper(ID, newName, newYears);
                break;
                case 13:
                    po.showAllOrders();
                    break;
                case 16:
                    po.close();
                    run = false;
                    break;
            }

        }

    }
}
