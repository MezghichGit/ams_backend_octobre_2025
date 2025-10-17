package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
