package philosopher.paradise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import philosopher.paradise.entity.Topic;
import reactor.core.publisher.Mono;

public interface TopicRepository extends ReactiveMongoRepository<Topic, String> {

    Mono<Topic> findByText(String text);
}
