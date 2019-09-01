package com.lithiumdigital.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithiumdigital.algamoney.api.model.Lancamento;
import com.lithiumdigital.algamoney.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	
	//LISTAR TODAS OS LANÇAMENTOS
	@GetMapping
	public List<Lancamento> listar() {

		return lancamentoRepository.findAll();

	}
	
	//BUSCAR LANÇAMENTO PELO CODIGO
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarLancamentoPeloCodigo(@PathVariable Long codigo){
		Lancamento lancamento = lancamentoRepository.findOne(codigo);
		
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	//SALVAR NOVO LANÇAMENTO
	@PostMapping
	public ResponseEntity<Lancamento> salvarNovoLancamento(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(lancamentoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(lancamentoSalvo);
	}

}
