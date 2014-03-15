package net.daneking.agile.home;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<String> get() {
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);

		return response;

	}

	public HttpEntity<Void> create() {
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
