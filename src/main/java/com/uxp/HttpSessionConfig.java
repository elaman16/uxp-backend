package com.uxp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
@Configuration
@EnableRedisHttpSession 
public class HttpSessionConfig {

        @Bean
        public JedisConnectionFactory connectionFactory() {
                return new JedisConnectionFactory(); 
        }
        
        static class SessionInit extends AbstractHttpSessionApplicationInitializer { 

            public SessionInit() {
                    super(HttpSessionConfig.class); 
            }
    }
}
