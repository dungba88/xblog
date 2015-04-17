package org.xblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class Application {

	/**
	 * Run the Web Application using built-in Tomcat server.
	 * This is used for testing only
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }
}
