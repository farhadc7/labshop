package com.farhad.labShop;

import com.farhad.labShop.Service.AddNewOrderService;
import com.farhad.labShop.Service.CoreService;
import com.farhad.labShop.View.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class LabShopApplication {
	@Autowired
	AddNewOrderService orderService;
	@Autowired
	CoreService coreService;

	@PostConstruct
	public void init(){
        coreService.jsonToModel();

		//orderService.setOrder();
	}

	public static void main(String[] args) {
		SpringApplication.run(LabShopApplication.class, args);

	}

}
