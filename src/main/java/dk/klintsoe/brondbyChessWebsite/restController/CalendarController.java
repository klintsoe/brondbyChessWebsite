package dk.klintsoe.brondbyChessWebsite.restController;

import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalender;
import dk.klintsoe.brondbyChessWebsite.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    CalendarRepository calendarRepository;

    @RequestMapping(value={"/{seasonIdent}"}, method= RequestMethod.GET)
    public List<ChessCalender> getFullCalendar(@PathVariable(value="seasonIdent") final String seasonIdent) {
        List<ChessCalender> chessCalenderList = calendarRepository.findBySeason(seasonIdent);
        return chessCalenderList;
    }


}
