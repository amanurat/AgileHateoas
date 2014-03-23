package net.daneking.agile.story.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import net.daneking.agile.story.Story;
import net.daneking.agile.story.StoryRepository;

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
	StoryResource resource;

	@Mock
	StoryRepository repository;

	@Mock
	List<StoryResource> resources;

	@Mock
	StoryResourceAssembler resourceAssembler;

	@InjectMocks
	private StoryController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setupStoryAssembler();

	}

	@Test
	public void shouldReturnStoryResourceWhenGetIsCalled() {
		setupStoryCreationMock(5);
		HttpEntity<StoryResource> response = controller.get(5);
		assertThat(response.getBody().getNumber(), equalTo(Integer.valueOf(5)));
		verify(resourceAssembler).toResource(isA(Story.class));
		verify(repository).findById(isA(Integer.class));

	}

	private void setupStoryAssembler() {
		when(resourceAssembler.toResource(isA(Story.class))).thenReturn(resource);

	}

	private void setupStoryCreationMock(final Integer number) {
		when(resource.getNumber()).thenReturn(number);
		when(repository.findById(isA(Integer.class))).thenReturn(new Story(number + 2));

	}
}
