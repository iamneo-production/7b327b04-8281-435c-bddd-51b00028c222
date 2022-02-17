package com.examly.springapp.database.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Theme {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String themeId;

    @Column(nullable = false, length = 100)
    private String themeName;

    private String themeImageUrl;

    @Lob
    private String themeDescription;

    @Column(length = 100)
    private String themePhotographer;

    @Column(length = 100)
    private String themeVideographer;

    @Column(length = 100)
    private String themeReturnGift;

    @Column(nullable = false)
    private Double themeCost;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdded;

    @ManyToOne
    private User addedBy;

    public Theme() {
    }

    public Theme(
            String themeName,
            String themeImageUrl,
            String themeDescription,
            String themePhotographer,
            String themeVideographer,
            String themeReturnGift,
            Double themeCost,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.themeName = themeName;
        this.themeImageUrl = themeImageUrl;
        this.themeDescription = themeDescription;
        this.themePhotographer = themePhotographer;
        this.themeVideographer = themeVideographer;
        this.themeReturnGift = themeReturnGift;
        this.themeCost = themeCost;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public Theme(
            String themeId,
            String themeName,
            String themeImageUrl,
            String themeDescription,
            String themePhotographer,
            String themeVideographer,
            String themeReturnGift,
            Double themeCost,
            LocalDate dateAdded,
            User addedBy
    ) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeImageUrl = themeImageUrl;
        this.themeDescription = themeDescription;
        this.themePhotographer = themePhotographer;
        this.themeVideographer = themeVideographer;
        this.themeReturnGift = themeReturnGift;
        this.themeCost = themeCost;
        this.dateAdded = dateAdded;
        this.addedBy = addedBy;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeImageUrl() {
        return themeImageUrl;
    }

    public void setThemeImageUrl(String themeImageUrl) {
        this.themeImageUrl = themeImageUrl;
    }

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    public String getThemePhotographer() {
        return themePhotographer;
    }

    public void setThemePhotographer(String themePhotographer) {
        this.themePhotographer = themePhotographer;
    }

    public String getThemeVideographer() {
        return themeVideographer;
    }

    public void setThemeVideographer(String themeVideographer) {
        this.themeVideographer = themeVideographer;
    }

    public String getThemeReturnGift() {
        return themeReturnGift;
    }

    public void setThemeReturnGift(String themeReturnGift) {
        this.themeReturnGift = themeReturnGift;
    }

    public Double getThemeCost() {
        return themeCost;
    }

    public void setThemeCost(Double themeCost) {
        this.themeCost = themeCost;
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
        return "Theme{" +
                "themeId='" + themeId + '\'' +
                ", themeName='" + themeName + '\'' +
                ", themeImageUrl='" + themeImageUrl + '\'' +
                ", themeDescription='" + themeDescription + '\'' +
                ", themePhotographer='" + themePhotographer + '\'' +
                ", themeVideographer='" + themeVideographer + '\'' +
                ", themeReturnGift='" + themeReturnGift + '\'' +
                ", themeCost=" + themeCost +
                ", dateAdded=" + dateAdded +
                ", addedBy=" + addedBy +
                '}';
    }
}
