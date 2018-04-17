package philosopher.paradise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "topics")
@AllArgsConstructor
public class Topic implements Serializable {

    @Id
    private String id;
    private String text;

    @DBRef
    private List<Quote> quotes;

    public Topic(){
        this.id = UUID.randomUUID().toString();
    }

    public Topic(String text){
        this();
        this.text = text;
    }

    public Topic(String text, List<Quote> quotes) {
        this.text = text;
        this.quotes = quotes;
    }
}
