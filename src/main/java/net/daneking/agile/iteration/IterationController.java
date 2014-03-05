package net.daneking.agile.iteration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/iteration")
public class IterationController {
	@Autowired
	IterationResourceAssembler iterationResourceAssembler;

	@RequestMapping("/{number}")
	@ResponseBody
	public HttpEntity<IterationResource> get(@PathVariable final String number) {
		IterationResource iteration = iterationResourceAssembler.toResource(new Iteration(number));
		return new ResponseEntity<IterationResource>(iteration, HttpStatus.OK);
	}

}
