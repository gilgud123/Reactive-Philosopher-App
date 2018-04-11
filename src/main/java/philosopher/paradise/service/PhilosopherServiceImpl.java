package philosopher.paradise.service;

import org.springframework.stereotype.Service;
import philosopher.paradise.entity.Category;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.repository.PhilosopherRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhilosopherServiceImpl implements PhilosopherService {

    private final PhilosopherRepository repo;

    public PhilosopherServiceImpl(PhilosopherRepository repo) {
        this.repo = repo;
    }

    @Override
    public Flux<Philosopher> getAllPhilosophers() {
        return repo.findAllByOrderByNameAsc();
    }

    @Override
    public Mono<Philosopher> getPhilosopher(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<Philosopher> findByCategories(Category category) {
        return repo.findByCategories(category);
    }

    @Override
    public Mono<Philosopher> findByName(String name) {
        return repo.findByName(name);
    }

    public Mono<Philosopher> create(Philosopher philosopher){
        return repo.save(philosopher);
    }

    public Mono<Philosopher> update(Philosopher philosopher){
        return repo.save(philosopher);
    }

    public Mono<Void> delete(String id){
        return repo.findById(id).flatMap(repo::delete).then(Mono.empty());
    }
}
