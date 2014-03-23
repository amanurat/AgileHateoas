package net.daneking.agile.home.web;

import net.daneking.agile.home.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	@Autowired
	HomeResourceAssembler homeResourceAssembler;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HomeResource> get() {
		HomeResource body = homeResourceAssembler.toResource(new Home());

		return new ResponseEntity<HomeResource>(body, HttpStatus.OK);

	}
}
