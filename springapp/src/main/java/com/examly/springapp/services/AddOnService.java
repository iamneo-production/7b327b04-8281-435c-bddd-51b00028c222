package com.examly.springapp.services;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.exceptions.AddOnNotFoundException;
import com.examly.springapp.models.AddonModel;
import com.examly.springapp.database.repositories.AddOnRepo;
import com.examly.springapp.database.entities.AddOn;
import com.examly.springapp.database.entities.User;



@Service
public class AddOnService 
{
	@Autowired
	AddOnRepo addOnRepo;

    @Autowired
    private UserService userService;
    
    public List<AddOn> getAddOns() {
        return addOnRepo.findAll();
    }
    
    public AddOn getAddOn(String addOnId) throws AddOnNotFoundException {
        Optional<AddOn> addOnOptional = addOnRepo.findById(addOnId);
        
        return addOnOptional.orElseThrow(AddOnNotFoundException::new);
    }
    
    public AddOn addAddOn(AddonModel addOnModel, String addedById) throws UserNotFoundException {
        User addedByUser = userService.getUser(addedById);
        AddOn addOn = new AddOn(
        		addOnModel.getAddOnName(),
        		addOnModel.getAddOnDescription(),
        		addOnModel.getAddOnPrice(),
        		LocalDate.now(),
                addedByUser
        );
        
        return addOnRepo.save(addOn);
    }
    
    @Transactional
    public AddOn editAddOn(String addOnId, AddonModel addOnModel) throws AddOnNotFoundException {
        Optional<AddOn> addOnOptional = addOnRepo.findById(addOnId);
        AddOn addOn = addOnOptional.orElseThrow(AddOnNotFoundException::new);

        if (addOnModel.getAddOnName() != null && !Objects.equals(addOnModel.getAddOnName(), addOn.getAddOnName()))
            addOn.setAddOnName(addOnModel.getAddOnName());
        if (addOnModel.getAddOnDescription() != null && !Objects.equals(addOnModel.getAddOnDescription(), addOn.getAddOnDescription()))
            addOn.setAddOnDescription(addOnModel.getAddOnDescription());
        if (addOnModel.getAddOnPrice() != null && !Objects.equals(addOnModel.getAddOnPrice(), addOn.getAddOnPrice()))
            addOn.setAddOnPrice(addOnModel.getAddOnPrice());
        
        return addOn;
    }
    
    @Transactional
    public void deleteAddOn(String addOnId) throws AddOnNotFoundException {
        Optional<AddOn> addOnOptional = addOnRepo.findById(addOnId);
        AddOn addOn = addOnOptional.orElseThrow(AddOnNotFoundException::new);
        
        addOnRepo.delete(addOn);
    }

}
