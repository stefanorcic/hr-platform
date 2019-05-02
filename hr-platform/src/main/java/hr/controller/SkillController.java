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


import hr.model.Skill;
import hr.service.SkillService;
import io.swagger.annotations.ApiOperation;

@RestController
public class SkillController {


	@Autowired 
	private SkillService skillService;
	
	@GetMapping("skill")
	@CrossOrigin
	@ApiOperation(value = "Fetch all skills")
	public Collection<Skill> getAll(){
		return skillService.getAllSkills();
	}
	
	
	@GetMapping("skill/{id}")
	@CrossOrigin
	@ApiOperation(value = "Fetch skills based on id")
	public ResponseEntity<Skill> getById(@PathVariable("id") Integer id){
		if (skillService.getSkillById(id) != null) {
			return new ResponseEntity<Skill> (skillService.getSkillById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Skill> (HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("skill")
	@CrossOrigin
	@ApiOperation(value = "Insert skill")
	public ResponseEntity<Skill> insert(@RequestBody Skill skill){
		if (skillService.createSkill(skill) != null) {
			return new ResponseEntity<Skill> (skill, HttpStatus.OK);
		} else {
			return new ResponseEntity<Skill> (HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("skill")
	@CrossOrigin
	@ApiOperation(value = "Update skill")
	public ResponseEntity<Skill> update(@RequestBody Skill skill){
		if (skillService.updateSkill(skill) != null) {
			return new ResponseEntity<Skill> (skill, HttpStatus.OK);
		} else {
			return new ResponseEntity<Skill> (HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("skill/{id}")
	@CrossOrigin
	@ApiOperation(value = "Delete skill by id")
	public ResponseEntity<Skill> delete(@PathVariable("id") Integer id){
		if (skillService.deleteSkill(id) > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}
