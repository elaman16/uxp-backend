package com.uxp.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.uxp.model.Annotation;

@RestController
public class AnnotationController {
	

 /*GET all annotations, copied from umesh's code. Serv is not written yet.
	@RequestMapping(value = "/annotations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Annotation>> displayAll() {
		List<Annotation> annotationList = annotationService.displayAll();
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<Annotation>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Annotation>>(annotationList, HttpStatus.OK);
*/		
	@RequestMapping(value = "/annotations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody Annotation Annotation, UriComponentsBuilder ucBuilder) {
		
		
		//TODO call the annotation service, have it save the new annotation
		System.out.println(Annotation);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}

	