package philosopher.paradise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import philosopher.paradise.entity.Category;
import philosopher.paradise.entity.Philosopher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PhilosopherRepository extends ReactiveMongoRepository<Philosopher, String>{
    Flux<Philosopher> findAllByOrderByNameAsc();

    Flux<Philosopher> findByCategories(Category category);

    Mono<Philosopher> findByName(String name);
}
