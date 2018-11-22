package model;


import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x00149335
 */

public class Employee {
    private int id;
    private String name;
    private Calendar dob;
    private Calendar sdate;
    
    public Employee(String name, int id, Calendar dob, Calendar startDate){
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.sdate = startDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getDob() {
        return dob;
    }

    public Calendar getSdate() {
        return sdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public void setRdate(Calendar sdate) {
        this.sdate = sdate;
    }
}
