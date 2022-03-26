package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.Event;
import com.examly.springapp.exceptions.AddOnNotFoundException;
import com.examly.springapp.exceptions.MenuNotFoundException;
import com.examly.springapp.exceptions.ThemeNotFoundException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.EventModel;
import com.examly.springapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(path = "/admin/getEvents")
    public ResponseEntity<List<EventModel>> getEvents() {
        List<Event> events = eventService.getEvents();
        List<EventModel> eventModelsResponse = new ArrayList<>();
        events.forEach(event -> {
            List<String> addOnIds = new ArrayList<>();
            event.getAddOns().forEach(addOn -> addOnIds.add(addOn.getAddOnId()));
            eventModelsResponse.add(
                    new EventModel(
                            event.getEventId(),
                            event.getEventName(),
                            event.getApplicantName(),
                            event.getApplicantAddress(),
                            event.getApplicantMobile(),
                            event.getApplicantEmail(),
                            event.getEventAddress(),
                            event.getEventDate(),
                            event.getEventTime(),
                            event.getTheme().getThemeId(),
                            event.getMenu().getMenuId(),
                            event.getEventCost(),
                            addOnIds,
                            event.getState()
                    )
            );
        });
        return new ResponseEntity<>(eventModelsResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/user/bookEvent")
    public ResponseEntity<?> addEvent(@RequestBody EventModel eventModel, @RequestAttribute String user_id) {
        try {
            Event event = eventService.addEvent(eventModel, user_id);
            List<String> addOnIds = new ArrayList<>();
            event.getAddOns().forEach(addOn -> addOnIds.add(addOn.getAddOnId()));
            EventModel eventModelResponse = new EventModel(
                    event.getEventId(),
                    event.getEventName(),
                    event.getApplicantName(),
                    event.getApplicantAddress(),
                    event.getApplicantMobile(),
                    event.getApplicantEmail(),
                    event.getEventAddress(),
                    event.getEventDate(),
                    event.getEventTime(),
                    event.getTheme().getThemeId(),
                    event.getMenu().getMenuId(),
                    event.getEventCost(),
                    addOnIds,
                    event.getState()
            );
            return new ResponseEntity<EventModel>(eventModelResponse, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("User not found: " + user_id, HttpStatus.NOT_FOUND);
        } catch (ThemeNotFoundException e) {
            return new ResponseEntity<String>("Theme not found: " + eventModel.getThemeId(), HttpStatus.NOT_FOUND);
        } catch (MenuNotFoundException e) {
            return new ResponseEntity<String>("Menu not found: " + eventModel.getMenuId(), HttpStatus.NOT_FOUND);
        } catch (AddOnNotFoundException e) {
            return new ResponseEntity<String>("Some Add On is not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
