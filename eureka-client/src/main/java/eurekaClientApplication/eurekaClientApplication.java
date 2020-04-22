package eurekaClientApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class eurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(eurekaClientApplication.class,args);
    }

}
