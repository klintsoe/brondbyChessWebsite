package dk.klintsoe.brondbyChessWebsite.model.rating;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ratingId;

    @ManyToOne
    @JsonIgnore //to avoid circle reference
    @JoinColumn(name = "personId")
    private Person person;


    private int dkRating;
    private int eloRating;
    private int hurtigRating;
    private int lynRating;
    private int  fideRating;
    private int kFactor;

    private LocalDate updated_Date;

    public Rating(int dkRating, int eloRating, int hurtigRating, int lynRating, int fideRating, int kFactor, LocalDate updated_Date) {
        this.dkRating = dkRating;
        this.eloRating = eloRating;
        this.hurtigRating = hurtigRating;
        this.lynRating = lynRating;
        this.fideRating = fideRating;
        this.kFactor = kFactor;
        this.updated_Date = updated_Date;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getDkRating() {
        return dkRating;
    }

    public void setDkRating(int dkRating) {
        this.dkRating = dkRating;
    }

    public int getEloRating() {
        return eloRating;
    }

    public void setEloRating(int eloRating) {
        this.eloRating = eloRating;
    }

    public int getHurtigRating() {
        return hurtigRating;
    }

    public void setHurtigRating(int hurtigRating) {
        this.hurtigRating = hurtigRating;
    }

    public int getLynRating() {
        return lynRating;
    }

    public void setLynRating(int lynRating) {
        this.lynRating = lynRating;
    }

    public int getFideRating() {
        return fideRating;
    }

    public void setFideRating(int fideRating) {
        this.fideRating = fideRating;
    }

    public int getkFactor() {
        return kFactor;
    }

    public void setkFactor(int kFactor) {
        this.kFactor = kFactor;
    }

    public LocalDate getUpdated_Date() {
        return updated_Date;
    }

    public void setUpdated_Date(LocalDate updated_Date) {
        this.updated_Date = updated_Date;
    }
}
