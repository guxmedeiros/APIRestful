package org.serratec.backend.calculator.controller;

import java.util.List;

import org.serratec.backend.calculator.models.CalculatorEntity;
import org.serratec.backend.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {
	
	 	@Autowired
	    CalculatorService service;
	 	
	    @PostMapping("/somar")
		public double somar(@RequestBody CalculatorEntity calculator) {
			return service.somar(calculator);
		}
	    
	    @PostMapping("/criar")
	    public void create(@RequestBody CalculatorEntity calculator) {
	    	service.create(calculator);
	    }
	
	    @GetMapping("/visualizar") 
	    public List<CalculatorEntity> visualizar() {
	    	return service.getAll();
	    }
	    
	    @GetMapping("/procurar/{num1}")
	    public CalculatorEntity procurar(@PathVariable Integer num1) {
			return service.procurar(num1);
		}
}
