package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Candidates;

public interface CandidatesRepository extends JpaRepository<Candidates, Integer>{

}
