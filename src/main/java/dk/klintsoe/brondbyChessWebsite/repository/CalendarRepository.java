package dk.klintsoe.brondbyChessWebsite.repository;

import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CalendarRepository extends JpaRepository<ChessCalender, Integer> {

    List<ChessCalender> findBySeason(String season);

}
