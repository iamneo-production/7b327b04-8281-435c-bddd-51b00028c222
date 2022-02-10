package com.examly.springapp.models;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Component
@Table(name = "theme_info")
public class ThemeModel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer themeId;

    @Column(name = "name")
    private String themeName;

    @Column(name = "description")
    private String themeDescription;

    @Column(name = "photographer")
    private String themePhotographer;

    @Column(name = "videographer")
    private String themeVideographer;

    @Column(name = "themereturngift")
    private int themeReturnGift;

    @Column(name = "ratings")
    private int themeRatings;

    @Column(name = "themecost")
    private long themeCost;

    @Column(name = "themeimg")
    private String themeImageUrl;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
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

    public int getThemeReturnGift() {
        return themeReturnGift;
    }

    public void setThemeReturnGift(int themeReturnGift) {
        this.themeReturnGift = themeReturnGift;
    }

    public int getThemeRatings() {
        return themeRatings;
    }

    public void setThemeRatings(int themeRatings) {
        this.themeRatings = themeRatings;
    }

    public long getThemeCost() {
        return themeCost;
    }

    public void setThemeCost(long themeCost) {
        this.themeCost = themeCost;
    }

    public String getThemeImageUrl() {
        return themeImageUrl;
    }

    public void setThemeImageUrl(String themeImageUrl) {
        this.themeImageUrl = themeImageUrl;
    }

    
}
