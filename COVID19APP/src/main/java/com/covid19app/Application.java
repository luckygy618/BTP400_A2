/**
 * This package contains all of the files for the application
 */
package com.covid19app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The {@code Application} class represents the application itself and
 * starts the application using a {@code main()} method.
 * @author Tim Lai
 * @version 1.0
 */
@SpringBootApplication
public class Application {
	/**
	 * The main function starts the Spring application by calling the
	 * static {@code run()} method of the {@code SpringApplication}
	 * class and passing in the {@code Application.class} attribute
	 * and the args parameter as paramters.
	 * @param args The arguments as a String array
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
