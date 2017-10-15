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

    @Autowired
    private CalendarRepository calendarRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        System.out.println("Running Commands");

        List<ChessCalendarEntry> list = new ArrayList();
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 3, 11), "Opstart", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2017, 5, 2), "Opstart", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2018, 12, 3), "Opstart", ChessCalendarEntry.ColorType.noColor, 0));
        list.add(new ChessCalendarEntry(LocalDate.of(2018, 11, 14), "Opstart", ChessCalendarEntry.ColorType.noColor, 0));

        ChessCalender chessCalender1718 = new ChessCalender("2017-2018", list);


        ChessCalender chessCalender1617 = new ChessCalender("2016-2017", new ArrayList<ChessCalendarEntry>());
        List<ChessCalendarEntry> newlist = new ArrayList();
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 11, 23), "Begyndelse", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 10, 16), "Ydelse", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 9, 03), "Bandit", ChessCalendarEntry.ColorType.blue, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 12, 01), "Heste", ChessCalendarEntry.ColorType.noColor, 0));
        newlist.add(new ChessCalendarEntry(LocalDate.of(2017, 11, 23), "Grisen", ChessCalendarEntry.ColorType.noColor, 0));
        chessCalender1617.setEntryList(newlist);


        calendarRepository.save(chessCalender1718);
        calendarRepository.save(chessCalender1617);


    }
}
