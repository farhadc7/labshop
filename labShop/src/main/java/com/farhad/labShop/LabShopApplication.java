package com.farhad.labShop;

import com.farhad.labShop.Service.AddNewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class LabShopApplication {
	@Autowired
	AddNewOrderService orderService;

	@PostConstruct
	public void init(){
		orderService.setOrder();
	}

	public static void main(String[] args) {
		SpringApplication.run(LabShopApplication.class, args);

	}

}
