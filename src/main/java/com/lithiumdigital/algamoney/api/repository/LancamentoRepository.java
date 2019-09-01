package com.lithiumdigital.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithiumdigital.algamoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	
}
