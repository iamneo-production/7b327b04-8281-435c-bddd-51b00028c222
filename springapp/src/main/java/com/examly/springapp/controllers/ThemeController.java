package com.examly.springapp.controllers;

import com.examly.springapp.models.ThemeModel;
import com.examly.springapp.services.ThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class ThemeController 
{
    @Autowired
    ThemeService themeService;

    @PostMapping(path = "/admin/addTheme")
    public boolean addTheme(@RequestBody ThemeModel themeModel)
    {
        return this.themeService.addTheme(themeModel);
    }

    @PutMapping(path = "/admin/editTheme/{themeId}")
    public boolean updateThemeByAdmin(@PathVariable String themeId, @RequestBody ThemeModel themeModel)
    {
        return this.themeService.updateTheme(Integer.parseInt(themeId), themeModel);
    }

    @DeleteMapping(path = "/admin/deleteTheme/{themeId}")
    public boolean deleteThemeByAdmin(@PathVariable String themeId)
    {
        return this.themeService.deleteTheme(Integer.parseInt(themeId));
    }

    @GetMapping(path = "/admin/getTheme")
    public List<ThemeModel> viewThemeByAdmin()
    {
        return this.themeService.viewTheme();
    }

    @GetMapping(path = "/admin/getTheme/{themeId}")
    public ThemeModel viewThemeByAdmin(@PathVariable String themeId)
    {
        return this.themeService.viewTheme(Integer.parseInt(themeId));
    }

    @PutMapping(path = "/user/editTheme/{themeId}")
    public boolean updateThemeByUser(@PathVariable String themeId, @RequestBody ThemeModel themeModel)
    {
        return this.themeService.updateTheme(Integer.parseInt(themeId), themeModel);
    }

    @DeleteMapping(path = "/user/deleteTheme/{themeId}")
    public boolean deleteThemeByUser(@PathVariable String themeId)
    {
        return this.themeService.deleteTheme(Integer.parseInt(themeId));
    }

    @GetMapping(path = "/user/getTheme")
    public List<ThemeModel> viewThemeByUser()
    {
        return this.themeService.viewTheme();
    }

    @GetMapping(path = "/user/getTheme/{themeId}")
    public ThemeModel viewThemeByUser(@PathVariable String themeId)
    {
        return this.themeService.viewTheme(Integer.parseInt(themeId));
    }

}
