package philosopher.paradise.controller;

import org.springframework.web.bind.annotation.*;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.service.PhilosopherServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/")
public class PhilosopherController {

    private final PhilosopherServiceImpl service;

    public PhilosopherController(PhilosopherServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/get")
    public Flux<Philosopher> getPhilosophers(){
        return service.getAllPhilosophers();
    }

    @GetMapping("/get/{id}")
    public Mono<Philosopher> getPhilosopher(@PathVariable String id){
        return  service.getPhilosopher(id);
    }

    @PostMapping("/post")
    public Mono<Philosopher> create(@PathVariable Philosopher philosopher){
        return service.create(philosopher);
    }

    @PostMapping("/put")
    public Mono<Philosopher> update(@PathVariable Philosopher philosopher){
        return service.update(philosopher);
    }

    @PostMapping("/delete")
    public Mono<Void> delete(@PathVariable String id){
        return service.delete(id);
    }
}
