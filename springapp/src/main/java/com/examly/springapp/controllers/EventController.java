package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.Event;
import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.enums.Role;
import com.examly.springapp.exceptions.*;
import com.examly.springapp.models.EventModel;
import com.examly.springapp.services.EventService;
import com.examly.springapp.services.UserService;
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
    @Autowired
    private UserService userService;

    @GetMapping(path = "/admin/getEvents")
    public ResponseEntity<List<EventModel>> getEvents() {
        List<Event> events = eventService.getEvents();
        List<EventModel> eventModelsResponse = new ArrayList<>();
        events.forEach(event -> {
            EventModel eventModel = convertToEventModel(event);
            eventModelsResponse.add(eventModel);
        });
        return new ResponseEntity<>(eventModelsResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/admin/getEvent/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable("eventId") String eventId) {
        try {
            EventModel eventModelResponse = convertToEventModel(eventService.getEventById(eventId));
            return new ResponseEntity<EventModel>(eventModelResponse, HttpStatus.OK);
        } catch (EventNotFoundException e) {
            return new ResponseEntity<String>("Event not found: " + eventId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/user/getEvent/{eventId}")
    public ResponseEntity<?> getEventByUserId(@PathVariable("eventId") String eventId, @RequestAttribute String user_id) {
        try {
            Event event = eventService.getEventById(eventId);
            if (!event.getBookedBy().getId().equals(user_id))
                return new ResponseEntity<String>("You are not allowed to view this event", HttpStatus.FORBIDDEN);
            EventModel eventModelResponse = convertToEventModel(event);
            return new ResponseEntity<EventModel>(eventModelResponse, HttpStatus.OK);
        } catch (EventNotFoundException e) {
            return new ResponseEntity<String>("Event not found: " + eventId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/user/getEvents")
    public ResponseEntity<?> getEventsOfUser(@RequestAttribute String user_id) {
        try {
            List<Event> events = eventService.getEventByUser(user_id);

            List<EventModel> eventModelsResponse = new ArrayList<>();
            events.forEach(event -> {
                EventModel eventModel = convertToEventModel(event);
                eventModelsResponse.add(eventModel);
            });
            return new ResponseEntity<List<EventModel>>(eventModelsResponse, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("User not found: " + user_id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/user/bookEvent")
    public ResponseEntity<?> addEvent(@RequestBody EventModel eventModel, @RequestAttribute String user_id) {
        try {
            EventModel eventModelResponse = convertToEventModel(eventService.addEvent(eventModel, user_id));
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

    @PutMapping(path = "/admin/markEventConducted/{eventId}")
    public ResponseEntity<?> markEventConducted(@PathVariable("eventId") String eventId) {
        try {
            eventService.markEventConducted(eventId);
            return new ResponseEntity<String>("Event Marked Conducted", HttpStatus.OK);
        } catch (EventNotFoundException e) {
            return new ResponseEntity<String>("Event not found: " + eventId, HttpStatus.NOT_FOUND);
        } catch (EventStateUpdateException e) {
            return new ResponseEntity<String>("Cannot Update Event", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = {"/admin/cancelEvent/{eventId}", "/user/cancelEvent/{eventId}"})
    public ResponseEntity<?> cancelEvent(@PathVariable("eventId") String eventId, @RequestAttribute String user_id) {
        try {
            User user = userService.getUser(user_id);
            Event event = eventService.getEventById(eventId);
            if (user.getRole() == Role.ADMIN || user.getId().equals(event.getBookedBy().getId())) {
                eventService.cancelEvent(event);
                return new ResponseEntity<String>("Event Cancelled", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Invalid Permissions", HttpStatus.FORBIDDEN);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("User in this token does not exist", HttpStatus.FORBIDDEN);
        } catch (EventStateUpdateException e) {
            return new ResponseEntity<String>("Cannot cancel event: " + eventId, HttpStatus.FORBIDDEN);
        } catch (EventNotFoundException e) {
            return new ResponseEntity<String>("Event not found: " + eventId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private EventModel convertToEventModel(Event event) {
        List<String> addOnIds = new ArrayList<>();
        event.getAddOns().forEach(addOn -> addOnIds.add(addOn.getAddOnId()));
        return new EventModel(
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
    }

}
