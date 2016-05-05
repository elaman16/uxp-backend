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
@RequestMapping(value="/premiumPlan", method={RequestMethod.POST, RequestMethod.GET})
public class PremiumPlanController {
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postPremiumPlan(@RequestParam String premiumPlan, UriComponentsBuilder ucBuilder) {
	
		System.out.println(premiumPlan);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/planPermission", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postPremiumPlanPermission(@RequestParam String premiumPlanPermission, UriComponentsBuilder ucBuilder) {
	
		System.out.println(premiumPlanPermission);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}