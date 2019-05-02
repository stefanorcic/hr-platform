package hr.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hr.model.Candidate;
import hr.service.CandidateService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CandidateController {


	@Autowired
	private CandidateService candidateService;

	@GetMapping("candidate")
	@CrossOrigin
	@ApiOperation(value = "Fetch all candidates")
	public Collection<Candidate> getAll(){
		return candidateService.getAllCandidates();
	}

	@GetMapping("candidate/{name}")
	@CrossOrigin
	@ApiOperation(value = "Fetch candidates by name")
	public Collection<Candidate> getByName(@PathVariable("name") String name){
		return candidateService.getCandidateByName(name);
	}
	
	@PostMapping("candidate")
	@CrossOrigin
	@ApiOperation(value = "Insert candidate")
	public ResponseEntity<Candidate> insert(@RequestBody Candidate candidate) {
		if(candidateService.createCandidate(candidate) != null) {
			return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
		} else {
			return new ResponseEntity<Candidate>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("candidate")
	@CrossOrigin
	@ApiOperation(value = "Update candidate")
	public ResponseEntity<Candidate> update(@RequestBody Candidate candidate){
		if(candidateService.updateCandidate(candidate) != null) {
			return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("candidate/{id}")
	@CrossOrigin
	@ApiOperation(value = "Delete candidate by id")
	public ResponseEntity<Candidate> delete(@PathVariable("id") Integer id){
		if (candidateService.deleteCandidate(id) > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("NZM STOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
