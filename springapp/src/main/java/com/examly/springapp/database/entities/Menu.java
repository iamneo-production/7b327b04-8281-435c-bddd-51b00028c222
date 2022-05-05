package com.examly.springapp.database.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String menuId;

    @Column(nullable = false, length = 50)
    private String menuType;

    @Lob
    @Column(nullable = false)
    private String menuItems;

    @Column(nullable = false)
    private Double menuCost;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdded;

    @ManyToOne
    private User addedBy;

    public Menu() {
    }

    public Menu(
            String menuType,
            String menuItems,
            Double menuCost,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.menuType = menuType;
        this.menuItems = menuItems;
        this.menuCost = menuCost;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public Menu(
            String menuId,
            String menuType,
            String menuItems,
            Double menuCost,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.menuId = menuId;
        this.menuType = menuType;
        this.menuItems = menuItems;
        this.menuCost = menuCost;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String menuItems) {
        this.menuItems = menuItems;
    }

    public Double getMenuCost() {
        return menuCost;
    }

    public void setMenuCost(Double menuCost) {
        this.menuCost = menuCost;
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
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuItems='" + menuItems + '\'' +
                ", menuCost=" + menuCost +
                ", dateAdded=" + dateAdded +
                ", addedBy=" + addedBy +
                '}';
    }
}
