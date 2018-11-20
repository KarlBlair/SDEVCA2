/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author x00149335
 */
public class PartTimeEmployee extends Employee {

    private double rateOfPay;
    private double hours;
    
    public PartTimeEmployee(String name, int id, Calendar dob, Calendar startDate) {
        super(name, id, dob, startDate);
    }

    public double getRateOfPay() {
        return rateOfPay;
    }

    public double getHours() {
        return hours;
    }

    public void setRateOfPay(double rateOfPay) {
        this.rateOfPay = rateOfPay;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    @Override
    public String toString() {
        return super.toString() + "  PartTimeEmployee hours: " + hours + ", Rate: " + rateOfPay;
    }
    
    
}
