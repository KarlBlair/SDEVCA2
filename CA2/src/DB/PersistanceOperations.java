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
        for (Employee e : results) {
            System.out.println(String.format("%d: %s", e.getId(), e.getName()));
        }
        em.getTransaction().commit();
    }
    
    public void showAllOrders() {
        em.getTransaction().begin();
        
        TypedQuery<Orders> query 
                = em.createQuery("SELECT o FROM Orders o",
                        Orders.class);
        List<Orders> results = query.getResultList();
        for(Orders o : results) {
            System.out.println(o);
        }
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
        for(Developer d : results) {
            System.out.println(String.format("%s %d: %s", d.getCompanyName(), d.getYearsActive(), d.getDevID()));
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

//    public void updateEmployee(String name) {
//        Employee e = em.find(Employee.class, name);
//        em.getTransaction().begin();
//        e.getName();
//    }
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
        for (Game g : results) {
            System.out.println(String.format("%d: %s: %s", g.getID(), g.getGameName(), g.getGameGenre()));
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
    
    public void updateDeveloper(int ID, int yearsActive) {
        Developer d = em.find(Developer.class, ID);
        em.getTransaction().begin();
        d.setDevID(ID);
        d.setYearsActive(yearsActive);
        em.persist(ID);
        em.persist(yearsActive);
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
