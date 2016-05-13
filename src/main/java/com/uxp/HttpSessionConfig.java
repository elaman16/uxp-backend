package com.uxp;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
@Configuration
@EnableRedisHttpSession 
public class HttpSessionConfig {


    @Bean
    public JedisConnectionFactory connectionFactory() throws URISyntaxException {
        JedisConnectionFactory redis = new JedisConnectionFactory();
        String redisUrl = System.getenv("REDIS_URL");

        URI redisUri = new URI(redisUrl);
        redis.setHostName(redisUri.getHost());
        redis.setPort(redisUri.getPort());
        redis.setPassword(redisUri.getUserInfo().split(":",2)[1]);
        return redis;
    }
        
        static class SessionInit extends AbstractHttpSessionApplicationInitializer { 

            public SessionInit() {
                    super(HttpSessionConfig.class); 
            }
    }
}
