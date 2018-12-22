package com.pco.hamrah;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import com.pco.hamrah.common.model.User;
import com.pco.hamrah.service.UserService;

@SpringBootApplication
@EntityScan(basePackages = "com.pco.hamrah")
public class BootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}
	
	@Component
	public class DataLoader implements ApplicationRunner {

		@Autowired
		private UserService userService;

		public void run(ApplicationArguments args) {
			ArrayList<User> entities = new ArrayList<>();
			if (userService.count() < 50) {
				for (int i = 0; i < 50; i++) {
					User person = new User("Pedram +" + i, "Khoshdani", 28);
					entities.add(person);
				}
				userService.saveAll(entities);
				userService.flush();
				System.out.println("Flushing the data is done!");
			}
		}
	}
}
