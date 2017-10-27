package fr.sle.testhowto.test.config;

import fr.sle.testhowto.MyComponent;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author slemoine
 */
@TestConfiguration
public class AdditionalTestConfig {

    @Bean
    public AdditionnalTestComponent additionnalTestComponent() {
        return new AdditionnalTestComponent();
    }

    /**
     * A Mock if {@link MyComponent} class
     * @return the mock
     */
    @Bean
    public MyComponent component() {
        return Mockito.mock(MyComponent.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
