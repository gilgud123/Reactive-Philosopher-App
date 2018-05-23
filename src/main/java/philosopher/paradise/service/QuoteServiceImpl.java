package philosopher.paradise.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.repository.QuoteRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository repo;

    public QuoteServiceImpl(QuoteRepository repo) {
        this.repo = repo;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Flux<Quote> getAllQuotes() {
        return repo.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Quote> getQuoteById(String id) {
        return repo.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Flux<Quote> getQuotesByTopic(Topic topic) {
        return getAllQuotes().filter(q -> q.getTopics().contains(topic));
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Flux<Quote> getQuoteByPhilosopherId(String id) {
        return repo.findByPhilosopherId(id);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Quote> addQuote(Quote quote){
        return repo.save(quote);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Quote> updateQuote(String id, Quote quote){
        return repo.findById(id).flatMap(q ->{
            quote.getTopics().iterator().forEachRemaining(q.getTopics()::add);
            q.setPhilosopherId(quote.getPhilosopherId());
            q.setText(quote.getText());
            return repo.save(q);
        });
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Mono<Void> deleteQuote(String id){
        return repo.findById(id).flatMap(repo::delete).then(Mono.empty());
    }
}
