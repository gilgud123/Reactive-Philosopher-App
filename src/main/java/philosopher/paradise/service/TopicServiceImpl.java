package philosopher.paradise.service;

import org.springframework.stereotype.Service;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.repository.TopicRepository;
import reactor.core.publisher.Flux;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repo;

    public TopicServiceImpl(TopicRepository repo) {
        this.repo = repo;
    }

    @Override
    public Flux<Topic> getAllTopics() {
        return repo.findAll();
    }
}
