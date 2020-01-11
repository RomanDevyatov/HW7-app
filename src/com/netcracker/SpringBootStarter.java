package com.netcracker;

import com.netcracker.service.BookService;
import com.netcracker.service.CustomerService;
import com.netcracker.service.PurchaseService;
import com.netcracker.service.ShopService;
import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import com.netcracker.entity.Purchase;
import com.netcracker.entity.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;
    @Autowired
    private ShopService shopService;
	@Autowired
	private PurchaseService purchaseService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerService.deleteAll();
		bookService.deleteAll();
		shopService.deleteAll();
		purchaseService.deleteAll();

		Customer c1 = customerService.save(new Customer("c1", "Sovetskiy", 10));
		customerService.save(new Customer("c2", "Nizhegorodskiy", 15));
		customerService.save(new Customer("c3", "Priokskiy", 5));
		customerService.save(new Customer("c4", "Moskovskiy", 20));
		customerService.save(new Customer("c5", "Sovetskiy", 8));
//
		Book b1 = bookService.save(new Book("author1", 100, "Sovetskiy", 10));
		bookService.save(new Book("author1", 100, "Sovetskiy", 10));
		bookService.save(new Book("author2", 150, "Sovetskiy", 4));
		bookService.save(new Book("author3", 120, "Sovetskiy", 15));
		bookService.save(new Book("author3", 120, "Gorkiy", 15));
		bookService.save(new Book("author4", 10, "Sovetksiy", 20));
		bookService.save(new Book("author4", 10, "Sovetksiy", 20));
//
		Shop s1 = shopService.save(new Shop("name1", "Sovetskiy", 1));
		shopService.save(new Shop("name2", "Gorkiy", 5));
		shopService.save(new Shop("name3", "Nizhegorodskiy", 3));
		shopService.save(new Shop("name4", "Sovetskiy", 10));

//		purchaseService.save(new Purchase(new Date(), shopService.

		purchaseService.save(new Purchase(new Date(), s1, c1, b1, 4, 10));

		log.info("find all");
		customerService.findAll().forEach(System.out::println);
		System.out.println("------------");
		log.info("find all book");
		bookService.findAll().forEach(System.out::println);
		log.info("find all shop");
		shopService.findAll().forEach(System.out::println);
		log.info("find all purchase");
		purchaseService.findAll().forEach(System.out::println);
		System.out.println("------------");
		customerService.retrieveGeography().forEach(System.out::println);
		System.out.println("------------");
		bookService.retrieveNameCost().forEach(System.out::println);
		System.out.println("------------");
		purchaseService.retrieveDate().forEach(System.out::println);
		System.out.println("------------");
		customerService.retrieveFamilyDiscount().forEach(System.out::println);
		System.out.println("------------");
		shopService.retrieveNameWhereAreaOr("Sormovskiy", "Sovetskiy").forEach(System.out::println);
		System.out.println("------------");
		bookService.retrieveNameLikeWindows();
	}
}
//xyi
