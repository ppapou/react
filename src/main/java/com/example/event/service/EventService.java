package com.example.event.service;

import com.example.event.dao.entities.GitHubEvent;
import com.example.event.dao.repos.GitHubEventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EventService {
    private final GitHubEventRepo eventRepo;
    private final EventMapper mapper;

    public void addEvent(ServiceDaoMap gitHubEvent) {
        eventRepo.save(mapper.toRepoEvent(gitHubEvent));
    }
}
