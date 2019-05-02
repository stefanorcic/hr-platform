package hr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.model.Candidate;
import hr.model.CandidateSkill;
import hr.model.Skill;
import hr.model.helper.ResponseCandidateSkill;
import hr.repository.CandidateSkillRepository;
import hr.repository.SkillRepository;

@Service
public class CandidateSkillService {

	@Autowired
	private CandidateSkillRepository candidateSkillRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	public CandidateSkill createCandidateSkill(CandidateSkill candidateSkill) {
		if (!candidateSkillRepository.existsById(candidateSkill.getId())) {
			return candidateSkillRepository.save(candidateSkill);
		} else {
			return null;
		}
	}
	
	public Collection<CandidateSkill> getAllCandidateSkill() {
		return candidateSkillRepository.findAll();
	}
	
	public CandidateSkill getByCandidateAndSkill(Candidate c, Skill s) {
		return candidateSkillRepository.findByCandidateBeanAndSkillBean(c,s);
	}
	
	public Collection<ResponseCandidateSkill> getCandidateBySkillDisjunction(List<Integer> ids) {
		Collection<Skill> skills = skillRepository.findAllById(ids);
		Collection<CandidateSkill> req = candidateSkillRepository.findBySkillBeanIn(skills);
		Collection<Candidate> can = new ArrayList <Candidate>();
		Collection<ResponseCandidateSkill> resp = new ArrayList <ResponseCandidateSkill>();
				
		for (CandidateSkill candidateSkill : req) {
			if (can.contains(candidateSkill.getCandidateBean()) == false) {
				ArrayList<Skill> skillsTemp1 = new ArrayList<Skill>();
				
				for (CandidateSkill candidateSkill1 : req) {
					if (candidateSkill1.getCandidateBean().getId() == candidateSkill.getCandidateBean().getId()) {
						skillsTemp1.add(candidateSkill1.getSkillBean());
					}
				}
				ResponseCandidateSkill rcsSet = new ResponseCandidateSkill();
				rcsSet.setId(candidateSkill.getCandidateBean().getId());
				rcsSet.setCandidate(candidateSkill.getCandidateBean());
				rcsSet.setSkills(skillsTemp1);
				resp.add(rcsSet);
				can.add(candidateSkill.getCandidateBean());
			}
		}
		return resp;
	}
	
	public Collection<ResponseCandidateSkill> getCandidateBySkillConjunction(List<Integer> ids) {
		Collection<Skill> skills = skillRepository.findAllById(ids);
		Collection<CandidateSkill> req = candidateSkillRepository.findBySkillBeanIn(skills);
		Collection<Candidate> can = new ArrayList <Candidate>();
		Collection<ResponseCandidateSkill> resp = new ArrayList <ResponseCandidateSkill>();
		
		
		for (CandidateSkill candidateSkill : req) {
			if (can.contains(candidateSkill.getCandidateBean()) == false) {
				ArrayList<Skill> skillsTemp1 = new ArrayList<Skill>();
				
				for (CandidateSkill candidateSkill1 : req) {
					if (candidateSkill1.getCandidateBean().getId() == candidateSkill.getCandidateBean().getId()) {
						skillsTemp1.add(candidateSkill1.getSkillBean());
					}
				}
				if (skillsTemp1.size() == skills.size()) {
					ResponseCandidateSkill rcsSet = new ResponseCandidateSkill();
					rcsSet.setId(candidateSkill.getCandidateBean().getId());
					rcsSet.setCandidate(candidateSkill.getCandidateBean());
					rcsSet.setSkills(skillsTemp1);
					resp.add(rcsSet);					
				}
				can.add(candidateSkill.getCandidateBean());
			}
		}
		
		
		
		return resp;
	}
	
	public Collection<CandidateSkill> getCandidateSkillByCandidateId(Integer id) {	
		return candidateSkillRepository.findByCandidateBeanId(id);
	}
	
	
	public CandidateSkill updateCandidateSkill(CandidateSkill candidateSkill) {
		if (candidateSkillRepository.getOne(candidateSkill.getId()) != null) {
			return candidateSkillRepository.save(candidateSkill);
		} else {
			return null;
		}
	}
	
	public int deleteCandidateSkill(Integer id) {
		if(candidateSkillRepository.getOne(id) != null) {
			candidateSkillRepository.deleteById(id);
			return 1;
		} else {
			return -1;
		}
	}
}
