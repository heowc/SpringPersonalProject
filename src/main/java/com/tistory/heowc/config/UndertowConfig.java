package com.tistory.heowc.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowConfig {

    @Bean
    public UndertowBuilderCustomizer createUndertowCustomizerWithHttp2() {
        return builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true);
    }
}
