package com.sip.ams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ProviderServiceImp implements ProviderService{
	@Autowired
	ProviderRepository providerRepository;

	@Override
	public List<Provider> getAllProviders() {
		return (List<Provider>)this.providerRepository.findAll();
		
	}

	@Override
	public Provider saveProvider(Provider provider) {
		// TODO Auto-generated method stub
		return this.providerRepository.save(provider);
	}

	@Override
	public Optional<Provider> getProviderById(int id) {
		// TODO Auto-generated method stub
		return this.providerRepository.findById(id);
	}

	@Override
	public void deleteProviderById(int id) {
		this.providerRepository.deleteById(id);
		
	}

}
