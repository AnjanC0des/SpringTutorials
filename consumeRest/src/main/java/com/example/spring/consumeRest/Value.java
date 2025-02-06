package com.example.spring.consumeRest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public record Value(String id,String quote) {
}
