package model;


import java.sql.Date;
import java.util.Calendar;
import javax.persistence.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x00149335
 */

@Entity
@Table(name = "EMPLOYEE")

@SequenceGenerator(name="eid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")

public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="eid_seq")
    @Column(name="ID")
    private int id;
    private String name;
    private Date dob;
    private Date sdate;

    public Employee() {
    }
    
    public Employee(String name, int id, Date dob, Date sdate){
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.sdate = sdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setRdate(Date sdate) {
        this.sdate = sdate;
    }
}
