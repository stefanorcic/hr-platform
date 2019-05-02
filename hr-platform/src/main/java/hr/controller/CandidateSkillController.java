package hr.controller;

import java.util.Collection;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import hr.model.CandidateSkill;
import hr.model.helper.ResponseCandidateSkill;
import hr.service.CandidateSkillService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CandidateSkillController {

	@Autowired 
	private CandidateSkillService candidateSkillService;
	
	@GetMapping("candidate-skill")
	@CrossOrigin
	@ApiOperation(value = "Fetch all candidate-skill relations")
	public Collection<CandidateSkill> getAll(){
		return candidateSkillService.getAllCandidateSkill();
	}
	
	@GetMapping("candidate-skill/candidate/search")
	@CrossOrigin
	@ApiOperation(value = "Fetch candidates with some of the given skills")
	public Collection<ResponseCandidateSkill> searchCandidateBySkills(@RequestParam boolean byAll,@RequestParam List<Integer> skillIds){
		if (byAll) {
			return candidateSkillService.getCandidateBySkillConjunction(skillIds);
		} else {
			return candidateSkillService.getCandidateBySkillDisjunction(skillIds);
		}
		
	}
	/*
	@GetMapping("candidate-skill/candidate/have-some-skills")
	@CrossOrigin
	@ApiOperation(value = "Fetch candidates with some of the given skills")
	public Collection<ResponseCandidateSkill> searchCandidateBySomeSkills(@RequestBody Collection<Skill> skills){
		
		return candidateSkillService.getCandidateBySkillDisjunction(skills);
	}
	
	
	*/
	/*
	@GetMapping("candidate-skill/candidate/have-all-skills")
	@CrossOrigin
	@ApiOperation(value = "Fetch candidates with all of the given skills")
	public Collection<ResponseCandidateSkill> searchCandidateByAllSkills(@RequestBody Collection<Skill> skills){
		return candidateSkillService.getCandidateBySkillConjunction(skills);
	}
	*/
	
	@GetMapping("candidate-skill/candidate/{id}")
	@CrossOrigin
	@ApiOperation(value = "Fetch candidates with all of the given skills")
	public Collection<CandidateSkill> getById(@PathVariable("id") Integer id){
		return candidateSkillService.getCandidateSkillByCandidateId(id);
	}
		
	@PostMapping("candidate-skill")
	@CrossOrigin
	@ApiOperation(value = "Insert candidate-skill")
	public ResponseEntity<CandidateSkill> insert(@RequestBody CandidateSkill candidateSkill) {
		if (candidateSkillService.getByCandidateAndSkill(candidateSkill.getCandidateBean(), candidateSkill.getSkillBean()) !=null) {
			return new ResponseEntity<>	(HttpStatus.CREATED);
		} else {
			if (candidateSkillService.createCandidateSkill(candidateSkill) != null) {
				return new ResponseEntity<CandidateSkill> (candidateSkill, HttpStatus.OK);
			} else {
				return new ResponseEntity<>	(HttpStatus.NO_CONTENT);
			}
		}
	}
	
	@PutMapping("candidate-skill")
	@CrossOrigin
	@ApiOperation(value = "Update candidate-skill")
	public ResponseEntity<CandidateSkill> update(@RequestBody CandidateSkill candidateSkill) {
		if (candidateSkillService.getByCandidateAndSkill(candidateSkill.getCandidateBean(), candidateSkill.getSkillBean()) !=null) {
			return new ResponseEntity<>	(HttpStatus.CREATED);
		} else {
			if (candidateSkillService.updateCandidateSkill(candidateSkill) != null) {
				return new ResponseEntity<CandidateSkill> (candidateSkill, HttpStatus.OK);
			} else {
				return new ResponseEntity<>	(HttpStatus.NO_CONTENT);
			}
		}
	}
	
	@DeleteMapping("candidate-skill/{id}")
	@CrossOrigin
	@ApiOperation(value = "Delete candidate-skill by id")
	public ResponseEntity<CandidateSkill> delete(@PathVariable("id") Integer id){
		if (candidateSkillService.deleteCandidateSkill(id) > 0) {
			return new ResponseEntity<CandidateSkill> (HttpStatus.OK);
		} else {
			return new ResponseEntity<>	(HttpStatus.NO_CONTENT);
		}
	}
}
