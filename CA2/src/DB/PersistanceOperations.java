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
import model.Manager;
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

    public void removeGame(String gameName, String gameDeveloper) {
        Game g = em.find(Game.class, gameName);
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
            System.out.println(String.format("%s: %s", g.getGameName(), g.getGameGenre()));
        }
        em.getTransaction().commit();
    }

    public void addManager(String name) {
        em.getTransaction().begin();
        Manager m = new Manager();
        m.setName(name);
        em.persist(m);
        em.getTransaction().commit();
    }

    public void removeManager(String mID) {
        Manager m = em.find(Manager.class, mID);
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }
    
    public void removeEmployee(int empid) {
        Employee e = em.find(Employee.class, empid);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
    
    public void addDeveloper(String did, String devName, String companyName, int yearsActive){
        em.getTransaction().begin();
        Developer d = new Developer();
        d.getDevID();
        d.getCompanyName();
        d.getRole();
        d.getYearsActive();
        em.persist(d);
        em.getTransaction().commit();
    }
    
    public void removeDeveloper(String did) {
        Developer d = em.find(Developer.class, did);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().begin();
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
