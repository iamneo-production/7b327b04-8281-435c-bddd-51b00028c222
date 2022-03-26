package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.AddOn;
import com.examly.springapp.exceptions.AddOnNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.AddonModel;
import com.examly.springapp.services.AddOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddOnController {
    @Autowired
    AddOnService addOnService;

    @GetMapping(path = {"/admin/getAddon", "/user/getAddon"})
    public ResponseEntity<List<AddonModel>> getAddOns() {
        List<AddOn> addons = this.addOnService.getAddOns();
        List<AddonModel> addOnModelsResponse = new ArrayList<>();
        addons.forEach(addon -> {
            addOnModelsResponse.add(convertToAddOnModel(addon));
        });
        return new ResponseEntity<>(addOnModelsResponse, HttpStatus.OK);
    }

    @GetMapping(path = {"/admin/getAddon/{addOnId}", "/user/getAddon/{addOnId}"})
    public ResponseEntity<?> getAddOnDetails(@PathVariable("addOnId") String addOnId) {
        try {
            AddonModel addOnModelResponse = convertToAddOnModel(this.addOnService.getAddOn(addOnId));
            return new ResponseEntity<AddonModel>(addOnModelResponse, HttpStatus.OK);
        } catch (AddOnNotFoundException e) {
            return new ResponseEntity<String>("AddOn not found with ID: " + addOnId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/admin/addAddon")
    public ResponseEntity<?> addAddOn(@RequestBody AddonModel addOnModel, @RequestAttribute String user_id) {
        try {
            AddonModel addOnModelResponse = convertToAddOnModel(this.addOnService.addAddOn(addOnModel, user_id));
            return new ResponseEntity<AddonModel>(addOnModelResponse, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("Admin not found: " + user_id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/admin/editAddon/{addOnId}")
    public ResponseEntity<?> editAddOn(@PathVariable("addOnId") String addOnId, @RequestBody AddonModel addOnModel) {
        try {
            AddonModel addOnModelResponse = convertToAddOnModel(this.addOnService.editAddOn(addOnId, addOnModel));
            return new ResponseEntity<AddonModel>(addOnModelResponse, HttpStatus.OK);
        } catch (AddOnNotFoundException e) {
            return new ResponseEntity<String>("Addon not found with ID: " + addOnId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/admin/deleteAddon/{addOnId}")
    public ResponseEntity<?> deleteAddOn(@PathVariable("addOnId") String addOnId) {
        try {
            this.addOnService.deleteAddOn(addOnId);
            return new ResponseEntity<String>("AddOn Deleted Successfully.", HttpStatus.OK);
        } catch (AddOnNotFoundException e) {
            return new ResponseEntity<String>("AddOn not found with ID: " + addOnId, HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("AddOn cannot be deleted as it is being used by some events", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private AddonModel convertToAddOnModel(AddOn addon) {
        return new AddonModel(
                addon.getAddOnId(),
                addon.getAddOnName(),
                addon.getAddOnDescription(),
                addon.getAddOnPrice()
        );
    }
}
