package hr.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.model.Candidate;
import hr.model.CandidateSkill;
import hr.model.Skill;
import hr.repository.CandidateRepository;
import hr.repository.CandidateSkillRepository;
import hr.repository.SkillRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTestCase {
	
	
	
	@Mock
	private CandidateRepository candidateRepository;
	
	@InjectMocks
	private CandidateService candidateService;
	
	

	private ArrayList<Candidate> candidates = new ArrayList<>();
	
	@Mock
	private SkillRepository skillRepository;
	
	@InjectMocks
	private SkillService skillService;
	
	private ArrayList<Skill> skills = new ArrayList<>();
	
	@Mock
	private CandidateSkillRepository candidateSkillRepository;
	
	@InjectMocks
	private CandidateSkillService candidateSkillService;

	private ArrayList<CandidateSkill> candidateSkillList = new ArrayList<>();
	
	@Before
	public void init() {
		Candidate c = new Candidate();
		c.setId(-11);
		c.setContactNumber("065");
		c.setDateOfBirth(new Date());
		c.setEmail("stefan@gmail.com");
		c.setName("Stefan Orcic");
		
		Candidate c1 = new Candidate();
		c.setId(-12);
		c.setContactNumber("065");
		c.setDateOfBirth(new Date());
		c.setEmail("stefan@gmail.com");
		c.setName("Stefan Orcic");
		
		candidates.add(c);
		candidates.add(c1);

		Skill s = new Skill();
		s.setId(1);
		s.setName("C#");
		
		Skill s1 = new Skill();
		s1.setId(2);
		s1.setName("Java");
		
		Skill s2 = new Skill();
		s2.setId(3);
		s2.setName("Programming");
		
		skills.add(s);
		skills.add(s1);
		skills.add(s2);
		
		CandidateSkill cs1 = new CandidateSkill();
		cs1.setId(1);
		cs1.setCandidateBean(candidates.get(0));
		cs1.setSkillBean(skills.get(0));
		
		CandidateSkill cs2 = new CandidateSkill();
		cs2.setId(2);
		cs2.setCandidateBean(candidates.get(0));
		cs2.setSkillBean(skills.get(1));
		
		candidateSkillList.add(cs1);
		candidateSkillList.add(cs2);
		
	}
	
	//Candidate Service Tests
	
	@Test
	public void testCreateCandidate() {
		
		Mockito.when(candidateRepository.save(candidates.get(0))).thenReturn(candidates.get(0));
		
		assertThat(candidateService.createCandidate(candidates.get(0)).getName()).isEqualTo(candidates.get(0).getName());
	}
	
	@Test
	public void testGetCandidatesByName() {
		Collection <Candidate> col = new ArrayList <Candidate>();
		col.add(candidates.get(0));
		Mockito.when(candidateRepository.findByNameContainingIgnoreCase("Stefan Orcic")).thenReturn(col);
		assertThat(candidateService.getCandidateByName("Stefan Orcic")).isEqualTo(col);
	}
	
	@Test
	public void testGetAllCandidates() {
		List <Candidate> col = candidates;
		Mockito.when(candidateRepository.findAll()).thenReturn(col);
		assertThat(candidateService.getAllCandidates()).isEqualTo(col);
		
	}
	
	@Test
	public void testUpdateCandidate() {
		Candidate cUpdate = candidates.get(0);
		
		Mockito.when(candidateRepository.getOne(1)).thenReturn(cUpdate);
		
		cUpdate.setEmail("email");
		Mockito.when(candidateRepository.save(cUpdate)).thenReturn(cUpdate);
		
		assertThat(candidateService.updateCandidate(cUpdate)).isEqualTo(cUpdate);
		
	}
	
	@Test
	public void testDeleteCandidateByID() {
		Candidate cTemp = candidates.get(0);
		
		Mockito.when(candidateRepository.getOne(1)).thenReturn(cTemp);

		assertThat(candidateService.deleteCandidate(cTemp.getId())).isEqualTo(1);
		
	}
	
	//Skill Service Tests
	@Test
	public void testCreateSkill() {
		
		Mockito.when(skillRepository.save(skills.get(0))).thenReturn(skills.get(0));
		
		assertThat(skillService.createSkill(skills.get(0))).isEqualTo(skills.get(0));
	}
	
	@Test
	public void testGetSkillById() {
		
		Mockito.when(skillRepository.getOne(skills.get(0).getId())).thenReturn(skills.get(0));
		assertThat(skillService.getSkillById(skills.get(0).getId())).isEqualTo(skills.get(0));
	}
	
	@Test
	public void testGetAllSkills() {
		List <Skill> skillList = skills;
		Mockito.when(skillRepository.findAll()).thenReturn(skillList);
		assertThat(skillService.getAllSkills()).isEqualTo(skillList);
		
	}
	
	@Test
	public void testUpdateSkill() {
		Skill sUpdate = skills.get(0);
		
		Mockito.when(skillRepository.getOne(1)).thenReturn(sUpdate);
		
		sUpdate.setName("Angular");
		Mockito.when(skillRepository.save(sUpdate)).thenReturn(sUpdate);
		
		assertThat(skillService.updateSkill(sUpdate)).isEqualTo(sUpdate);
		
	}
	
	@Test
	public void testDeleteSkillByID() {

		Skill sTemp = skills.get(0);
		
		Mockito.when(skillRepository.getOne(1)).thenReturn(sTemp);

		assertThat(skillService.deleteSkill(sTemp.getId())).isEqualTo(1);
		
	}

	//CandidateSkill Service Tests
	
	@Test
	public void testCreateCandidateSkill() {
		
		Mockito.when(candidateSkillRepository.save(candidateSkillList.get(0))).thenReturn(candidateSkillList.get(0));
		
		assertThat(candidateSkillService.createCandidateSkill(candidateSkillList.get(0))).isEqualTo(candidateSkillList.get(0));
	}
	
	@Test
	public void testGetAllCandidateSkill() {
		List <CandidateSkill> candidateSkillL = candidateSkillList;
		Mockito.when(candidateSkillRepository.findAll()).thenReturn(candidateSkillL);
		assertThat(candidateSkillService.getAllCandidateSkill()).isEqualTo(candidateSkillL);
		
	}
	
	@Test
	public void testUpdateCandidateSkill() {
		CandidateSkill csUpdate = candidateSkillList.get(0);
		
		Mockito.when(candidateSkillRepository.getOne(1)).thenReturn(csUpdate);
		
		csUpdate.setCandidateBean(candidates.get(1));
		Mockito.when(candidateSkillRepository.save(csUpdate)).thenReturn(csUpdate);
		
		assertThat(candidateSkillService.updateCandidateSkill(csUpdate)).isEqualTo(csUpdate);
		
	}
	
	@Test
	public void testDeleteCandidateSkillByID() {
		CandidateSkill csTemp = candidateSkillList.get(0);
		
		Mockito.when(candidateSkillRepository.getOne(1)).thenReturn(csTemp);

		assertThat(candidateSkillService.deleteCandidateSkill(csTemp.getId())).isEqualTo(1);
		
	}
}
