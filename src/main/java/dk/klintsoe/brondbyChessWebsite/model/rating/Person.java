package dk.klintsoe.brondbyChessWebsite.model.rating;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int personId;

    private String firstName;
    private String lastName;
    private int dsuNummer;
    private String klub;
    private String titel;
    private int foedeAar;

    @OneToMany(mappedBy = "ratingId", cascade = CascadeType.ALL)
    private List<Rating> ratingList;

    public Person(String firstName, String lastName, String klub, int dsuNummer, String titel, int foedeAar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.klub = klub;
        this.titel = titel;
        this.foedeAar = foedeAar;
        this.dsuNummer = dsuNummer;
        this.ratingList = new ArrayList<>();
    }

    public void addRating(Rating rating) {
        rating.setPerson(this);
        ratingList.add(rating);
    }


}



