package com.examly.springapp.database.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AddOn {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String addOnId;

    @Column(nullable = false, length = 100)
    private String addOnName;

    @Lob
    private String addOnDescription;

    @Column(nullable = false)
    private Double addOnPrice;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdded;

    @ManyToOne
    private User addedBy;

    public AddOn() {
    }

    public AddOn(
            String addOnName,
            String addOnDescription,
            Double addOnPrice,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.addOnName = addOnName;
        this.addOnDescription = addOnDescription;
        this.addOnPrice = addOnPrice;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public AddOn(
            String addOnId,
            String addOnName,
            String addOnDescription,
            Double addOnPrice,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.addOnId = addOnId;
        this.addOnName = addOnName;
        this.addOnDescription = addOnDescription;
        this.addOnPrice = addOnPrice;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public String getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(String addOnId) {
        this.addOnId = addOnId;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public String getAddOnDescription() {
        return addOnDescription;
    }

    public void setAddOnDescription(String addOnDescription) {
        this.addOnDescription = addOnDescription;
    }

    public Double getAddOnPrice() {
        return addOnPrice;
    }

    public void setAddOnPrice(Double addOnPrice) {
        this.addOnPrice = addOnPrice;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public String toString() {
        return "AddOn{" +
                "addOnId='" + addOnId + '\'' +
                ", addOnName='" + addOnName + '\'' +
                ", addOnDescription='" + addOnDescription + '\'' +
                ", addOnPrice=" + addOnPrice +
                ", dateAdded=" + dateAdded +
                ", addedBy=" + addedBy +
                '}';
    }
}
