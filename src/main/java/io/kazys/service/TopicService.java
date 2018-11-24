package io.kazys.service;

import io.kazys.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("java", "Java basics", "An introductory course on JAVA"),
            new Topic("javascript", "Javascript fundamentals", "Intro to JavaScript"),
            new Topic("spring", "Spring Framework", "Spring Framework introduction")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic newTopic) {
        topics.add(newTopic);
    }

    public void updateTopic(String id, Topic updatedTopic) {

        for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.set(i, updatedTopic);
                break;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(e -> e.getId().equals(id));
    }
}
