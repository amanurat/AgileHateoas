package net.daneking.agile.iteration;

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
public class IterationControllerTest {
	@Mock
	IterationResourceAssembler IterationResourceAssembler;

	@InjectMocks
	private IterationController IterationController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnIterationResourceWhenGetIsCalled() {
		setupIterationAssembler();
		HttpEntity<IterationResource> response = IterationController.get("5");
		assertThat(response.getBody(), equalTo(createMockIterationResource()));
		verify(IterationResourceAssembler).toResource(isA(Iteration.class));

	}

	/*
	 * @Test public void shouldReturnStoriesWhenGetStoriesIsCalled() {
	 * setupIterationAssembler(); List<StoryResource> response =
	 * IterationController.getStories("5"); ArrayList<StoryResource> storyList =
	 * new ArrayList<StoryResource>(); assertThat(response, contains(new
	 * StoryResource()));
	 * verify(IterationResourceAssembler).toResource(isA(Iteration.class));
	 * 
	 * }
	 */
	private void setupIterationAssembler() {
		when(IterationResourceAssembler.toResource(isA(Iteration.class))).thenReturn(createMockIterationResource());
	}

	private IterationResource createMockIterationResource() {
		IterationResource IterationResource = new IterationResource();
		IterationResource.setNumber("6");
		return IterationResource;
	}
}
