package philosopher.paradise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import philosopher.paradise.entity.Topic;

public interface TopicRepository extends ReactiveMongoRepository<Topic, String> {
}
