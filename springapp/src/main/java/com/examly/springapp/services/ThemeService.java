package com.examly.springapp.services;
import com.examly.springapp.database.repositories.ThemeRepo;
import com.examly.springapp.models.ThemeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ThemeService 
{
    @Autowired
    ThemeRepo themeRepo;

    public boolean addTheme(ThemeModel themeModel)
    {
        themeRepo.save(themeModel);
        return true;
    }

    public boolean updateTheme(int themeId, ThemeModel themeModelOld)
    {
        ThemeModel themeModelNew = themeRepo.findById(themeId).get();
        themeModelNew.setThemeName(themeModelOld.getThemeName());
        themeModelNew.setThemeDescription(themeModelOld.getThemeDescription());
        themeModelNew.setThemePhotographer(themeModelOld.getThemePhotographer());
        themeModelNew.setThemeVideographer(themeModelOld.getThemeVideographer());
        themeModelNew.setThemeImageUrl(themeModelOld.getThemeImageUrl());
        themeModelNew.setThemeReturnGift(themeModelOld.getThemeReturnGift());
        themeModelNew.setThemeRatings(themeModelOld.getThemeRatings());

        themeRepo.save(themeModelNew);
        return true;
    }

    public boolean deleteTheme(int themeId)
    {
        themeRepo.deleteById(themeId);
        return true;
    }

    public List<ThemeModel> viewTheme()
    {
        return themeRepo.findAll();
    }

    public ThemeModel viewTheme(int themeId)
    {
        return themeRepo.findById(themeId).get();
    }
}
