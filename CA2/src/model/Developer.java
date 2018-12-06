/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author siawangg
 */

import javax.persistence.*;

@Entity
@Table(name = "Developer")

@SequenceGenerator(name="did_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Developer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="did_seq")
    @Column(name="ID")
    private String devName;
    private String devID;
    private String companyName;
    private String role;
    private int yearsActive;

    public Developer(String devName, String devID, String companyName, String role, int yearsActive) {
        this.devName = devName;
        this.devID = devID;
        this.companyName = companyName;
        this.role = role;
        this.yearsActive = yearsActive;
    }
    
    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevName() {
        return devName;
    }

    public String getRole() {
        return role;
    }

    public Developer() {
    }

    public String getDevID() {
        return devID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getYearsActive() {
        return yearsActive;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setYearsActive(int yearsActive) {
        this.yearsActive = yearsActive;
    }
}