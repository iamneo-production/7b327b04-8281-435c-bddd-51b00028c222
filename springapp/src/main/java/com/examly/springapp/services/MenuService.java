package com.examly.springapp.services;

import com.examly.springapp.database.entities.Menu;
import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.repositories.MenuRepo;
import com.examly.springapp.exceptions.MenuNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepo menuRepo;

    @Autowired
    private UserService userService;

    public List<Menu> getMenus() {
        return menuRepo.findAll();
    }

    public Menu getMenu(String menuId) throws MenuNotFoundException {
        Optional<Menu> menuOptional = menuRepo.findById(menuId);
        return menuOptional.orElseThrow(MenuNotFoundException::new);
    }

    public Menu addMenu(MenuModel menuModel, String addedById) throws UserNotFoundException {
        User addedByUser = userService.getUser(addedById);
        Menu menu = new Menu(
                menuModel.getMenuType(),
                menuModel.getMenuItems(),
                menuModel.getMenuCost(),
                LocalDate.now(),
                addedByUser
        );
        return menuRepo.save(menu);
    }

    @Transactional
    public Menu editMenu(String menuId, MenuModel menuModel) throws MenuNotFoundException {
        Optional<Menu> menuOptional = menuRepo.findById(menuId);
        Menu menu = menuOptional.orElseThrow(MenuNotFoundException::new);

        if (menuModel.getMenuType() != null && !Objects.equals(menuModel.getMenuType(), menu.getMenuType()))
            menu.setMenuType(menuModel.getMenuType());
        if (menuModel.getMenuItems() != null && !Objects.equals(menuModel.getMenuItems(), menu.getMenuItems()))
            menu.setMenuItems(menuModel.getMenuItems());
        if (menuModel.getMenuCost() != null && !Objects.equals(menuModel.getMenuCost(), menu.getMenuCost()))
            menu.setMenuCost(menuModel.getMenuCost());
        return menu;
    }

    @Transactional
    public void deleteMenu(String menuId) throws MenuNotFoundException {
        Optional<Menu> menuOptional = menuRepo.findById(menuId);
        Menu menu = menuOptional.orElseThrow(MenuNotFoundException::new);
        menuRepo.delete(menu);
    }

}
