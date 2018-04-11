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
import java.util.UUID;

@Data
@Document(collection = "philosophers")
public class Philosopher implements Serializable{

    @Id
    private String id;
    private String name;
    private List<Category> categories;
    private String description;
    private List<Quote> quotes;

    private Philosopher() {
        this.id = UUID.randomUUID().toString();
    }

    public Philosopher(String name, List<Category> categories, String description, List<Quote> quotes) {
        this();
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.quotes = quotes;
    }
}
