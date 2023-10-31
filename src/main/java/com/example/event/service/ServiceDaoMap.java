package com.example.event.service;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;


@Value
@Builder
@EqualsAndHashCode
public class ServiceDaoMap {
    @EqualsAndHashCode.Include
    long eventId;
    String title;
}
