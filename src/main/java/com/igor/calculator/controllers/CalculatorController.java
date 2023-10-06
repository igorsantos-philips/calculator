package com.igor.calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.igor.calculator.services.Calculator;

@RestController
public class CalculatorController {
	@Autowired
	private Calculator calculator;
	private static final String constant = "The result is ";

	@RequestMapping("/sum")
	String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		return constant + String.valueOf(calculator.sumInegerNumbers(a, b));
	}
}
