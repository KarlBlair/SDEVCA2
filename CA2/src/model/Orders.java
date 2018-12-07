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
    private int oID;
    private int orderNum;
    private int quantity;
    private Date orderDate;

    public int getOID() {
        return oID;
    }

    public void setOID(int oID) {
        this.oID = oID;
    }

    public Orders(int oID, int orderNum, int quantity, Date orderDate) {
        this.oID = oID;
        this.orderNum = orderNum;
        this.quantity = quantity;
        this.orderDate = orderDate;
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
        return "Order{" + "oID=" + oID + ", orderNum=" + orderNum + ", quantity=" + quantity + ", orderDate=" + orderDate + '}';
    }
    
    
}