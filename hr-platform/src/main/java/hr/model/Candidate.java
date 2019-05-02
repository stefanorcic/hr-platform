package hr.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CANDIDATE_ID_GENERATOR", sequenceName="CANDIDATE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATE_ID_GENERATOR")
	
	private Integer id;

	@Column(name="contact_number")
	private String contactNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String email;

	private String name;

	//bi-directional many-to-one association to CandidateSkill
	@OneToMany(mappedBy="candidateBean", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<CandidateSkill> candidateSkills;

	public Candidate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		candidateSkill.setCandidateBean(this);

		return candidateSkill;
	}

	public CandidateSkill removeCandidateSkill(CandidateSkill candidateSkill) {
		getCandidateSkills().remove(candidateSkill);
		candidateSkill.setCandidateBean(null);
		
		
		
		return candidateSkill;
	}

}