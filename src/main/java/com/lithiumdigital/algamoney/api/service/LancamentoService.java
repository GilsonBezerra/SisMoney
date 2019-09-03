package com.lithiumdigital.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lithiumdigital.algamoney.api.model.Lancamento;
import com.lithiumdigital.algamoney.api.model.Pessoa;
import com.lithiumdigital.algamoney.api.repository.LancamentoRepository;
import com.lithiumdigital.algamoney.api.repository.PessoaRepository;
import com.lithiumdigital.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//SERVIÇO DO MÉTODO PUT
	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = lancamentoRepository.findOne(codigo);
		
		if(lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		
		return lancamentoRepository.save(lancamentoSalvo);
	}

	//SERVIÇO DO MÉTODO POST
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}
	
	

}
