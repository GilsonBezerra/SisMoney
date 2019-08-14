package com.lithiumdigital.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithiumdigital.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
