package org.kjw.springcorebasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClientTest client = context.getBean(NetworkClientTest.class);
        context.close();

    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClientTest networkClientTest() {
            NetworkClientTest networkClientTest = new NetworkClientTest();
            networkClientTest.setUrl("http://hello-spring.dev");
            return networkClientTest;

        }

    }

}
