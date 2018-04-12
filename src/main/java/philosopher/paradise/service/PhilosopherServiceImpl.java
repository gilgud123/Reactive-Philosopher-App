package philosopher.paradise.service;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER')")
    public Flux<Philosopher> getAllPhilosophers() {
        return repo.findAllByOrderByNameAsc();
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Mono<Philosopher> getPhilosopher(String id) {
        return repo.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Flux<Philosopher> findByCategories(Category category) {
        return repo.findByCategories(category);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Mono<Philosopher> findByName(String name) {
        return repo.findByName(name);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Philosopher> create(Philosopher philosopher){
        return repo.save(philosopher);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Philosopher> update(String id, String description){
        return repo.findById(id).flatMap(p -> {
            p.setDescription(description);
            return repo.save(p);
        });
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Mono<Void> delete(String id){
        return repo.findById(id).flatMap(repo::delete).then(Mono.empty());
    }
}
