package com.examly.springapp.services;

import com.examly.springapp.database.entities.*;
import com.examly.springapp.database.enums.EventState;
import com.examly.springapp.database.repositories.EventRepo;
import com.examly.springapp.exceptions.*;
import com.examly.springapp.models.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private AddOnService addOnService;

    public List<Event> getEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(String eventId) throws EventNotFoundException {
        Optional<Event> eventOptional = eventRepo.findById(eventId);
        return eventOptional.orElseThrow(EventNotFoundException::new);
    }

    public List<Event> getEventByUser(String userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        return eventRepo.findByUser(user);
    }

    public Event addEvent(EventModel eventModel, String bookedByUserId) throws UserNotFoundException, ThemeNotFoundException, MenuNotFoundException, AddOnNotFoundException {
        User user = userService.getUser(bookedByUserId);
        Theme theme = themeService.getTheme(eventModel.getThemeId());
        Menu menu = menuService.getMenu(eventModel.getMenuId());
        List<AddOn> addOns = new ArrayList<>();
        for (String addOnId : eventModel.getAddOnIds()) {
            addOns.add(addOnService.getAddOn(addOnId));
        }

        Double eventCost = theme.getThemeCost()+ menu.getMenuCost();
        for(AddOn addOn: addOns)
            eventCost+=addOn.getAddOnPrice();

        eventCost+= 12D; // Additional Cost

        Event event = new Event(
                eventModel.getEventName(),
                eventModel.getApplicantName(),
                eventModel.getApplicantAddress(),
                eventModel.getApplicantMobile(),
                eventModel.getApplicantEmail(),
                eventModel.getEventAddress(),
                eventModel.getEventDate(),
                eventModel.getEventTime(),
                theme,
                menu,
                eventCost,
                LocalDate.now(),
                user,
                addOns,
                EventState.BOOKED
        );
        return eventRepo.save(event);
    }

}
