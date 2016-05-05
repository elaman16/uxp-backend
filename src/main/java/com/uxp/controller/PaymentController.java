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
@RequestMapping(value="/payment", method={RequestMethod.POST, RequestMethod.GET})
public class PaymentController {
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postPayment(@RequestParam String payment, UriComponentsBuilder ucBuilder) {
	
		System.out.println(payment);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/customer", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postPaymentCustomer(@RequestParam String customer, UriComponentsBuilder ucBuilder) {
	
		System.out.println(customer);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/customerLicense", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postCustomerLicense(@RequestParam String customerLicense, UriComponentsBuilder ucBuilder) {
	
		System.out.println(customerLicense);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}