package dk.klintsoe.brondbyChessWebsite.service;

import dk.klintsoe.brondbyChessWebsite.repository.RatingFileRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FetchRatingServiceTest {

    @Autowired
    private FetchRatingService fetchRatingService;

    @Autowired
    private RatingFileRepository ratingFileRepository;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void updateRatingTable() {

        String url2 = "ratingFiles/medlemmer.csv";
        String url ="http://turnering.skak.dk/ClubAndMembers/ClubMemberReport/10?format=csv";

        assertTrue("number is not zero", ratingFileRepository.count() == 0);

        try {
            URL    urlll = new URL(url);
            fetchRatingService.updateRatingTable(urlll);



        assertTrue("number is not One", ratingFileRepository.count() == 1);

            URL    url22 =  getClass().getClassLoader().getResource(url2);
            fetchRatingService.updateRatingTable(url22);

        assertTrue("number is not two", ratingFileRepository.count() == 2);


        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}