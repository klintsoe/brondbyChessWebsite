package dk.klintsoe.brondbyChessWebsite.DatabaseData;

import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalendarEntry;
import dk.klintsoe.brondbyChessWebsite.model.calendar.ChessCalender;
import dk.klintsoe.brondbyChessWebsite.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarData implements CommandLineRunner {


    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarData(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    @Transactional
    public void run(String... strings)  {

        System.out.println("Running Commands");

        List<ChessCalendarEntry> list = new ArrayList<>();
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 8, 14), "Hyggeturnering", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 8, 21), "Hyggeturnering", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 8, 28), "Hyggeturnering", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 4), "Hyggeturnering", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 11), "Generalforsamling", ChessCalendarEntry.ColorType.red, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 18), "Vinterturnering 1", ChessCalendarEntry.ColorType.red, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 25), "Vinterturnering 2", ChessCalendarEntry.ColorType.red, 0));
        ChessCalender chessCalender1718 = new ChessCalender("2017-2018", list);


        ChessCalender chessCalender1617 = new ChessCalender("2016-2017", new ArrayList<>());
        List<ChessCalendarEntry> newlist = new ArrayList<>();
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 11, 23), "Begyndelse", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 10, 16), "Ydelse", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 3), "Bandit", ChessCalendarEntry.ColorType.blue, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 12, 1), "Heste", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 11, 23), "Grisen", ChessCalendarEntry.ColorType.noColor, 0));
        chessCalender1617.setEntryList(newlist);


        calendarRepository.save(chessCalender1718);
        calendarRepository.save(chessCalender1617);


    }

}
