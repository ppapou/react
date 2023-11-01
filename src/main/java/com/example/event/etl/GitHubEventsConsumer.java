package com.example.event.etl;

import com.example.event.dao.entities.GitHubEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class GitHubEventsConsumer {

    private static final Logger log = LoggerFactory.getLogger(GitHubEventsConsumer.class);
    private static final String gitHubUri = "https://api.github.com/events";

    private Flux<Object> downLoadGitHubEventsData() {
        log.info("Trying to download gitHub events");
        WebClient webClient = WebClient.create();
        return webClient
                .get()
                .uri(gitHubUri)
                .headers(
                        //TODO: is it better to use the hash map OR internal class for https headers
                        httpHeaders -> {
                            httpHeaders.set("Authorization", "Bearer <token>");
                            httpHeaders.set("X-GitHub-Api-Version", "2022-11-28");
                            httpHeaders.set("Accept", "application/vnd.github+json");
                        })
                .exchangeToFlux(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToFlux(GitHubEvent.class);
                    }
                    else {
                        //TODO: how it is better to handle the exception?
                        return response.createError().flux();
                    }
                });
    }

    public Flux<GitHubEvent> getEventsData() {
        //TODO: probably it is better to handle the exception here?;
        return downLoadGitHubEventsData().cast(GitHubEvent.class);
    }
}