package org.analytik.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

@SpringBootApplication(scanBasePackages = {"org.analytik.workflow"})
@EnableAutoConfiguration
public class WorkflowApplication {

	public static void main(String[] args) {

		SpringApplication.run(WorkflowApplication.class, args);
	
	}
}