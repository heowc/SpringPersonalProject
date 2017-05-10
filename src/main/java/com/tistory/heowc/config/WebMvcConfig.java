package com.tistory.heowc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/static/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/resources/**")) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
                    .setCachePeriod(3600)
                    .resourceChain(true)
                    .addResolver(new GzipResourceResolver())
                    .addResolver(new PathResourceResolver());
        }
    }
}
