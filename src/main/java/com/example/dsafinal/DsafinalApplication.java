/*
  Final Sprint - Binary Search Tree Visualizer
  -----------------------------------------------------
  A Spring Boot application that allows users to:
   - Input series of numbers to generate a BST (i.e: 20 30 45)
   - Visualize resulting BST structure
   - Lastly, view previously submitted trees

  Program created using Maven, Spring Boot, and Thymeleaf
  -----------------------------------------------------
  By: Cameron Beanland
  Date: April 13th, 2025
*/

package com.example.dsafinal;

// imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsafinalApplication {

	/**
	 * Main method/entry point for the program, and
	 * must be started with the "mvn spring-boot:run" command!
	 */
	public static void main(String[] args) {
		SpringApplication.run(DsafinalApplication.class, args);
	}
}
