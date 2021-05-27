package org.serratec.backend.calculator.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.calculator.models.CalculatorEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	static List<CalculatorEntity> Lista = new ArrayList<CalculatorEntity>();

	public Integer somar(CalculatorEntity calculator) {
		if (calculator.getOperador() != null) 
			switch (calculator.getOperador()) {
			case "+":
				return (calculator.getNum1()+calculator.getNum2());
			case "-":
				return (calculator.getNum1()-calculator.getNum2());
			case "*":
				return (calculator.getNum1()*calculator.getNum2());
			case "/":
				if (calculator.getNum2()==0 ) {
					System.out.println("Nao podemos dividir por 0");
					return null;
				}
				return (calculator.getNum1()/calculator.getNum2());
			
		}
		System.out.println("Operador invalido para esse endpoint");
		return null;
	}
	
	public void create(CalculatorEntity calculator) {
		Lista.add(calculator);
	}
	
	public List<CalculatorEntity> getAll() {
		return Lista;
	}
	
	public CalculatorEntity procurar(Integer n1) {
		for(CalculatorEntity calculatorEntity : Lista) {
			if(calculatorEntity.getNum1() == n1) {
				return calculatorEntity;
			}
		}
		System.out.println("Numero nao encontrado");
		return null;
	}
}
