package org.serratec.backend.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.banco.entity.ContaEntity;
import org.serratec.backend.banco.entity.OperacaoEntity;
import org.serratec.backend.banco.exceptions.ContaNotFoundException;
import org.serratec.backend.banco.exceptions.SaldoInsuficienteException;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
	
	List<ContaEntity> list = new ArrayList<ContaEntity>();
	
	Integer numero = 1;
	
	public List<ContaEntity> getAll() {
		return list;
	}
	
	public ContaEntity getByNumber(Integer numero) throws ContaNotFoundException {
		for (ContaEntity element : list) {
			if (element.getNumero() == numero) {
				return element;
			}
		}
		throw new ContaNotFoundException("Nao existe conta com esse Id.");
	}
	
	public void create(ContaEntity conta) {
		conta.setNumero(numero);
		list.add(conta);
		if(conta.getSaldo() == null) {
			conta.setSaldo(0.0);
		}
		numero++;
	}
	
	public ContaEntity update(Integer numero, ContaEntity conta) throws ContaNotFoundException {
		for (ContaEntity contaEntity : list) {
			if(contaEntity.getNumero() == numero) {
				if(contaEntity.getNome() != null) {
					contaEntity.setNome(conta.getNome());
					return contaEntity;
				}
			}
		}
		throw new ContaNotFoundException("Nao existe conta com esse Id.");
		
//		ContaEntity contaEntity = getByNumber(numero);
//		if(contaEntity != null) {
//			if(contaEntity.getNome() != null) {
//				contaEntity.setNome(conta.getNome());
//				return ContaEntity;
//			}
//		}
	}
	
	public ContaEntity updateSaldo(Integer numero, OperacaoEntity operacao) throws ContaNotFoundException, SaldoInsuficienteException {
		ContaEntity contaEntity = getByNumber(numero);
			switch(operacao.getTipo()) {
			case CREDITO:
				contaEntity.setSaldo(contaEntity.getSaldo() + operacao.getValor());
				break;
			case DEBITO:
				if(contaEntity.getSaldo() < operacao.getValor()) {
					throw new SaldoInsuficienteException("Voce nao tem saldo suficiente");
				}	
				contaEntity.setSaldo(contaEntity.getSaldo() - operacao.getValor());
				break;
			}
		return contaEntity;
	}
	
	public void delete(Integer numero) throws ContaNotFoundException {
		ContaEntity contaEntity = getByNumber(numero);
			list.remove(contaEntity);
		}
}
