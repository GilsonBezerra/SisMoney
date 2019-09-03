package com.lithiumdigital.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lithiumdigital.algamoney.api.model.Pessoa;
import com.lithiumdigital.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	// MÉTODO ATUALIZAR
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {

		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);

		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	// MÉTODO BUSCAR PESSOA PELO CÓDIGO
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
		
		if(pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	// MÉTODO ATUALIZAR ATIVO
	public void atualizarAtivo(Long codigo, Boolean ativo) {

		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);

		pessoaRepository.save(pessoaSalva);

	}

}
