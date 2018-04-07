package dk.klintsoe.brondbyChessWebsite.repository;

import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalender;
import dk.klintsoe.brondbyChessWebsite.model.rating.Person;
import dk.klintsoe.brondbyChessWebsite.model.rating.RatingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RatingFileRepository extends JpaRepository<RatingFile, Integer> {

    RatingFile findOneByDownloadedDate(Date downloadedDate);

    @Query("SELECT rf FROM RatingFile rf order by rf.downloadedDate")
    List<RatingFile> findByMaxDownloadedDate();

}
