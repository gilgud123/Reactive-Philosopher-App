package philosopher.paradise.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import philosopher.paradise.entity.Philosopher;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.service.PhilosopherServiceImpl;
import philosopher.paradise.service.QuoteServiceImpl;
import philosopher.paradise.service.TopicServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/api/")
public class PhilosopherController {

    private final PhilosopherServiceImpl service;
    private QuoteServiceImpl qService;
    private TopicServiceImpl tService;

    public PhilosopherController(PhilosopherServiceImpl service, QuoteServiceImpl qService, TopicServiceImpl tService) {
        this.service = service;
        this.qService = qService;
        this.tService = tService;
    }

    @GetMapping({"", "/", "/login"})
    public Mono<String> greetUser(Mono<Principal> principal){
        return principal.map( p -> "Hello, " + p.getName());
    }

    @GetMapping("/get")
    public Flux<Philosopher> getPhilosophers(){
        return service.getAllPhilosophers();
    }

    @GetMapping("/get/{name}")
    public Mono<Philosopher> getPhilosopherByName(@PathVariable String name){
        return service.findByName(name);
    }

    @GetMapping("/quote/get")
    public Flux<Quote> getAllQuotes(){
        return qService.getAllQuotes();
    }

    @GetMapping("/quote/get/{name}")
    public Flux<Quote> getQuotesByTopicName(@PathVariable String topicText){
        return qService.getQuotesByTopic(tService.getTopicByText(topicText).block());
    }

    @GetMapping("/topic/get")
    public Flux<Topic> getAllTopics(){
        return tService.getAllTopics();
    }

    @GetMapping("/topic/get/{text}")
    public Mono<Topic> getAllTopics(@PathVariable String text){
        return tService.getTopicByText(text);
    }

    @PostMapping("/post")
    public Mono<Philosopher> create(@RequestBody Philosopher philosopher){
        return service.create(philosopher);
    }

    @PostMapping("/topic/post")
    public Mono<Topic> addTopic(@RequestBody Topic topic){
        return tService.addTopic(topic);
    }

    @PostMapping("/quote/post")
    public Mono<Quote> addQuote(@AuthenticationPrincipal UserDetails user, @RequestBody Quote quote){
        return qService.addQuote(user.getUsername(), quote);
    }

    @PutMapping("/put/{id}")
    public Mono<Philosopher> update(@PathVariable String id, @AuthenticationPrincipal UserDetails user, @RequestBody String description){
        return service.updateDescription(id, user.getUsername(), description);
    }

    @PutMapping("/quote/put/{id}")
    public Mono<Quote> updateQuote(@PathVariable String id, @RequestBody Quote quote){
        return qService.updateQuote(id, quote);
    }

    @PutMapping("/topic/put/{text}")
    public Mono<Topic> updateTopic(@PathVariable String id, @RequestBody String text){
        return tService.updateTopicText(id, text);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return service.delete(id);
    }

    @DeleteMapping("/topic/delete/{id}")
    public Mono<Void> deleteTopic(@PathVariable String id){
        return tService.deleteTopic(id);
    }

    @DeleteMapping("/quote/delete/{id}")
    public Mono<Void> deleteQuote(@PathVariable String id){
        return qService.deleteQuote(id);
    }
}
