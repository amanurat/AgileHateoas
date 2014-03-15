package net.daneking.agile.home;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HomeControllerTest {
	private HomeController controller;

	@Before
	public void setUp() {
		controller = new HomeController();
	}

	@Test
	public void shouldReturnAResponseWithAnOKStatusForGet() {
		ResponseEntity<String> responseEntity = (ResponseEntity<String>) controller.get();
		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void shouldReturnAResponseWithAnCreatedStatusForCreatea() {
		ResponseEntity<Void> responseEntity = (ResponseEntity<Void>) controller.create();
		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));
	}
}
