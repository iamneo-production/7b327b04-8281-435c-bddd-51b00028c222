package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.Menu;
import com.examly.springapp.exceptions.MenuNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.MenuModel;
import com.examly.springapp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping(path = {"/admin/getMenu", "/user/getMenu"})
    public ResponseEntity<List<MenuModel>> getMenus() {
        List<Menu> menus = this.menuService.getMenus();
        List<MenuModel> menuModelsResponse = new ArrayList<>();
        menus.forEach(menu -> {
            menuModelsResponse.add(new MenuModel(
                    menu.getMenuId(),
                    menu.getMenuType(),
                    menu.getMenuItems(),
                    menu.getMenuCost()
            ));
        });
        return new ResponseEntity<>(menuModelsResponse, HttpStatus.OK);
    }

    @GetMapping(path = {"/admin/getMenu/{menuId}", "/user/getMenu/{menuId}"})
    public ResponseEntity<?> getMenu(@PathVariable("menuId") String menuId) {
        try {
            Menu menu = this.menuService.getMenu(menuId);
            MenuModel menuModelResponse = new MenuModel(
                    menu.getMenuId(),
                    menu.getMenuType(),
                    menu.getMenuItems(),
                    menu.getMenuCost()
            );
            return new ResponseEntity<MenuModel>(menuModelResponse, HttpStatus.OK);
        } catch (MenuNotFoundException e) {
            return new ResponseEntity<String>("Menu not found with ID: " + menuId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/admin/addMenu")
    public ResponseEntity<?> addMenu(@RequestBody MenuModel menuModel, @RequestAttribute String user_id) {
        try {
            Menu menu = menuService.addMenu(menuModel, user_id);
            MenuModel menuModelResponse = new MenuModel(
                menu.getMenuId(),
                menu.getMenuType(),
                menu.getMenuItems(),
                menu.getMenuCost()
            );
            return new ResponseEntity<MenuModel>(menuModelResponse, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("Admin not found: " + user_id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/admin/editMenu/{menuId}")
    public ResponseEntity<?> editMenu(@PathVariable("menuId") String menuId, @RequestBody MenuModel menuModel) {
        try {
            Menu menu = this.menuService.editMenu(menuId, menuModel);
            MenuModel menuModelResponse = new MenuModel(
                menu.getMenuId(),
                menu.getMenuType(),
                menu.getMenuItems(),
                menu.getMenuCost()
            );
            return new ResponseEntity<MenuModel>(menuModelResponse, HttpStatus.OK);
        } catch (MenuNotFoundException e) {
            return new ResponseEntity<String>("Menu not found with ID: " + menuId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/admin/deleteMenu/{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable("menuId") String menuId) {
        try {
            this.menuService.deleteMenu(menuId);
            return new ResponseEntity<String>("Menu Deleted Successfully.", HttpStatus.OK);
        } catch (MenuNotFoundException e) {
            return new ResponseEntity<String>("Menu not found with ID: " + menuId, HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("Menu cannot be deleted as it is being used by some events", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
