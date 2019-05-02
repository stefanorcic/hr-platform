package hr.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
	Collection<Candidate> findByNameContainingIgnoreCase(String name);
	
}
