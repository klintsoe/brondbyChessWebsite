package dk.klintsoe.brondbyChessWebsite.model.calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Chess_Calendar_Entry")
public class ChessCalendarEntry {

    public enum ColorType {blue, green, noColor};

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private LocalDate actionDate;
    private String actionText;
    private ColorType colorType;
    private int dateOrder;

    @ManyToOne
    @JsonIgnore //to avoid circle reference
    @JoinColumn(name = "seasonId")
    private ChessCalender chessCalender;

    public ChessCalendarEntry() {}

    public ChessCalendarEntry(LocalDate actionDate, String actionText, ColorType colorType, int dateOrder) {
        this.actionDate = actionDate;
        this.actionText = actionText;
        this.colorType = colorType;
        this.dateOrder = dateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDate actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public int getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(int dateOrder) {
        this.dateOrder = dateOrder;
    }

    public ChessCalender getChessCalender() {
        return chessCalender;
    }

    public void setChessCalender(ChessCalender chessCalender) {
        this.chessCalender = chessCalender;
    }
}
