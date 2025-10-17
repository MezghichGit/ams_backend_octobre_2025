package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.services.ProviderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.sip.ams.entities.Provider;
import java.util.*;

@RestController
@RequestMapping("/providers")
@CrossOrigin("*")
public class ProviderController {
	@Autowired
	ProviderService providerService;
	
	
	@GetMapping("/")
	@Operation(summary = "Récupération de tous les providers")
	@ApiResponses(
			value = { 
			@ApiResponse(responseCode = "200", description = "Succès de get All Providers"),
			@ApiResponse(responseCode = "500", description = "Problème lors de la récupération") })
	
	
	
	public ResponseEntity<List<Provider>> getAllProviders() {
		return new ResponseEntity<>(this.providerService.getAllProviders(), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/")
	@Operation(summary = "Ajout d'un nouvel provider")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "Insertion avec succès"),
			@ApiResponse(responseCode = "500", description = "Problème lors de l'insertion") })
	
	
	public ResponseEntity<Provider> saveProvider(@RequestBody Provider p) {
		return new ResponseEntity<>(this.providerService.saveProvider(p), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recherche d'un provider par son id")
	@ApiResponses(value = { 
			
			@ApiResponse(responseCode = "200", description = "Si provider est trouvé"),
			@ApiResponse(responseCode = "404", description = "Provider inexistant") })
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Provider> getProviderById(@PathVariable int id) {
		
	 Optional<Provider> opt = this.providerService.getProviderById(id);

		if (opt.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return new ResponseEntity<>(opt.get(), HttpStatus.OK); // code 200
	}
	
	@Operation(summary = "Suppression d'un provider par son id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Si provider est trouvé puis supprimé"),
			@ApiResponse(responseCode = "404", description = "Provider inexistant") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Provider> deleteProviderById(@PathVariable int id){
		
		Optional<Provider> opt = this.providerService.getProviderById(id);
		
		if (opt.isEmpty())
			return ResponseEntity.notFound().build();  // code 404
		else {
			this.providerService.deleteProviderById(id);
			return ResponseEntity.noContent().build();  // code 204
		}
	}

}
