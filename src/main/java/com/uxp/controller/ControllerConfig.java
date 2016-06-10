package com.uxp.controller;


import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class ControllerConfig {
	final Key key = MacProvider.generateKey();
}
