package com.uxp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value="/error", method={RequestMethod.POST, RequestMethod.GET})
public class ErrorController {
	@RequestMapping(value="", method={RequestMethod.POST})
	public String contentNotFound() {
		return "<h1>Content not found!<h1>";
	}
}
