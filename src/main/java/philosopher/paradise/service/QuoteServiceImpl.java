package philosopher.paradise.service;

import org.springframework.stereotype.Service;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.repository.QuoteRepository;
import reactor.core.publisher.Flux;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository repo;

    public QuoteServiceImpl(QuoteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Flux<Quote> getAllQuotes() {
        return repo.findAll();
    }

    @Override
    public Flux<Quote> getQuoteByTopic(Topic topic) {
        return repo.findByTopics(topic);
    }

    @Override
    public Flux<Quote> getQuoteByPhilosopherId(String id) {
        return repo.findByPhilosopherId(id);
    }
}
