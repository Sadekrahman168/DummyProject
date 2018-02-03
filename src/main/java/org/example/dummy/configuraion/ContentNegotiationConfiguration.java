package org.example.dummy.configuraion;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration dedicated for Content Negotiation, So that REST APIs can handle both josn and xml.
 * 
 * @author sadekrahman
 *
 */
@Configuration
@EnableWebMvc
public class ContentNegotiationConfiguration extends WebMvcConfigurerAdapter {
	
	/**
	 * 
	 * Configure content negotiation.
	 * 	
	 */
	 @Override
	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		  configurer.favorPathExtension(true).
         favorParameter(true).
         parameterName("mediaType").
         ignoreAcceptHeader(false).
         useJaf(false).
         defaultContentType(MediaType.APPLICATION_JSON).
         mediaType("xml", MediaType.APPLICATION_XML).
         mediaType("json", MediaType.APPLICATION_JSON);
    
	  }
	 
	 /***
	  * 
	  * Configuration to handle Swagger  requests.
	  */
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");

	        registry.addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
	
	

}
