package com.lithiumdigital.algamoney.api.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithiumdigital.algamoney.api.model.Lancamento;
import com.lithiumdigital.algamoney.api.repository.LancamentoRepository;
import com.lithiumdigital.algamoney.api.repository.filter.LancamentoFilter;
import com.lithiumdigital.algamoney.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	LancamentoService lancamentoService;
	
	
	

	// LISTAR TODAS OS LANÇAMENTOS
	@GetMapping
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {

		return lancamentoRepository.filtrar(lancamentoFilter, pageable);

	}

	// BUSCAR LANÇAMENTO PELO CODIGO
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarLancamentoPeloCodigo(@PathVariable Long codigo) {
		Lancamento lancamento = lancamentoRepository.findOne(codigo);

		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}

	// SALVAR NOVO LANÇAMENTO
	@PostMapping
	public ResponseEntity<Lancamento> salvarNovoLancamento(@Valid @RequestBody Lancamento lancamento,
			HttpServletResponse response) {
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(lancamentoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(lancamentoSalvo);
	}

	// DELETAR LANÇAMENTO
	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerLancamento(@PathVariable Long codigo) {
		lancamentoRepository.delete(codigo);

	}

	// ATUALIZAR LANÇAMENTOS
	@PutMapping("{codigo}")
	public ResponseEntity<Lancamento> atualizaLancamento(@PathVariable Long codigo,
			@Valid @RequestBody Lancamento lancamento) {
		Lancamento lancamentoSalvo = lancamentoService.atualizar(codigo, lancamento);

		return ResponseEntity.ok(lancamentoSalvo);

	}

}
