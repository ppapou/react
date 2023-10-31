package com.example.event.service;


import com.example.event.config.EventMapperConfig;
import com.example.event.dao.entities.GitHubEvent;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(config = EventMapperConfig.class)
@Component
public interface EventMapper {
    ServiceDaoMap toServiceEvent(GitHubEvent event);
    GitHubEvent toRepoEvent(ServiceDaoMap event);
}
