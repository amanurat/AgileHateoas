package net.daneking.agile.story;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class StoryControllerTest {
	@Mock
	StoryResourceAssembler storyResourceAssembler;

	@InjectMocks
	private StoryController storyController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnStoryResourceWhenGetIsCalled() {
		setupStoryAssembler();
		HttpEntity<StoryResource> response = storyController.get("5");
		assertThat(response.getBody(), equalTo(createMockStoryResource()));
		verify(storyResourceAssembler).toResource(isA(Story.class));

	}

	private void setupStoryAssembler() {
		when(storyResourceAssembler.toResource(isA(Story.class))).thenReturn(createMockStoryResource());
	}

	private StoryResource createMockStoryResource() {
		StoryResource storyResource = new StoryResource();
		storyResource.setNumber("6");
		return storyResource;
	}
}
