package philosopher.paradise.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import philosopher.paradise.audit.AuditEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "quotes")
public class Quote extends AuditEntity implements Serializable {

    private String text;
    private List<Topic> topics;

    private String philosopherId;

    public Quote(){
        super();
    }

    public Quote(String text) {
        this();
        this.text = text;
    }

    public Quote(String text, List<Topic> topics, String philosopherId) {
        this(text);
        this.topics = topics;
        this.philosopherId = philosopherId;
    }
}
