package dk.klintsoe.brondbyChessWebsite.restController;

import dk.klintsoe.brondbyChessWebsite.config.log.LogFactory;
import dk.klintsoe.brondbyChessWebsite.config.log.TimerLog;
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

    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @RequestMapping(value={"/{seasonIdent}"}, method= RequestMethod.GET)
    public ChessCalender getFullCalendar(@PathVariable(value="seasonIdent") final String seasonIdent) {
        TimerLog timerLog = LogFactory.getTimerLog();

        timerLog.start("CC:" + seasonIdent);

        timerLog.mark("del1");

        ChessCalender chessCalenderList = calendarRepository.findOneBySeason(seasonIdent);

        timerLog.stopTimer("slut");
        return chessCalenderList;
    }


}
