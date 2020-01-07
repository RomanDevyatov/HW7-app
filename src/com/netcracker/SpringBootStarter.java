package com.netcracker;

import com.netcracker.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);

	@Autowired
	private CustomerService customerService;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("find all");
		customerService.findAll().forEach(System.out::println);
		System.out.println("------------");
		log.info("find by family");
		System.out.println(customerService.findByFamily("a1"));
		System.out.println("------------");
		//customerService.deleteById(3);
		customerService.findAll().forEach(System.out::println);
	}
}
