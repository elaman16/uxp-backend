package com.uxp.controller;


import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
@Component
public class ControllerConfig {
	final Key key = MacProvider.generateKey();

	public Key getKey() {
		return key;
	}
	
	
}
