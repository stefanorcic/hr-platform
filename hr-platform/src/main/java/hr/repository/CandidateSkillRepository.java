package hr.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.model.Candidate;
import hr.model.CandidateSkill;
import hr.model.Skill;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Integer>{

	Collection<CandidateSkill> findBySkillBean(Skill s);

	Collection<CandidateSkill> findBySkillBeanIn(Collection<Skill> s);
	
	Collection<CandidateSkill> findByCandidateBeanId(int c);
	
	CandidateSkill findByCandidateBeanAndSkillBean(Candidate c, Skill s);
	
	//Collection<CandidateSkill> findBySkillBeanIs(Collection<Skill> s);
	
}
