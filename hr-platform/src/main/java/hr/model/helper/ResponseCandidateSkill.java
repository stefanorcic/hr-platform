package hr.model.helper;

import java.util.ArrayList;
import java.util.List;

import hr.model.Candidate;
import hr.model.Skill;

public class ResponseCandidateSkill {

	private Integer id;
	
	private Candidate candidate;
	
	private ArrayList<Skill> skills;
	
	public ResponseCandidateSkill() {
		
	}

	public Integer getId() {
		return id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}
	
	public void setSkillsItem(Skill skill) {
		this.skills.add(skill);
	}
	
	
}
