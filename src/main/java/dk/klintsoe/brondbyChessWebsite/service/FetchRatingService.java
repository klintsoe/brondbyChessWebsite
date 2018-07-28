package dk.klintsoe.brondbyChessWebsite.service;

import dk.klintsoe.brondbyChessWebsite.model.rating.Person;
import dk.klintsoe.brondbyChessWebsite.model.rating.Rating;
import dk.klintsoe.brondbyChessWebsite.model.files.RatingFile;
import dk.klintsoe.brondbyChessWebsite.repository.PersonRepository;
import dk.klintsoe.brondbyChessWebsite.repository.RatingFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchRatingService {

    @Autowired
    public FetchRatingService(RatingFileRepository ratingFileRepository, PersonRepository personRepository, FileReaderService fileReaderService) {
        this.ratingFileRepository = ratingFileRepository;
        this.personRepository = personRepository;
        this.fileReaderService = fileReaderService;
    }

    private RatingFileRepository ratingFileRepository;
    private PersonRepository personRepository;
    private FileReaderService fileReaderService;



//    private final String ratingUrl = "http://turnering.skak.dk/ClubAndMembers/ClubMemberReport/10?format=csv";

    public void updateRatingTable(URL ratingUrl) {

        try {
            RatingFile ratingFile = fileReaderService.getRatingFileByUrl(ratingUrl, LocalDate.now());

            List<RatingFile> sortedRatingFileList = ratingFileRepository.findByMaxDownloadedDate();

            if(sortedRatingFileList.isEmpty() ||
                    !sortedRatingFileList.get(0).
                            getMd5sum().equals(
                                    ratingFile.getMd5sum())) {
               ratingFileRepository.save(ratingFile);
            }
        } catch (Exception e) {
            System.out.println("Unable to locate new rating file:" + e);
            e.printStackTrace();
        }
    }


}
