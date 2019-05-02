package hr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hr.model.Skill;
import hr.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	public Skill createSkill(Skill skill) {
		if (!skillRepository.existsById(skill.getId())) {
			return skillRepository.save(skill);
		} else {
			return null;
		}
	}
	
	public Collection<Skill> getAllSkills(){
		return skillRepository.findAll();
	}
	
	public Skill getSkillById(Integer id) {
		if (skillRepository.getOne(id) != null) {
			return skillRepository.getOne(id);
		} else {
			return null;
		}
	}
	
	public Skill updateSkill(Skill skill) {
		if (skillRepository.getOne(skill.getId()) != null) {
			return skillRepository.save(skill);
		} else {
			return null;
		}
	}
	
	public int deleteSkill(Integer id) {
		if(skillRepository.getOne(id) != null) {
			skillRepository.deleteById(id);
			return 1;
		} else {
			return -1;
		}
	}
}
