package com.lithiumdigital.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithiumdigital.algamoney.api.model.Pessoa;
import com.lithiumdigital.algamoney.api.repository.PessoaRepository;
import com.lithiumdigital.algamoney.api.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> listar() {

		return pessoaRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPessoaPeloCodigo(@PathVariable Long codigo) {
		Pessoa pessoaSalva = pessoaService.buscarPessoaPeloCodigo(codigo);

		return pessoaSalva != null ? ResponseEntity.ok(pessoaSalva) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {

		Pessoa pessoaCadastrada = pessoaRepository.save(pessoa);

		// Pega o codigo e faz a localização da categoria salva para ser recuperada
		// posteriormente
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaCadastrada.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(pessoa);

	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		pessoaRepository.delete(codigo);
		
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);

	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarAtivo(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo) {
		pessoaService.atualizarAtivo(codigo, ativo);
		

	}

}
