package philosopher.paradise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "quotes")
@AllArgsConstructor
public class Quote implements Serializable {

    @Id
    private String id;
    private String text;
    private List<Topic> topics;
    private String createdBy;
    private String createdOn;

    private String philosopherId;

    public Quote(){
        this.id = UUID.randomUUID().toString();
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
