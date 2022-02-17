package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.Theme;
import com.examly.springapp.exceptions.ThemeNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.ThemeModel;
import com.examly.springapp.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping(path = {"/admin/getTheme", "/user/getTheme"})
    public ResponseEntity<List<ThemeModel>> getThemes() {
        List<Theme> themes = this.themeService.getThemes();
        List<ThemeModel> themeModelsResponse = new ArrayList<>();
        themes.forEach(theme -> {
            themeModelsResponse.add(new ThemeModel(
                    theme.getThemeId(),
                    theme.getThemeName(),
                    theme.getThemeDescription(),
                    theme.getThemePhotographer(),
                    theme.getThemeVideographer(),
                    theme.getThemeReturnGift(),
                    theme.getThemeCost(),
                    theme.getThemeImageUrl()
            ));
        });
        return new ResponseEntity<>(themeModelsResponse, HttpStatus.OK);
    }

    @GetMapping(path = {"/admin/getTheme/{themeId}", "/user/getTheme/{themeId}"})
    public ResponseEntity<?> getTheme(@PathVariable("themeId") String themeId) {
        try {
            Theme theme = this.themeService.getTheme(themeId);
            ThemeModel themeModelResponse = new ThemeModel(
                    theme.getThemeId(),
                    theme.getThemeName(),
                    theme.getThemeDescription(),
                    theme.getThemePhotographer(),
                    theme.getThemeVideographer(),
                    theme.getThemeReturnGift(),
                    theme.getThemeCost(),
                    theme.getThemeImageUrl()
            );
            return new ResponseEntity<ThemeModel>(themeModelResponse, HttpStatus.OK);
        } catch (ThemeNotFoundException e) {
            return new ResponseEntity<String>("Theme not found with ID: " + themeId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/admin/addTheme")
    public ResponseEntity<?> addTheme(@RequestBody ThemeModel themeModel, @RequestAttribute String user_id) {
        try {
            Theme theme = themeService.addTheme(themeModel, user_id);
            ThemeModel themeModelResponse = new ThemeModel(
                    theme.getThemeId(),
                    theme.getThemeName(),
                    theme.getThemeDescription(),
                    theme.getThemePhotographer(),
                    theme.getThemeVideographer(),
                    theme.getThemeReturnGift(),
                    theme.getThemeCost(),
                    theme.getThemeImageUrl()
            );
            return new ResponseEntity<ThemeModel>(themeModelResponse, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("Admin not found: " + user_id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/admin/editTheme/{themeId}")
    public ResponseEntity<?> editTheme(@PathVariable("themeId") String themeId, @RequestBody ThemeModel themeModel) {
        try {
            Theme theme = this.themeService.editTheme(themeId, themeModel);
            ThemeModel themeModelResponse = new ThemeModel(
                    theme.getThemeId(),
                    theme.getThemeName(),
                    theme.getThemeDescription(),
                    theme.getThemePhotographer(),
                    theme.getThemeVideographer(),
                    theme.getThemeReturnGift(),
                    theme.getThemeCost(),
                    theme.getThemeImageUrl()
            );
            return new ResponseEntity<ThemeModel>(themeModelResponse, HttpStatus.OK);
        } catch (ThemeNotFoundException e) {
            return new ResponseEntity<String>("Theme not found with ID: " + themeId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/admin/deleteTheme/{themeId}")
    public ResponseEntity<?> deleteTheme(@PathVariable("themeId") String themeId) {
        try {
            this.themeService.deleteTheme(themeId);
            return new ResponseEntity<String>("Theme Deleted Successfully.", HttpStatus.OK);
        } catch (ThemeNotFoundException e) {
            return new ResponseEntity<String>("Theme not found with ID: " + themeId, HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("Theme cannot be deleted as it is being used by some events", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
