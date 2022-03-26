package com.examly.springapp.models;

import com.examly.springapp.database.enums.EventState;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventModel {
    private String eventId;
    private String eventName;
    private String applicantName;
    private String applicantAddress;
    private String applicantMobile;
    private String applicantEmail;
    private String eventAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime eventTime;
    private String themeId;
    private String menuId;
    private Double eventCost;
    private List<String> addOnIds;
    private EventState eventState;

    public EventModel(
            String eventId,
            String eventName,
            String applicantName,
            String applicantAddress,
            String applicantMobile,
            String applicantEmail,
            String eventAddress,
            LocalDate eventDate,
            LocalTime eventTime,
            String themeId,
            String menuId,
            Double eventCost,
            List<String> addOnIds,
            EventState eventState
    ) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
        this.applicantMobile = applicantMobile;
        this.applicantEmail = applicantEmail;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.themeId = themeId;
        this.menuId = menuId;
        this.eventCost = eventCost;
        this.addOnIds = addOnIds;
        this.eventState = eventState;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Double getEventCost() {
        return eventCost;
    }

    public void setEventCost(Double eventCost) {
        this.eventCost = eventCost;
    }

    public List<String> getAddOnIds() {
        return addOnIds;
    }

    public void setAddOnIds(List<String> addOnIds) {
        this.addOnIds = addOnIds;
    }

    public EventState getEventState() {
        return eventState;
    }

    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", applicantAddress='" + applicantAddress + '\'' +
                ", applicantMobile='" + applicantMobile + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", themeId='" + themeId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", eventCost=" + eventCost +
                ", addOnIds=" + addOnIds +
                ", eventState=" + eventState +
                '}';
    }
}
