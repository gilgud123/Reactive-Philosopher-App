/*package philosopher.paradise.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.service.QuoteServiceImpl;
import philosopher.paradise.service.TopicServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/quote/")
public class QuoteController {

    private QuoteServiceImpl service;
    private TopicServiceImpl tService;

    public QuoteController(QuoteServiceImpl service, TopicServiceImpl tService) {
        this.service = service;
        this.tService = tService;
    }

    @GetMapping("/get")
    public Flux<Quote> getAllQuotes(){
        return service.getAllQuotes();
    }

    @GetMapping("/get/{name}")
    public Flux<Quote> getQuotesByTopicName(@PathVariable String topicText){
        return service.getQuotesByTopic(tService.getTopicByText(topicText).block());
    }

    @PostMapping("/post")
    public Mono<Quote> addQuote(@AuthenticationPrincipal UserDetails user, @RequestBody Quote quote){
        return service.addQuote(user.getUsername(), quote);
    }

    @PutMapping("/put/{id}")
    public Mono<Quote> updateQuote(@PathVariable String id, @RequestBody Quote quote){
        return service.updateQuote(id, quote);
    }

    @DeleteMapping("/delete/{text}")
    public Mono<Void> deleteQuote(@PathVariable String id){
        return service.deleteQuote(id);
    }
}*/
