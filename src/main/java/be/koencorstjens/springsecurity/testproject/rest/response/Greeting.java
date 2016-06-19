package be.koencorstjens.springsecurity.testproject.rest.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {

    private final String content;

    //@JsonCreator - signal on how Jackson can create an instance of this POJO
    //@JsonProperty - clearly marks what field Jackson should put this constructor argument into

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

