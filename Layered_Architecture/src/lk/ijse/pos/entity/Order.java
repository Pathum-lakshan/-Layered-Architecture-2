/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/29/2022
 * Time        : 6:04 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.entity;

import java.time.LocalDate;

public class Order {
    private String oid;
    private LocalDate date;
    private String customerID;

    public Order() {
    }

    public Order(String oid, LocalDate date, String customerID) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
