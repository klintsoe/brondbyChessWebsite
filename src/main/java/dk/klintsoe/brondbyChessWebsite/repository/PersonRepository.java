package dk.klintsoe.brondbyChessWebsite.repository;

import dk.klintsoe.brondbyChessWebsite.model.rating.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByDsuNummer(int dsuNummer);

}
