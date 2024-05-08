package com.pichincha.msuxtipocambiov1.webclient.impl;

import com.pichincha.msuxtipocambiov1.constant.TrialsAuthConstant;
import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import com.pichincha.msuxtipocambiov1.webclient.GorestAuthWebClient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Slf4j
@Component
@Setter
public class GorestWebClientImpl implements GorestAuthWebClient {

    @Qualifier("gorestAuthWebClient")
    private final WebClient gorestAuthWebClient;

    @Override
    public Flux<UserResponse> trialsAuth() {

        return gorestAuthWebClient.get()
                .uri(TrialsAuthConstant.URI_POST_GOREST_AUTH)
                .headers(httpHeaders ->
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
                )
                .retrieve()
                .bodyToFlux(UserResponse.class)
                .log();
    }
}
