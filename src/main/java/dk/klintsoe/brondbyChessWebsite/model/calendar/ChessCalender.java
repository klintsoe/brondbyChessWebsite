package dk.klintsoe.brondbyChessWebsite.model.calendar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Chess_Calender")
public class ChessCalender {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int seasonId;

    private String season;

    @OneToMany(mappedBy = "chessCalender", cascade = CascadeType.ALL)
    private List<ChessCalendarEntry> entryList;

    public ChessCalender() {}

    public ChessCalender(String season, List<ChessCalendarEntry> list) {
        this.season = season;
        entryList = new ArrayList();
        if(list != null) {
            list.stream().forEach(chess -> addCalendarEntry(chess));
        }
        //this.entryList = list;
    }

    public List<ChessCalendarEntry> getEntryList() {
        return entryList;
    }

    public void addCalendarEntry(ChessCalendarEntry chessCalendarEntry) {
        chessCalendarEntry.setChessCalender(this);
        this.entryList.add(chessCalendarEntry);
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setEntryList(List<ChessCalendarEntry> entryList) {
        if(entryList != null) {
            entryList.stream().forEach(chess -> addCalendarEntry(chess));
        }
    }
}
