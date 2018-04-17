package philosopher.paradise.service;

import philosopher.paradise.entity.Topic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TopicService {

    Flux<Topic> getAllTopics();

    Mono<Topic> getTopicByText(String text);
}
