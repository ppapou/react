package com.example.event.etl;

import com.example.event.dao.repos.GitHubEventRepo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DataLoader{

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private final GitHubEventRepo repository;
    public final GitHubEventsConsumer consumer;

    public DataLoader(GitHubEventRepo repository, GitHubEventsConsumer consumer, GitHubEventsConsumer consumer1) {
        this.repository = repository;
        this.consumer = consumer;
    }
    @PostConstruct
    public void saveGitHubEvents() {
        repository.saveAll(consumer.getEventsData());
        log.info("The events are uploaded");
    }
}
