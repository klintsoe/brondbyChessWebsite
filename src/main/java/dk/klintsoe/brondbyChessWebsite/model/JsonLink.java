package dk.klintsoe.brondbyChessWebsite.model;

import javax.persistence.Entity;
import java.util.ArrayList;

//@Entity
public class JsonLink {

    private ArrayList<String> linkList;

    public JsonLink(ArrayList<String> linkList) {
        this.linkList = linkList;
    }
}
