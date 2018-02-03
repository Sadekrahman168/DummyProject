package org.example.dummy.configuraion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * 
 * @author sadekrahman
 * 
 * Configuration for Swagger. 
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	/**
	 * Swagger Set basic Configuration.
	 * 
	 * @return
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        	  .apiInfo(getApiInformations())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("org.example.dummy.resources"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }	
	
	/**
	 * Set Some API information to display on Swagger Landing/Home page.
	 * 
	 * @return
	 */
	private ApiInfo getApiInformations() {
		
		//TODO: These values should retrieve from Config Server or properties file.
        Contact contact = new Contact("Sadek Rahman", "http://www.foo.org", "john@foo.org");
        return new ApiInfoBuilder()
                .title("\"Dummy App\" API Documentation")
                .description("Details about all the REST API available on \"Dummy App\"")
                .version("1.0.0")
                .license("Dummy App Liecense")
                .licenseUrl("http://dummy.org/License")
                .contact(contact)
                .build();
    }
	    
	  

}
