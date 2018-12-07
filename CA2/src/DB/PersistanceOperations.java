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
import javax.persistence.*;
//import java.sql.*;
//import java.util.Calendar;
import java.util.List;
import model.Developer;
import model.Employee;
import model.Game;
import model.Orders;
//import model.Manager;
//import model.PartTimeEmployee;

public class PersistanceOperations {

    EntityManagerFactory emf;
    EntityManager em;

    public PersistanceOperations() {
        emf = Persistence.createEntityManagerFactory("CA2PU");
        em = emf.createEntityManager();
    }

    public void showAllEmployees() {
//        System.out.println("fredfred");
        em.getTransaction().begin();

        TypedQuery<Employee> query
                = em.createQuery("SELECT e FROM Employee e",
                        Employee.class);
        List<Employee> results = query.getResultList();
        System.out.printf("%-5s%-15s%-20s%-10s%n", "ID", "Name", "Date Of Birth", "Start Date");
        
        for (Employee e : results) {
            System.out.printf(String.format("%-5d%-15s%-20s%-30s%n", e.getId(), e.getName(), e.getDob(), e.getSdate()));
        }
        em.getTransaction().commit();
    }

    public void showAllOrders() {
        em.getTransaction().begin();

        TypedQuery<Orders> query
                = em.createQuery("SELECT o FROM Orders o",
                        Orders.class);
        List<Orders> results = query.getResultList();
        
        System.out.printf("%-5s%-15s%-12s%-10s%n", "ID", "Order Number", "Quantity", "Order Date");
        
        for (Orders o : results) {
            System.out.printf("%-5s%-15s%-12s%-10s%n", o.getID(), o.getOrderNum(), o.getQuantity(), o.getOrderDate());
        }
        
        em.getTransaction().commit();
    }

    //this was removed as we didnt think it made much sense.
    /*public void showALLFT() {
        em.getTransaction().begin();
        TypedQuery<FullTimeEmployee> query
                = em.createQuery("SELECT ft FROM FullTimeEmployee ft "
                        + "order by ft.ID", FullTimeEmployee.class);
        List<FullTimeEmployee> results = query.getResultList();
        for (FullTimeEmployee ft : results) {
            System.out.println(ft);
        }
        em.getTransaction().commit();
    }*/
    public void showAllDevelopers() {
        em.getTransaction().begin();

        TypedQuery<Developer> query
                = em.createQuery("SELECT d FROM Developer d",
                        Developer.class);
        List<Developer> results = query.getResultList();
        System.out.printf("%-5s%-25s%-10s%n", "ID", "Name", "Years");
        for (Developer d : results) {
            System.out.println(String.format("%-5d%-25s%-10d", d.getDevID(), d.getCompanyName(), d.getYearsActive()));
        }
        em.getTransaction().commit();
    }

    public void addEmployee(String name) {
        em.getTransaction().begin();
        Employee e = new Employee();
        e.setName(name);
        em.persist(e);
        em.getTransaction().commit();
    }

    public void addGame(String gameName, String gameGenre) {
        em.getTransaction().begin();
        Game g = new Game();
        g.setGameName(gameName);
        g.setGameGenre(gameGenre);
        em.persist(g);
        em.getTransaction().commit();
    }

    public void removeGame(int gameID) {
        Game g = em.find(Game.class, gameID);
        em.getTransaction().begin();
        em.remove(g);
        em.getTransaction().commit();
    }

    public void showAllGames() {
        em.getTransaction().begin();

        TypedQuery<Game> query
                = em.createQuery("SELECT g FROM Game g",
                        Game.class);
        List<Game> results = query.getResultList();
        System.out.printf("%-5s%-15s%-15s%-10s%-30s%n", "ID", "Game Name", "Genre", "Price", "Released");
        
        for (Game g : results) {
            System.out.println(String.format("%-5d%-15s%-15s€%-9.2f%-30s", g.getID(), g.getGameName(), g.getGameGenre(), g.getPrice(), g.getReleaseDate()));
        }
        em.getTransaction().commit();
    }

    public void removeEmployee(int empid) {
        Employee e = em.find(Employee.class, empid);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public void addDeveloper(String companyName, int yearsActive) {
        em.getTransaction().begin();
        Developer d = new Developer();
        d.setCompanyName(companyName);
        d.setYearsActive(yearsActive);
        em.persist(d);
        em.getTransaction().commit();
    }

    public void updateDeveloper(int ID, String newName, int newYears) {
        Developer d = em.find(Developer.class, ID);
        em.getTransaction().begin();
        d.setCompanyName(newName);
        d.setYearsActive(newYears);
        em.persist(d);
        em.getTransaction().commit();
    }
 
    public void updateGame(int ID, double price, String gameName, String gameGenre) {
        Game g = em.find(Game.class, ID);
        em.getTransaction().begin();
        g.setGameGenre(gameGenre);
        g.setGameName(gameName);
        g.setID(ID);
        g.setPrice(price);
        em.persist(g);
        em.getTransaction().commit();
    }

    public void removeDeveloper(int id) {
        Developer d = em.find(Developer.class, id);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
    }

    //Dont try implement this, doesnt make senes to have this as an option.
//    public void changeDeveloperCompany(String did) {
//        Developer d = em.find(Developer.class ,did);
//        em.getTransaction().begin();
//        d.getCompanyName();
//    }
    public void close() {
        em.close();
        emf.close();
    }
}
