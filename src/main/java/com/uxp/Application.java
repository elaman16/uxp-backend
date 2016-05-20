package com.uxp;


import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Spring Boot main Application
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com"})
@EnableContextCredentials(accessKey="AKIAJAEOKYIRMVE3VK5Q", secretKey="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")
public class Application {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:///home/kelly/golive/uxpass/public/");
    }
	/*public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			//.allowedOrigins("http://xyz.com")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("header1", "header2", "header3","header4", "header5", "header6", "header7", "header8", "header9","header10", "header11", "header12")
			.exposedHeaders("header1", "header2", "header3","header4", "header5", "header6", "header7", "header8", "header9","header10", "header11", "header12")
			.allowCredentials(false)
			.maxAge(3600);
			
	}*/
	@Bean
	public TomcatEmbeddedServletContainerFactory containerFactory() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	     factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	        @Override
	        public void customize(Connector connector) {
	         ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(2000000);
	        }
	     });
	     return factory;
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

/*
@Configuration
@ComponentScan(basePackages = { "com.uxp" })
@EnableJpaRepositories
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry
    			.addMapping("/**")
    			//.allowedOrigins("http://xyz.com")
    			.allowedMethods("GET", "POST", "PUT", "DELETE")
    			.allowedHeaders("header1", "header2", "header3","header4", "header5", "header6", "header7", "header8", "header9","header10", "header11", "header12")
    			.exposedHeaders("header1", "header2", "header3","header4", "header5", "header6", "header7", "header8", "header9","header10", "header11", "header12")
    			.allowCredentials(false)
    			.maxAge(3600);
            }
        };
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
	
}
*/