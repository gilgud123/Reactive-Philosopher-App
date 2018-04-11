package philosopher.paradise.service;

import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import reactor.core.publisher.Flux;

public interface QuoteService {

    Flux<Quote> getAllQuotes();

    Flux<Quote> getQuoteByTopic(Topic topic);

    Flux<Quote> getQuoteByPhilosopherId(String id);
}
