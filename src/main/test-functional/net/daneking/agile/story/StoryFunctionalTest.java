package net.daneking.agile.story;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StoryFunctionalTest {
	private static final String BASE_URI = "http://localhost:8080/AgileHateoas";

	@Test
	public void shouldReturnCreatedStatusWhenStoryIsCreated() {
		RestTemplate restTemplate = new RestTemplate();
		StoryResource storyResource = new StoryResource();
		storyResource.setName("dddd");
		storyResource.setNumber(2);
		ResponseEntity<Void> response = restTemplate.postForEntity(BASE_URI + "/stories", storyResource, Void.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void shouldReturnStoryResourceWhenGetStoryAndNumberCalled() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StoryResource> response = restTemplate
				.getForEntity(BASE_URI + "/stories/5", StoryResource.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}
}
