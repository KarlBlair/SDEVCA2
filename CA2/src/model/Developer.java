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
    private String devID;
    private String companyName;
    private int yearsActive;

    public Developer(String companyName, int yearsActive) {
        this.companyName = companyName;
        this.yearsActive = yearsActive;
    }

    public Developer() {
    }

    public String getDevID() {
        return devID;
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
