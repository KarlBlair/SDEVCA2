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
        outputCommands();
        
        while (run) {
            System.out.print("\nOption Number: ");
            int choice = in.nextInt();
            in.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the Employee you want to add: ");
                    String name = in.nextLine();
                    po.addEmployee(name);
                    break;
                case 4:
                    System.out.print("Enter the ID of the Employee you want to remove: ");
                    int empid = in.nextInt();
                    po.removeEmployee(empid);
                    break;
                case 10:
                    po.showAllEmployees();
                    break;
                case 11:
                    po.showAllGames();
                    break;
                case 8:
                    System.out.print("Please enter the name of the game you would like to add: ");
                    String gameName = in.nextLine();

                    System.out.print("Please enter the name of the Game Genre for the game that you added: ");
                    String gameGenre = in.nextLine();
                    po.addGame(gameName, gameGenre);
                    break;
                case 5:
                    System.out.print("Please enter the ID of the game you would like to remove: ");
                    int gameID = in.nextInt();
                    po.removeGame(gameID);
                    break;
                case 12:
                    po.showAllDevelopers();
                    break;
                case 3:
                    System.out.print("Please enter the name of the development company: ");
                    String companyName = in.nextLine();
                    System.out.print("How many years has this company been in business: ");
                    int yearsActive = in.nextInt();

                    po.addDeveloper(companyName, yearsActive);
                    break;
                case 6:
                    System.out.print("Please enter the ID of the developer you wish to remove: ");
                    int devID = in.nextInt();
                    po.removeDeveloper(devID);
                    break;
                case 9:
                    System.out.print("Please enter the ID of the Developer you want to update: ");
                    int ID = in.nextInt();
                    in.nextLine();
                    System.out.print("Please enter the new name: ");
                    String newName = in.nextLine();
                    System.out.print("Please enter the new years active: ");
                    int newYears = in.nextInt();
                    
                    po.updateDeveloper(ID, newName, newYears);
                break;
                case 13:
                    po.showAllOrders();
                    break;
                case 14:
                    po.close();
                    run = false;
                    break;
                case 15:
                    outputCommands();
                    break;
                default:
                    System.out.printf("%d is not a valid option. Please try again!\n", choice);
            }
        }
    }
    
    public static void outputCommands() {
        System.out.println("\n=======================================");
        System.out.println("Add Options:");
        System.out.println("1] New Employee");
        System.out.println("2] New Game");
        System.out.println("3] New Developer");

        System.out.println("\nRemove Options:");
        System.out.println("4] Remove an Employee");
        System.out.println("5] Remove a Game");
        System.out.println("6] Remove a Developer");

        System.out.println("\nUpdate Options:");
        System.out.println("7] Update an Employee");
        System.out.println("8] Update a Game");
        System.out.println("9] Update a Developer");

        System.out.println("\nView Options:");
        System.out.println("10] View all Employees");
        System.out.println("11] View all Games on Record");
        System.out.println("12] View all available Developers");
        System.out.println("13] View all Orders");

        System.out.println("\nMisc:");
        System.out.println("14] Exit the program");
        System.out.println("15] Output this command list again");
        System.out.println("=======================================\n");
    }
}
