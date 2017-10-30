package fr.sle.testhowto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author slemoine
 */
@Configuration
public class MyConfig {

    @Bean
    public WebServiceTemplate getWebServiceTemplate() {
        return new WebServiceTemplate();
    }
}
