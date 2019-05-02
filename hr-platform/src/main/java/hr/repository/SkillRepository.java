package hr.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{

	Collection<Skill> findByNameContainingIgnoreCase(String name);
	
	
}
