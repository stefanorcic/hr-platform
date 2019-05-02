package hr.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;




@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestApiTestCase {

	@Autowired
    private MockMvc mvc;

	
	/*
	@Autowired
    private CandidateController candidateController;
    */
	
	@Test
	public void badRequest_404() throws Exception {
		mvc.perform(get("/candidates123")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError());
	}
	
	
	/*
	 * Test Candidate Rest Controller
	*/
	
	@Test
	public void CandidateGetAllCandidates_HttpResponse2xx_Successful() throws Exception {
		mvc.perform(get("/candidate")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
	}
	
	/*
	@Test
	public void CandidateInsertCandidate_HttpResponse2xx_Successful() throws Exception {
		Candidate test = new Candidate();
		test.setId(-1);
		test.setName("Unit Test");
		
		ResponseEntity<Candidate> responseEntity = this.candidateController.insert(test);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	
	@Test
	public void CandidateDeleteCandidate_HttpResponseNotfound() throws Exception {
		mvc.perform(delete("/candidate/9")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
	}
	*/
	
	
}
