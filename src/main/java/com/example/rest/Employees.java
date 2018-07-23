package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employee")
public class Employees {

	@GetMapping(path = "/{id}")
	public String getEmployee(@PathVariable(name="id") Integer id) {
		return "Hello World !!";
	}
	
}
