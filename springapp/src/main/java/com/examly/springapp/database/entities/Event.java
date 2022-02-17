package com.examly.springapp.database.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String eventId;

    @Column(nullable = false, length = 100)
    private String eventName;

    @Column(nullable = false, length = 100)
    private String applicantName;

    @Lob
    private String applicantAddress;

    @Column(nullable = false, length = 13)
    private String applicantMobile;

    private String applicantEmail;

    @Lob
    private String eventAddress;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime eventTime;

    @ManyToOne
    private Menu menu;

    @Column(nullable = false)
    private Double eventCost;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBooked;

    @ManyToOne
    private User bookedBy;

    @ManyToMany
    private List<AddOn> addOns;

    public Event() {
    }

    public Event(
            String eventName,
            String applicantName,
            String applicantAddress,
            String applicantMobile,
            String applicantEmail,
            String eventAddress,
            LocalDate eventDate,
            LocalTime eventTime,
            Menu menu,
            Double eventCost,
            LocalDate dateBooked,
            User bookedBy,
            List<AddOn> addOns
    ) {
        this.eventName = eventName;
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
        this.applicantMobile = applicantMobile;
        this.applicantEmail = applicantEmail;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.menu = menu;
        this.eventCost = eventCost;
        this.dateBooked = dateBooked;
        this.bookedBy = bookedBy;
        this.addOns = addOns;
    }

    public Event(
            String eventId,
            String eventName,
            String applicantName,
            String applicantAddress,
            String applicantMobile,
            String applicantEmail,
            String eventAddress,
            LocalDate eventDate,
            LocalTime eventTime,
            Menu menu,
            Double eventCost,
            LocalDate dateBooked,
            User bookedBy,
            List<AddOn> addOns
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
        this.menu = menu;
        this.eventCost = eventCost;
        this.dateBooked = dateBooked;
        this.bookedBy = bookedBy;
        this.addOns = addOns;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Double getEventCost() {
        return eventCost;
    }

    public void setEventCost(Double eventCost) {
        this.eventCost = eventCost;
    }

    public LocalDate getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDate dateBooked) {
        this.dateBooked = dateBooked;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", applicantAddress='" + applicantAddress + '\'' +
                ", applicantMobile='" + applicantMobile + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", menu=" + menu +
                ", eventCost=" + eventCost +
                ", dateBooked=" + dateBooked +
                ", bookedBy=" + bookedBy +
                // ", addOns=" + addOns +
                '}';
    }
}
