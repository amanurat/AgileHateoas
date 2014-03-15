package net.daneking.agile.home;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
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
public class HomeIntegrationTest {
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Autowired
	private HomeController controller;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void shouldReturnLinksToCreateProjetGetIsCalled() {
		mockServer.expect(requestTo("/")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("{ }", MediaType.APPLICATION_JSON));
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		String body = response.getBody();
		System.out.println(body);

		mockServer.verify();

	}

}
