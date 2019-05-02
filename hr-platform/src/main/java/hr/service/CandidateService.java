package hr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.model.Candidate;
import hr.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	public Candidate createCandidate(Candidate candidate) {
		if (!candidateRepository.existsById(candidate.getId())) {
			return candidateRepository.save(candidate);
		} else {
			return null;
		}
	}
	
	public Collection<Candidate> getAllCandidates(){
		return candidateRepository.findAll();
	}
	
	public Collection<Candidate> getCandidateByName(String name) {
		return candidateRepository.findByNameContainingIgnoreCase(name);
	}
	
	public Candidate updateCandidate(Candidate candidate) {
		if (candidateRepository.findById(candidate.getId()) != null) {
			return candidateRepository.save(candidate);
		} else {
			return null;
		}
	}
	
	public int deleteCandidate(int id) {
		if(candidateRepository.findById(id) != null) {
			System.out.println(  candidateRepository.getOne(id));
			candidateRepository.deleteById(id);
			return 1;
		} else {
			return -1;
		}
	}
	
}
