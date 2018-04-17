package philosopher.paradise.service;

import philosopher.paradise.entity.Category;
import philosopher.paradise.entity.Philosopher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PhilosopherService {

   Flux<Philosopher> getAllPhilosophers();

   Mono<Philosopher> getPhilosopher(String id);

   Flux<Philosopher> findByCategories(Category category);

   Mono<Philosopher> findByName(String name);
}
