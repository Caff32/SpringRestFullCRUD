package com.unyleya.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unyleya.empresa.model.Cidadaos;
import com.unyleya.empresa.repository.CidadaoRepository;


import com.unyleya.empresa.exception.ResourceNotFoundException;





@RestController
@RequestMapping("/")
public class CidadaoController {
	
	@Autowired
	private CidadaoRepository CidadaoRepository;
	
		
	@GetMapping("/cidadaos")
	public List<Cidadaos> getAllCidadaos() throws Exception {
		
		List<Cidadaos> retorno;
		
		return CidadaoRepository.findAll();
	
	}
	
	@GetMapping("/cidadaos/{id}")
	public ResponseEntity<Cidadaos> getCidadaosIdById(@PathVariable(value = "id") Long cidadaosId)
			throws ResourceNotFoundException {
		Cidadaos cidadaos = CidadaoRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadao com id nao existente::: " + cidadaosId));
		return ResponseEntity.ok().body(cidadaos);
	}
	
	
	@PutMapping("/cidadaos/{id}")
	public ResponseEntity<Cidadaos> updateCidadaos(@PathVariable(value = "id") Long cidadaosId,
			@RequestBody Cidadaos cidadaosoDetails) throws ResourceNotFoundException {
		Cidadaos cidadaos = CidadaoRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadao com id nao existente::: " + cidadaosId));

		cidadaos.setCPF(cidadaosoDetails.getCPF());
		cidadaos.setEndereco(cidadaosoDetails.getEndereco());
		cidadaos.setNome(cidadaosoDetails.getNome());
		cidadaos.setSexo(cidadaosoDetails.getSexo());
		
		final Cidadaos updateCidadaos = CidadaoRepository.save(cidadaos);
		return ResponseEntity.ok(updateCidadaos);
	}
		
	
	@DeleteMapping("/cidadaos/{id}")
	public Map<String, Boolean> deleteCidadaos(@PathVariable(value = "id") Long cidadaosId)
			throws ResourceNotFoundException {
		Cidadaos cidadao = CidadaoRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadao com id nao existente::: " + cidadaosId));

		CidadaoRepository.delete(cidadao);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	
	@PostMapping("/cidadaos")
	public Cidadaos createCidadaos (@RequestBody Cidadaos Cidadaos) {
		
		return CidadaoRepository.save(Cidadaos);
		
	}
	
	

	

}
