package com.example.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

@RestController
@RequestMapping(value = "/api")
public class Customers implements InitializingBean {
	
	private static List<Customer> customers = new ArrayList<>();
	
	@GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public List<Customer> customers(Principal principal, Model model) {
//        Iterable<Customer> customers = customers;
        model.addAttribute("customers", customers);
        model.addAttribute("username", "faiza");
        return customers;
    }
    
    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customers.add(customer3);
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		addCustomers();
	}
}
