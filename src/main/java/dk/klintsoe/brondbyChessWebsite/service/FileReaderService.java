package dk.klintsoe.brondbyChessWebsite.service;

import dk.klintsoe.brondbyChessWebsite.model.rating.RatingFile;
import org.apache.logging.log4j.core.util.IOUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;

@Service
public class FileReaderService {

    public RatingFile getRatingFileByUrl(URL ratingUrl, LocalDate date) throws Exception {
        UrlResource urlResource =  new UrlResource(ratingUrl);
        String filename = urlResource.getFilename();

        byte[] arrayFile = new byte[(int) urlResource.contentLength()];
        urlResource.getInputStream().read(arrayFile);
        String md5sum = DigestUtils.md5DigestAsHex(arrayFile);

        return new RatingFile(arrayFile, filename, md5sum, date);
    }
}
