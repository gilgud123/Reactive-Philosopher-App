/*
package philosopher.paradise.controller;

import org.springframework.web.bind.annotation.*;
import philosopher.paradise.entity.Quote;
import philosopher.paradise.entity.Topic;
import philosopher.paradise.service.TopicServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/topic/")
public class TopicController {

    private TopicServiceImpl service;

    public TopicController(TopicServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/get")
    public Flux<Topic> getAllTopics(){
        return service.getAllTopics();
    }

    @GetMapping("/get/{text}")
    public Mono<Topic> getAllTopics(@PathVariable String text){
        return service.getTopicByText(text);
    }

    @PostMapping("/post/{text}")
    public Mono<Topic> addTopic(@RequestBody Topic topic){
        return service.addTopic(topic);
    }

    @PutMapping("/put/{text}")
    public Mono<Topic> updateTopic(@PathVariable String id, @RequestBody String text){
        return service.updateTopicText(id, text);
    }

    @DeleteMapping("/delete/{text}")
    public Mono<Void> deleteTopic(@PathVariable String id){
        return service.deleteTopic(id);
    }
}
*/
