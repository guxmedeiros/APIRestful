package org.serratec.backend.projeto01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class HelloWorldController {
	
	@GetMapping("/somar")
	public double somar(@RequestParam Double numero1, Double numero2) {
		return  numero1 + numero2;
	}
	@GetMapping("/subtrair")
	public double subtrair(@RequestParam Double numero1, Double numero2) {
		return  numero1 - numero2;
	}
	@GetMapping("/multiplicar")
	public double multiplicar(@RequestParam Double numero1, Double numero2) {
		return  numero1 * numero2;
	}
	@GetMapping("/dividir")
	public double dividir(@RequestParam Double numero1, Double numero2) {
		return  numero1 / numero2;
	}
}
