package net.daneking.agile.home;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HomeControllerTest {
	private ResponseEntity<HomeResource> responseEntity;

	@Mock
	private HomeResourceAssembler homeResourceAssembler;

	@InjectMocks
	private HomeController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		responseEntity = controller.get();
	}

	@Test
	public void shouldReturnAResponseWithAnOKStatusForGet() {
		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void shouldReturnAHomeResourceWhenGetIsCalled() {
		HomeResource resource = new HomeResource();
		when(homeResourceAssembler.toResource(isA(Home.class))).thenReturn(resource);
		verify(homeResourceAssembler).toResource(isA(Home.class));
	}

}
