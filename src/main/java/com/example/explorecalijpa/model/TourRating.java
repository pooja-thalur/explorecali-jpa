package com.example.explorecalijpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;


/**
 * Rating of a Tour by a Customer
 *
 * Created by Mary Ellen Bowman
 */
@Entity
@Table(name = "tour_rating")
@Data
public class TourRating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Tour getTour() {
    return tour;
}

public void setTour(Tour tour) {
    this.tour = tour;
}

public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
}

public void setScore(Integer score) {
    this.score = score;
}

public void setComment(String comment) {
    this.comment = comment;
}

@ManyToOne
  @JoinColumn(name = "tour_id")
  private Tour tour;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(nullable = false)
  private Integer score;

  @Column
  private String comment;

  protected TourRating() {
  }

  /**
   * Create a fully initialized TourRating.
   *
   * @param tour       the tour.
   * @param customerId the customer identifier.
   * @param score      Integer score (1-5)
   * @param comment    Optional comment from the customer
   */
  public TourRating(Tour tour, Integer customerId, Integer score, String comment) {
    this.tour = tour;
    this.customerId = customerId;
    this.score = score;
    this.comment = comment;
  }

  /**
   * Create a fully initialized TourRating.
   *
   * @param tour       the tour.
   * @param customerId the customer identifier.
   * @param score      Integer score (1-5)
   */
  public TourRating(Tour tour, Integer customerId, Integer score) {
    this.tour = tour;
    this.customerId = customerId;
    this.score = score;
  }

    public @Min(0) @Max(5) Integer getScore() {        
        return this.score;
    }
    
    public String getComment() {        
        return this.comment;
    }
    
    public Integer getCustomerId() {        
        return this.customerId;
    }

}