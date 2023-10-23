package com.example.sport.dao.repos;

import com.example.sport.dao.entities.SportEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SportEventRepo extends ReactiveCrudRepository<SportEvent, String> {
    Flux<SportEvent> findEventByTitle(String eventTitle);
}
