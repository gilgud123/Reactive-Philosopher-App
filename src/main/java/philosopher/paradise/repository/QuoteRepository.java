package philosopher.paradise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

    Flux<Quote> findByTopics(Topic topic);

    Flux<Quote> findByPhilosopherId(String id);
}
