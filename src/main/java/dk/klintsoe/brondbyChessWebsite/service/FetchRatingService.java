package dk.klintsoe.brondbyChessWebsite.service;

import dk.klintsoe.brondbyChessWebsite.model.rating.Person;
import dk.klintsoe.brondbyChessWebsite.model.rating.Rating;
import dk.klintsoe.brondbyChessWebsite.model.rating.RatingFile;
import dk.klintsoe.brondbyChessWebsite.repository.CalendarRepository;
import dk.klintsoe.brondbyChessWebsite.repository.PersonRepository;
import dk.klintsoe.brondbyChessWebsite.repository.RatingFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchRatingService {

    @Autowired
    public FetchRatingService(RatingFileRepository ratingFileRepository, PersonRepository personRepository) {
        this.ratingFileRepository = ratingFileRepository;
        this.personRepository = personRepository;
    }

    private RatingFileRepository ratingFileRepository;
    private PersonRepository personRepository;


//    private final String ratingUrl = "http://turnering.skak.dk/ClubAndMembers/ClubMemberReport/10?format=csv";

    public void updateRatingTable(String ratingUrl) {

        try {
            File downloadfile = getRatingFileByUrl(ratingUrl);
            RatingFile ratingFile = new RatingFile(downloadfile, LocalDate.now());
            ratingFileRepository.save(ratingFile);

            List<Person> personList = conventRatingFile(ratingFile);
            personRepository.save(personList);

        } catch (Exception e) {

        }
    }

    private File getRatingFileByUrl(String ratingUrl) throws Exception {
        UrlResource urlResource = new UrlResource(ratingUrl);
        File ratingFile = urlResource.getFile();
        return ratingFile;
    }

    private List<Person> conventRatingFile(RatingFile ratingFile) throws Exception {
        ArrayList<Person> arrayList = new ArrayList<>();

        File file = ratingFile.getRatingFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        bufferedReader.lines().
                filter(x -> !"\"\"".equals(x)).
                filter(x -> !"\"Nummer\"".equals(x.substring(0,8))).
                forEach(s -> arrayList.add(string2Person(s)));


        return arrayList;
    }

    //"Nummer";"Født år";"Navn";"Klub";"Titel";"Rating";"Hurtig";"Lyn";"Elo";"Fide";"K-factor"
    //"100100674";"1971";"Søren Klintsø";"Brøndby Skakklub";"";"1643";"1570";"1570";"1776";"1414933";"40"
    private Person string2Person(String dataString) {

        String[] stringArray = dataString.split(";");

        String dsuNumberString = stringArray[0];
        Person person = personRepository.findByDsuId(Integer.getInteger(removePling(dsuNumberString)));

        if (person == null) {
           person = createPerson(stringArray);
        }

        LocalDate currentDate = LocalDate.now();

        person.addRating(createRating(stringArray, currentDate));
        return person;
    }

    //"Nummer";"Født år";"Navn";"Klub";"Titel";"Rating";"Hurtig";"Lyn";"Elo";"Fide";"K-factor"
    private Person createPerson(String[] stringArray) {
        String fullName = removePling(stringArray[2]);
        String firstName = fullName.substring(0, fullName.lastIndexOf(' ')).trim();
        String lastName = fullName.substring(fullName.lastIndexOf(' '), fullName.length()).trim();;

        String klub = removePling(stringArray[3]);
        String titel = removePling(stringArray[4]);
        int foedeAar = Integer.getInteger(removePling(stringArray[1]));
        int dsuNummer = Integer.getInteger(removePling(stringArray[0]));

        return new Person(firstName,lastName, klub, dsuNummer, titel, foedeAar);
    }


    //"Nummer";"Født år";"Navn";"Klub";"Titel";"Rating";"Hurtig";"Lyn";"Elo";"Fide";"K-factor"
    private Rating createRating(String[] stringArray, LocalDate createDate) {
        int rating = Integer.getInteger(removePling(stringArray[5]));
        int hurtigRating = Integer.getInteger(removePling(stringArray[6]));
        int lynRating = Integer.getInteger(removePling(stringArray[7]));
        int eloRating = Integer.getInteger(removePling(stringArray[8]));
        int fideRating = Integer.getInteger(removePling(stringArray[9]));
        int kFactor = Integer.getInteger(removePling(stringArray[10]));

        return new Rating(rating, hurtigRating, lynRating, eloRating, fideRating, kFactor, createDate);
    }

    private String removePling(String plingString) {
        return plingString.substring(1, plingString.length()-1);
    }
}
