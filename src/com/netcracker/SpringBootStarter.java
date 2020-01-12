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

		Customer
				c1 = customerService.save(new Customer("c1", "Sormovskiy", 10)),
				c2 =customerService.save(new Customer("c2", "Nizhegorodskiy", 15)),
				c3 = customerService.save(new Customer("c3", "Priokskiy", 5)),
				c4 =customerService.save(new Customer("c4", "Moskovskiy", 20)),
				c5 = customerService.save(new Customer("c5", "Sovetskiy", 8)),
				c6 = customerService.save(new Customer("c6", "Nizhegorodskiy", 8));
//
		Book
				b1 = bookService.save(new Book("name_book1", 100, "Sormovskiy", 10)),
			 	b2 = bookService.save(new Book("name_book2", 100, "Sovetskiy", 10)),
			 	b3 = bookService.save(new Book("name_book3", 150, "Sormovskiy", 4)),
			 	b4 = bookService.save(new Book("name_book4", 120, "Sovetskiy", 15)),
			 	b5 = bookService.save(new Book("name_book5", 120, "Gorkiy", 15)),
			 	b6 = bookService.save(new Book("name_book6", 10, "Sovetksiy", 20)),
			 	b7 = bookService.save(new Book("name_book7", 10, "Nizhegorodskiy", 20));
//
		Shop
				s1 = shopService.save(new Shop("shop_name1", "Sovetskiy", 1)),
				s2 = shopService.save(new Shop("shop_name2", "Gorkiy", 2)),
				s3 = shopService.save(new Shop("shop_name3", "Nizhegorodskiy", 3)),
				s4 = shopService.save(new Shop("shop_name4", "Sovetskiy", 4)),
				s5 = shopService.save(new Shop("shop_name5", "Gorkiy", 5)),
				s6 = shopService.save(new Shop("shop_name6", "Nizhegorodskiy", 6)),
				s7 = shopService.save(new Shop("shop_name7", "Sovetskiy", 7));

//
		purchaseService.save(new Purchase(new Date(), s1, c1, b1, 4, 1));
		purchaseService.save(new Purchase(new Date(), s2, c2, b2, 4, 10));
		purchaseService.save(new Purchase(new Date(), s3, c3, b3, 4, 100));
		purchaseService.save(new Purchase(new Date(), s4, c4, b4, 4, 100));
		purchaseService.save(new Purchase(new Date(), s5, c5, b5, 4, 100));
		purchaseService.save(new Purchase(new Date(), s6, c6, b6, 4, 100));

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
		System.out.println("------------");
		purchaseService.retrieveDateFamilyDiscountNameAmount();
	}
}
