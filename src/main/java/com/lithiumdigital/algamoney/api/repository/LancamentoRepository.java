package com.lithiumdigital.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithiumdigital.algamoney.api.model.Lancamento;
import com.lithiumdigital.algamoney.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

	
}
