package com.deeplify.tutorial.oauthlogin;

import com.deeplify.tutorial.oauthlogin.config.properties.AppProperties;
import com.deeplify.tutorial.oauthlogin.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties({
        CorsProperties.class,
        AppProperties.class
})
public class OauthLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthLoginApplication.class, args);
    }

}
