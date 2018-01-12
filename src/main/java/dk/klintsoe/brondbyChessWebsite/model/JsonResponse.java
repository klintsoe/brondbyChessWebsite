package dk.klintsoe.brondbyChessWebsite.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.hateoas.ResourceSupport;


public class JsonResponse extends ResourceSupport {

    private  Object content;

    @JsonCreator
    public JsonResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }


}
