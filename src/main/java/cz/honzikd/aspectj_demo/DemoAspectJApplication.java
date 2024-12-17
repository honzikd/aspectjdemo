package cz.honzikd.aspectj_demo;

import cz.honzikd.aspectj_demo.aspects.TimeTrackedAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
public class DemoAspectJApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAspectJApplication.class, args);
	}

}
