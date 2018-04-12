package philosopher.paradise.controller;

import org.springframework.web.bind.annotation.*;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.service.PhilosopherServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/api/")
public class PhilosopherController {

    private final PhilosopherServiceImpl service;

    public PhilosopherController(PhilosopherServiceImpl service) {
        this.service = service;
    }

    @GetMapping({"", "/", "/login"})
    public Mono<String> greetUser(Mono<Principal> principal){
        return principal.map( p -> "Hello, " + p.getName());
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
    public Mono<Philosopher> create(@RequestBody Philosopher philosopher){
        return service.create(philosopher);
    }

    @PutMapping("/put/{id}")
    public Mono<Philosopher> update(@PathVariable String id, @RequestBody String description){
        return service.update(id, description);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return service.delete(id);
    }
}
