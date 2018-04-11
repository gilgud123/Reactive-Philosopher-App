package philosopher.paradise.service;

import philosopher.paradise.entity.Topic;
import reactor.core.publisher.Flux;

public interface TopicService {

    Flux<Topic> getAllTopics();
}
