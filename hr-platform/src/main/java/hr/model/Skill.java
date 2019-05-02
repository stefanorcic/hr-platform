package hr.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKILL_ID_GENERATOR", sequenceName="SKILL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKILL_ID_GENERATOR")
	
	private Integer id;

	private String name;

	//bi-directional many-to-one association to CandidateSkill
	@OneToMany(mappedBy="skillBean", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<CandidateSkill> candidateSkills;

	public Skill() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CandidateSkill> getCandidateSkills() {
		return this.candidateSkills;
	}

	public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
		this.candidateSkills = candidateSkills;
	}

	public CandidateSkill addCandidateSkill(CandidateSkill candidateSkill) {
		getCandidateSkills().add(candidateSkill);
		candidateSkill.setSkillBean(this);

		return candidateSkill;
	}

	public CandidateSkill removeCandidateSkill(CandidateSkill candidateSkill) {
		getCandidateSkills().remove(candidateSkill);
		candidateSkill.setSkillBean(null);

		return candidateSkill;
	}

}