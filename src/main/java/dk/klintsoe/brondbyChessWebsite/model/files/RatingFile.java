package dk.klintsoe.brondbyChessWebsite.model.files;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "RatingFile")
public class RatingFile {

    enum FileStatus {added, updated};

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Lob
    private byte[] ratingFile;

    private String filename;

    private String md5sum;

    private LocalDate downloadedDate;

    private FileStatus fileStatus;

    public RatingFile() {
      }


    public RatingFile(byte[] ratingFile, String filename, String md5Sum, LocalDate downloadedDate) {
        this.ratingFile = ratingFile;
        this.downloadedDate = downloadedDate;
        this.md5sum = md5Sum;
        this.filename = filename;
        this.fileStatus = FileStatus.added;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getRatingFile() {
        return ratingFile;
    }

    public void setRatingFile(byte[] ratingFile) {
        this.ratingFile = ratingFile;
    }

    public LocalDate getDownloadedDate() {
        return downloadedDate;
    }

    public void setDownloadedDate(LocalDate downloadedDate) {
        this.downloadedDate = downloadedDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }
}
