package com.tistory.heowc.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowConfig {

    @Bean
    public UndertowEmbeddedServletContainerFactory createUndertowCustomizerWithHttp2() {
        UndertowEmbeddedServletContainerFactory factory =
                new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(
                builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
        return factory;
    }
}
