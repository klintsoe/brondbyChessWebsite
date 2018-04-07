package dk.klintsoe.brondbyChessWebsite.repository;

import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalender;
import dk.klintsoe.brondbyChessWebsite.model.rating.Person;
import dk.klintsoe.brondbyChessWebsite.model.rating.RatingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByDsuNummer(int dsuNummer);

}
