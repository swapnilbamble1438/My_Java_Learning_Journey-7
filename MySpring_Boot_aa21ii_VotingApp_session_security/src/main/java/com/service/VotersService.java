package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Voters;
import com.repository.VotersRepository;

@Service
public class VotersService {
	
	@Autowired
	private VotersRepository vtrrepo;
	
	
	public void addVoters(Voters vtr)
	{
		vtrrepo.save(vtr);
	}
	
	public List<Voters> getAllVoters()
	{
		return vtrrepo.findAll();
	}
	
	public Voters getVotersById(int id)
	{
		Optional<Voters> vtr = vtrrepo.findById(id);
		if(vtr.isPresent())
		{
			return vtr.get();
		}
		return null;
	}

	public void deleteVoters(int id)
	{
		vtrrepo.deleteById(id);
	}
	
	public Voters getVotersByEmail(String email)
	{
		return vtrrepo.getVotersByEmail(email);
	}
	
	
}
