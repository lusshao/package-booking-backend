package com.oocl.packagebooking.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Parcel {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String parcelNumber;
    private String recipients;
    private String callNumber;
    private int parcelStatus;
    private Timestamp orderTime;

    public Parcel() {
    }

    public Parcel(String parcelNumber, String recipients, String callNumber, int parcelStatus, Timestamp orderTime) {
        this.parcelNumber = parcelNumber;
        this.recipients = recipients;
        this.callNumber = callNumber;
        this.parcelStatus = parcelStatus;
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public int getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(int parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
}
