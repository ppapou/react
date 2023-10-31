package com.example.event.dao.repos;

import com.example.event.dao.entities.GitHubEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface GitHubEventRepo extends ReactiveCrudRepository<GitHubEvent, Long> {
    Mono<GitHubEvent> findEventByTitle(String eventTitle);
}
