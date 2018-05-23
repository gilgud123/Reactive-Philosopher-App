package philosopher.paradise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import philosopher.paradise.audit.AuditEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "topics")
public class Topic extends AuditEntity implements Serializable {

    private String text;

    @DBRef
    private List<Quote> quotes;

    public Topic(){
        super();
    }

    public Topic(String text){
        super();
        this.text = text;
    }

    public Topic(String text, List<Quote> quotes) {
        this.text = text;
        this.quotes = quotes;
    }
}
