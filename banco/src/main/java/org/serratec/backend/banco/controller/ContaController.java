package org.serratec.backend.banco.controller;

import java.util.List;

import org.serratec.backend.banco.entity.ContaEntity;
import org.serratec.backend.banco.entity.OperacaoEntity;
import org.serratec.backend.banco.exceptions.ContaNotFoundException;
import org.serratec.backend.banco.exceptions.SaldoInsuficienteException;
import org.serratec.backend.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService service;
	
	@GetMapping
	public ResponseEntity<List<ContaEntity>> findAll() {
		return new ResponseEntity<List<ContaEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<ContaEntity> findByNumber(@PathVariable Integer numero) throws ContaNotFoundException {
		return new ResponseEntity<ContaEntity>(service.getByNumber(numero),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ContaEntity conta) {
		service.create(conta);
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{numero}")
	public ResponseEntity<ContaEntity> update(@PathVariable Integer numero, @RequestBody ContaEntity conta) throws ContaNotFoundException {
		return new ResponseEntity<ContaEntity>(service.update(numero, conta), HttpStatus.OK);
	}
	
	@PostMapping("/{numero}/operacao")
	public ResponseEntity<ContaEntity> operacao(@PathVariable Integer numero, @RequestBody OperacaoEntity operacao) throws ContaNotFoundException, SaldoInsuficienteException {
		return new ResponseEntity<ContaEntity>(service.updateSaldo(numero, operacao), HttpStatus.OK);
	}
	
	@DeleteMapping("/{numero}")
	public ResponseEntity<String> delete(@PathVariable Integer numero) throws ContaNotFoundException {
		service.delete(numero);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
