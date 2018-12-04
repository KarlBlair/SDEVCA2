/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Calendar;
import javax.persistence.*;
/**
 *
 * @author x00149335
 */
import java.util.Calendar;

@Entity
@Table(name = "MANAGER")

@SequenceGenerator(name="mid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Manager extends Employee {
    
    private String mID;
    
    public Manager(String name, Date dob, Date sdate) {
        super(name, dob, sdate);
    }
    
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
