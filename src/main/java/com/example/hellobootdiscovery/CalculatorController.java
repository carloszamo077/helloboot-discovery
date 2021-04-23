package com.example.hellobootdiscovery;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class CalculatorController {
	private final CalculatorService calculatorService;

	private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/randomadd")
	public String randomAdd() {
		log.info("Calling Calculator Service: simplecalculator");
		Random random = new Random();
		return calculatorService.add(random.nextInt(), random.nextInt());
	}
	
	@GetMapping("/get")
	public String get() {
		log.info("Calling Calculator Service: simplecalculator");
		return "GET";
	}
}
