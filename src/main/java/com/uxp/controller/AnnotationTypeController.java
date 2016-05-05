package com.uxp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value="/annotationType", method={RequestMethod.POST, RequestMethod.GET})
public class AnnotationTypeController {
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postAnnotationType(@RequestParam String annotationType, UriComponentsBuilder ucBuilder) {
		
		System.out.println(annotationType);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}