package dk.klintsoe.brondbyChessWebsite.model.rating;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "RatingFile")
public class RatingFile {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private File ratingFile;
    private LocalDate downloadedDate;

    public RatingFile(File ratingFile, LocalDate downloadedDate) {
        this.ratingFile = ratingFile;
        this.downloadedDate = downloadedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getRatingFile() {
        return ratingFile;
    }

    public void setRatingFile(File ratingFile) {
        this.ratingFile = ratingFile;
    }

    public LocalDate getDownloadedDate() {
        return downloadedDate;
    }

    public void setDownloadedDate(LocalDate downloadedDate) {
        this.downloadedDate = downloadedDate;
    }
}
