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
@Entity
@Table(name = "ORDERS")

@SequenceGenerator(name="oid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="oid_seq")
    @Column(name="ID")
    private int ID;
    private int orderNum;
    private int quantity;
    private Date orderDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Orders(int ID, int orderNum, int quantity, Date orderDate) {
        this.ID = ID;
        this.orderNum = orderNum;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    
    public Orders() {
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" + "oID=" + ID + ", orderNum=" + orderNum + ", quantity=" + quantity + ", orderDate=" + orderDate + '}';
    }
    
    
}