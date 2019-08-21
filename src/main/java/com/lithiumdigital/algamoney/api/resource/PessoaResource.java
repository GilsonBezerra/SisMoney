package com.lithiumdigital.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithiumdigital.algamoney.api.model.Pessoa;
import com.lithiumdigital.algamoney.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	PessoaRepository pessoaRepository;

	// Quando fizer um GET
	@GetMapping
	public List<Pessoa> listar() {

		return pessoaRepository.findAll();
	}

	// Quando fizer um POST
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa, HttpServletResponse response) {

		Pessoa pessoaCadastrada = pessoaRepository.save(pessoa);

		// Pega o codigo e faz a localização da categoria salva para ser recuperada
		// posteriormente
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaCadastrada.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(pessoa);

	}

	//Quando fizer um DELETE
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		
		pessoaRepository.delete(codigo);

	}

}
