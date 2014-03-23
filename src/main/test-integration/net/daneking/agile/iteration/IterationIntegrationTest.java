package net.daneking.agile.iteration;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import net.daneking.agile.iteration.web.IterationController;
import net.daneking.agile.iteration.web.IterationResource;
import net.daneking.config.AppInitializer;
import net.daneking.config.RepositoryConfig;
import net.daneking.config.SpringConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringConfig.class, AppInitializer.class, RepositoryConfig.class })
public class IterationIntegrationTest {
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Autowired
	private IterationController controller;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void shouldReturnResourceWhenGetIsCalled() {
		mockServer.expect(requestTo("/iteration/5")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("{\"number\":5 }", MediaType.APPLICATION_JSON));
		ResponseEntity<IterationResource> response = restTemplate.getForEntity("/iteration/5", IterationResource.class);
		IterationResource body = response.getBody();
		assertEquals(body.getNumber(), Integer.valueOf(5));
		mockServer.verify();

	}

	@Test
	public void shouldReturnResourceWhenFindByStoryIsCalled() {
		mockServer.expect(requestTo("/iteration?story=2")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("{\"number\":5 }", MediaType.APPLICATION_JSON));
		ResponseEntity<IterationResource> response = restTemplate.getForEntity("/iteration?story=2",
				IterationResource.class);
		IterationResource body = response.getBody();
		assertEquals(body.getNumber(), Integer.valueOf(5));
		mockServer.verify();

	}
}
