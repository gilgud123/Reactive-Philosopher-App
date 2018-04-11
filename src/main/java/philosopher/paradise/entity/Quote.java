package philosopher.paradise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "quotes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote implements Serializable {

    @Id
    private String id;
    private String text;
    private List<Topic> topics;

    private String philosopherId;

    public Quote(String text) {
        this.text = text;
    }
}
