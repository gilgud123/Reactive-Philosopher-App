package philosopher.paradise.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.repository.TopicRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repo;

    public TopicServiceImpl(TopicRepository repo) {
        this.repo = repo;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Flux<Topic> getAllTopics() {
        return repo.findAll();
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Mono<Topic> getTopicByText(String text) {
        return repo.findByText(text);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Topic> addTopic(Topic topic){
        return repo.save(topic);
    }

    @PreAuthorize("hasRole('USER')")
    public Mono<Topic> updateTopicText(String id, String text){
        return repo.findById(id).flatMap(t -> {
            t.setText(text);
            return repo.save(t);
        });
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Mono<Void> deleteTopic(String id){
        return repo.findById(id).flatMap(repo::delete).then(Mono.empty());
    }
}
