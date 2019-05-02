package hr.model;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the candidate_skill database table.
 * 
 */
@Entity
@Table(name="candidate_skill")
@NamedQuery(name="CandidateSkill.findAll", query="SELECT c FROM CandidateSkill c")
public class CandidateSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	
	@Id
	
	@SequenceGenerator(name="CANDIDATE_SKILL_ID_GENERATOR", sequenceName="CANDIDATE_SKILL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATE_SKILL_ID_GENERATOR")
	
	private Integer id;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="candidate")
	private Candidate candidateBean;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="skill")
	private Skill skillBean;

	public CandidateSkill() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Candidate getCandidateBean() {
		return this.candidateBean;
	}

	public void setCandidateBean(Candidate candidateBean) {
		this.candidateBean = candidateBean;
	}

	public Skill getSkillBean() {
		return this.skillBean;
	}

	public void setSkillBean(Skill skillBean) {
		this.skillBean = skillBean;
	}

}