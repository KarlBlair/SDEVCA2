/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author x00149335
 */
import java.util.Calendar;

public class Manager extends Employee {

    public Manager(String name, int id, Date dob, Date sdate) {
        super(name, id, dob, sdate);
    }

    private String mID;
    
    public Manager(){
        
    }

    public Manager(String mID) {
        this.mID = mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmID() {
        return mID;
    }

}
