package net.daneking.agile.iteration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
public class IterationControllerTest {
	@Mock
	IterationResourceAssembler resourceAssembler;
	@Mock
	IterationRepository repository;
	@Mock
	IterationResource resource;
	@Mock
	StoryRepository storyRepository;

	@InjectMocks
	private IterationController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(repository.findIterationBy(anyInt())).thenReturn(new Iteration(5));
	}

	@Test
	public void shouldReturnIterationResourceWhenGetIsCalled() {
		setupIterationAssembler(5);
		HttpEntity<IterationResource> response = controller.get(5);
		assertThat(response.getBody().getNumber(), equalTo(5));
		verify(resourceAssembler).toResource(isA(Iteration.class));

	}

	@Test
	public void shouldReturnIterationResourceWhenFindByStoryIsCalled() {
		setupIterationAssembler(5);
		HttpEntity<IterationResource> response = controller.findByStory(4);
		verify(resourceAssembler).toResource(isA(Iteration.class));

	}

	private void setupIterationAssembler(final Integer number) {
		when(resource.getNumber()).thenReturn(number);
		when(resourceAssembler.toResource(isA(Iteration.class))).thenReturn(resource);
	}

	@SuppressWarnings("unused")
	private void setupStoryCreationMock(final Integer number, final int listSize) {
		if (listSize > 0) {
			List<Story> stories = new ArrayList<Story>();
			stories.add(new Story(4));
			stories.add(new Story(7));
			when(storyRepository.findStoriesBy(isA(Integer.class))).thenReturn(stories);
		}

	}
}
