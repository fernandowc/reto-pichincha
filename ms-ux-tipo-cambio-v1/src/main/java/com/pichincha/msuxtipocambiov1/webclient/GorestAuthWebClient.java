package com.pichincha.msuxtipocambiov1.webclient;

import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface GorestAuthWebClient {

    Flux<UserResponse> trialsAuth();
}
