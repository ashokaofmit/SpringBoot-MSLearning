package com.coursecube.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.coursecube.springboot")
public class MyBootApplication implements CommandLineRunner{
	
	@Autowired
	CustomerDAO cdao;

	private static final Logger log=LoggerFactory.getLogger(MyBootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("My Boot Application ... Starts");
		log.debug("My Boot Application ... starts");
		log.info("..............................");
		
		//1. addCustomer
		Customer cust1=new Customer(99,"rj","rj@jlc",9999,"Gaya");
		cdao.addCustomer(cust1);
		
		//2. getAllCustomer
		System.out.println("..getAllCustomer..");
		List<Customer>list=cdao.getAllCustomers();
		list.forEach(cust -> System.out.println(cust));
		
		log.info("...............................");
		log.info("My Boot Application.. Ends");
		log.debug("My Boot Application.. Ends");
	}
}
