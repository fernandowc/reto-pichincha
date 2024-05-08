package com.pichincha.msuxtipocambiov1.webclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class WebPersonaApiConfig {

  @Value("${api.support.base.gorest.url}")
  private String apiSupportBasePersonUrl;

  /**
   * This method is used to post personaWebClient.
   * @return WebClient.
   */

  @Bean("gorestAuthWebClient")
  public WebClient personaWebClient(WebClient.Builder webClientBuilder) {
    return webClientBuilder
        .baseUrl(apiSupportBasePersonUrl)
        .build();
  }
}
