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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.uxp.model.Annotation;
import com.uxp.model.AnnotationHashTag;
import com.uxp.model.Hashtag;
import com.uxp.model.ParentDomain;

@RestController
@RequestMapping(value="/annotations", method={RequestMethod.POST, RequestMethod.GET})
public class AnnotationController {
	
	
	
/***************************GET REQUESTS*****************************/	
// GET all annotations, copied from umesh's code. Service is not written yet. here for testing
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Annotation>> displayAll(UriComponentsBuilder ucBuilder) {
		System.out.println("GET WORKS");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/annotations").buildAndExpand().toUri());
		return new ResponseEntity<List<Annotation>>(headers, HttpStatus.OK);
	}
	// end testing GET code
	
	
/***************************POST REQUESTS*****************************/	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> save(@RequestBody Annotation Annotation, UriComponentsBuilder ucBuilder, @PathVariable String pathURL) {
				
		//TODO call the annotation service, have it save the new annotation
		System.out.println("POST /annotations/");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/abc", method=RequestMethod.POST)
	public ResponseEntity<Void> testpost(@RequestParam String username, @RequestParam String password) {
		System.out.println(username + " " + password);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@RequestMapping(value="/hashtags", method=RequestMethod.POST)
	public ResponseEntity<Void> hashtag(@RequestBody Hashtag hashtag, UriComponentsBuilder ucBuilder) {
		//do something with the hashtag
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/annotationHashtag", method=RequestMethod.POST)
	public ResponseEntity<Void> annotationHashtag(@RequestBody AnnotationHashTag annotationHashtag, UriComponentsBuilder ucBuilder) {
		//do something with the annotationHashtag
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/parentDomain", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> parentdomain(@RequestParam String parentDomain, UriComponentsBuilder ucBuilder) {
		//do something with the parentDomain
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}

	