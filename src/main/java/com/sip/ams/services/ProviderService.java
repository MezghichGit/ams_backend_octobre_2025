package com.sip.ams.services;

import com.sip.ams.entities.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface ProviderService {

	public List<Provider> getAllProviders();
	public Provider saveProvider(Provider provider);
	//public Provider saveProvider(MultipartFile file,String name,String email,String address);
	public Optional<Provider> getProviderById(int id);
	public void deleteProviderById(int id);
}