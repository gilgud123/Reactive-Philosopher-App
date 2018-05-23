package philosopher.paradise.audit;


import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "entities")
public abstract class AuditEntity implements Persistable<String> {

    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdOn;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedOn;

    public AuditEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean isNew() {
        return this.getCreatedBy() == null;
    }
}
