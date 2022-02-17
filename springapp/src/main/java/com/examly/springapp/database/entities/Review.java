package com.examly.springapp.database.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String reviewId;

    @Column(nullable = false)
    private Double rating;

    @Lob
    private String reviewDescription;

    @ManyToOne
    private User reviewBy;

    @ManyToOne
    private Event event;

    public Review() {
    }

    public Review(Double rating, String reviewDescription, User reviewBy, Event event) {
        this.rating = rating;
        this.reviewDescription = reviewDescription;
        this.reviewBy = reviewBy;
        this.event = event;
    }

    public Review(String reviewId, Double rating, String reviewDescription, User reviewBy, Event event) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewDescription = reviewDescription;
        this.reviewBy = reviewBy;
        this.event = event;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public User getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(User reviewBy) {
        this.reviewBy = reviewBy;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", rating=" + rating +
                ", reviewDescription='" + reviewDescription + '\'' +
                ", reviewBy=" + reviewBy +
                ", event=" + event +
                '}';
    }
}
