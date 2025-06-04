package de.databude.backend;

import org.springframework.boot.SpringApplication;

public class TestDataBudeApplication {

	public static void main(String[] args) {
		SpringApplication.from(DataBudeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
