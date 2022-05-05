package com.examly.springapp.services;

import com.examly.springapp.database.entities.Theme;
import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.repositories.ThemeRepo;
import com.examly.springapp.exceptions.ThemeNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.ThemeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    ThemeRepo themeRepo;

    @Autowired
    private UserService userService;

    public List<Theme> getThemes() {
        return themeRepo.findAll();
    }

    public Theme getTheme(String themeId) throws ThemeNotFoundException {
        Optional<Theme> themeOptional = themeRepo.findById(themeId);
        return themeOptional.orElseThrow(ThemeNotFoundException::new);
    }

    public Theme addTheme(ThemeModel themeModel, String addedById) throws UserNotFoundException {
        User addedByUser = userService.getUser(addedById);
        Theme theme = new Theme(
                themeModel.getThemeName(),
                themeModel.getThemeImageUrl(),
                themeModel.getThemeDescription(),
                themeModel.getThemePhotographer(),
                themeModel.getThemeVideographer(),
                themeModel.getThemeReturnGift(),
                themeModel.getThemeCost(),
                LocalDate.now(),
                addedByUser
        );
        return themeRepo.save(theme);
    }

    @Transactional
    public Theme editTheme(String themeId, ThemeModel themeModel) throws ThemeNotFoundException {
        Optional<Theme> themeOptional = themeRepo.findById(themeId);
        Theme theme = themeOptional.orElseThrow(ThemeNotFoundException::new);

        if (themeModel.getThemeName() != null && !Objects.equals(themeModel.getThemeName(), theme.getThemeName()))
            theme.setThemeName(themeModel.getThemeName());
        if (themeModel.getThemeImageUrl() != null && !Objects.equals(themeModel.getThemeImageUrl(), theme.getThemeImageUrl()))
            theme.setThemeImageUrl(themeModel.getThemeImageUrl());
        if (themeModel.getThemeDescription() != null && !Objects.equals(themeModel.getThemeDescription(), theme.getThemeDescription()))
            theme.setThemeDescription(themeModel.getThemeDescription());
        if (themeModel.getThemePhotographer() != null && !Objects.equals(themeModel.getThemePhotographer(), theme.getThemePhotographer()))
            theme.setThemePhotographer(themeModel.getThemePhotographer());
        if (themeModel.getThemeVideographer() != null && !Objects.equals(themeModel.getThemeVideographer(), theme.getThemeVideographer()))
            theme.setThemeVideographer(themeModel.getThemeVideographer());
        if (themeModel.getThemeReturnGift() != null && !Objects.equals(themeModel.getThemeReturnGift(), theme.getThemeReturnGift()))
            theme.setThemeReturnGift(themeModel.getThemeReturnGift());
        if (themeModel.getThemeCost() != null && !Objects.equals(themeModel.getThemeCost(), theme.getThemeCost()))
            theme.setThemeCost(themeModel.getThemeCost());
        return theme;
    }

    @Transactional
    public void deleteTheme(String themeId) throws ThemeNotFoundException {
        Optional<Theme> themeOptional = themeRepo.findById(themeId);
        Theme theme = themeOptional.orElseThrow(ThemeNotFoundException::new);
        themeRepo.delete(theme);
    }

}
