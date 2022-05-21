package com.sanjit.edmodule.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanjit.edmodule.entity.EDDetailsTb;
import com.sanjit.edmodule.service.EDService;

@RestController
public class EDModuleController {

	@Autowired
	EDService service;

	@GetMapping("/plans/{cno}")
	public ResponseEntity<EDDetailsTb> planName(@PathVariable Integer cno) {

		EDDetailsTb details = service.plans(cno);
		return new ResponseEntity<>(details, HttpStatus.OK);
	}

}
