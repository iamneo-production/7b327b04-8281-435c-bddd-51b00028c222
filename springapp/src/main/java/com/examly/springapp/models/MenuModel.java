package com.examly.springapp.models;

public class MenuModel {
    private String menuId;
    private String menuType;
    private String menuItems;
    private Double menuCost;

    public MenuModel(String menuId, String menuType, String menuItems, Double menuCost) {
        this.menuId = menuId;
        this.menuType = menuType;
        this.menuItems = menuItems;
        this.menuCost = menuCost;
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

    @Override
    public String toString() {
        return "MenuModel{" +
        "menuId=" + menuId +
        ", menuType='" + menuType + '\'' +
        ", menuItems='" + menuItems + '\'' +
        ", menuCost='" + menuCost + '\'' +
        ", menuCost=" + menuCost +
        '}';
    }
    
    
}
