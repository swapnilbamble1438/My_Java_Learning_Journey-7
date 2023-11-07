package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Candidates;
import com.repository.CandidatesRepository;

@Service
public class CandidatesService {
	
	@Autowired
	private CandidatesRepository cndrepo;
	
	
	public void addCandidates(Candidates cnd)
	{
		cndrepo.save(cnd);
	}
	
	public List<Candidates> getAllCandidates()
	{
		return cndrepo.findAll();
	}

	public Candidates getCandidatesById(int id)
	{
		Optional<Candidates> cnd = cndrepo.findById(id);
		if(cnd.isPresent())
		{
			return cnd.get();
		}
		return cnd.get();
	}
	
	
	public void deleteCandidates(int id)
	{
		cndrepo.deleteById(id);
	}
	
	
	
}
