package com.pichincha.msuxtipocambiov1.webclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class ApiSpTipoCambioiConfig {

  @Value("${api.support.base.sp-tipo-cambio.url}")
  private String apiSupportBaseTipoCambioUrl;

  /**
   * This method is used to post personaWebClient.
   * @return WebClient.
   */

  @Bean("apiSupportWebClient")
  public WebClient tipoCambioWebClient(WebClient.Builder webClientBuilder) {
      return webClientBuilder
          .baseUrl(apiSupportBaseTipoCambioUrl)
          .build();
  }
}
