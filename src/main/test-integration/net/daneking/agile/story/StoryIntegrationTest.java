package net.daneking.agile.story;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import net.daneking.agile.story.web.StoryController;
import net.daneking.agile.story.web.StoryResource;
import net.daneking.config.AppInitializer;
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
@ContextConfiguration(classes = { SpringConfig.class, AppInitializer.class })
public class StoryIntegrationTest {
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Autowired
	private StoryController storyController;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void shouldSetValuesWhenGetNumberIsCalled() {
		mockServer.expect(requestTo("/story/5")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("{\"name\":\"Story-5\",\"number\":\"5\" }", MediaType.APPLICATION_JSON));
		ResponseEntity<StoryResource> response = restTemplate.getForEntity("/story/5", StoryResource.class);
		StoryResource body = response.getBody();
		assertEquals(body.getNumber(), Integer.valueOf(5));
		mockServer.verify();

	}
}
