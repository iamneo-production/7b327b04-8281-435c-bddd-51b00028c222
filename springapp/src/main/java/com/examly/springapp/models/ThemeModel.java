package com.examly.springapp.models;

public class ThemeModel {
    private String themeId;
    private String themeName;
    private String themeDescription;
    private String themePhotographer;
    private String themeVideographer;
    private String themeReturnGift;
    private Double themeCost;
    private String themeImageUrl;

    public ThemeModel(
            String themeId,
            String themeName,
            String themeDescription,
            String themePhotographer,
            String themeVideographer,
            String themeReturnGift,
            Double themeCost,
            String themeImageUrl
    ) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.themePhotographer = themePhotographer;
        this.themeVideographer = themeVideographer;
        this.themeReturnGift = themeReturnGift;
        this.themeCost = themeCost;
        this.themeImageUrl = themeImageUrl;
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

    public String getThemeImageUrl() {
        return themeImageUrl;
    }

    public void setThemeImageUrl(String themeImageUrl) {
        this.themeImageUrl = themeImageUrl;
    }

    @Override
    public String toString() {
        return "ThemeModel{" +
                "themeId=" + themeId +
                ", themeName='" + themeName + '\'' +
                ", themeDescription='" + themeDescription + '\'' +
                ", themePhotographer='" + themePhotographer + '\'' +
                ", themeVideographer='" + themeVideographer + '\'' +
                ", themeReturnGift='" + themeReturnGift + '\'' +
                ", themeCost=" + themeCost +
                ", themeImageUrl='" + themeImageUrl + '\'' +
                '}';
    }
}
