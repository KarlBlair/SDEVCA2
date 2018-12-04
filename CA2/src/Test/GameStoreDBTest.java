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
        eo.dropManagerSequence();
        eo.dropManagerTable();
        eo.dropEmployeeTable();
        eo.dropGamesSequence();
        eo.dropGamesTable();
        eo.dropDeveloperSequence();
        eo.dropDeveloperTable();

        eo.createEmployeeSequence();
        eo.createEmployeetable();
        eo.createManagerSequence();
        eo.createManagerTable();
        eo.createGamesSequence();
        eo.createGamesTable();
        eo.createDeveloperSequence();
        eo.createDeveloperTable();

        eo.fillEmployeeTable();
        eo.fillGamesTable();
//        eo.fillManagerTable();
//        eo.fillDeveloperTable();

        PersistanceOperations po = new PersistanceOperations();

        while (run) {
            System.out.println("Please press 1 to add a new Employee");
            System.out.println("Please press 2 to add a new Manager");
            System.out.println("Please press 3 to remove an Employee");
            System.out.println("Please press 4 to remove a Manager");
            System.out.println("Please press 5 to view all Employees");
            System.out.println("Please press 6 to view all Games on Record");
            System.out.println("add game");
            System.out.println("remove game");
            System.out.println("Please press 8 to exit");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Employee you want to add ");
                    in.nextLine();
                    String name = in.nextLine();
                    po.addEmployee(name);
                    break;
                case 2:
                    System.out.println("Enter the name of the Manger you want to add ");
                    in.nextLine();
                    String mName = in.nextLine();
                    po.addManager(mName);
                    break;
                case 3:
                    System.out.println("Enter the ID of the Employee you want to remove ");
                    in.nextLine();
                    int empid = in.nextInt();
                    po.removeEmployee(empid);
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

                case 9:
                    po.close();
                    run = false;
                    break;
            }

        }

    }
}
