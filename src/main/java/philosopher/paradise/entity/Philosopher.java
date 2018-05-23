package philosopher.paradise.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import philosopher.paradise.audit.AuditEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "philosophers")
public class Philosopher extends AuditEntity implements Serializable{

    private String name;
    private List<Category> categories;
    private String description;
    private List<Quote> quotes;
    private String modifiedBy;
    private String modifiedOn;

    private Philosopher() {
        super();
    }

    public Philosopher(String name, List<Category> categories, String description, List<Quote> quotes) {
        this();
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.quotes = quotes;
    }
}
