package com.uxp.controller;


import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class ControllerConfig {
	private static ControllerConfig instance = null;
	protected ControllerConfig() {}
	
	static Key key;
	
	public static ControllerConfig getInstance() {
		if(instance == null) {
			instance = new ControllerConfig();
			key = MacProvider.generateKey();
		}
		return instance;
	}

	public Key getKey() {
		return key;
	}
	
	/*
	 * 
	public class ClassicSingleton {
   private static ClassicSingleton instance = null;
   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
}
	 */
}
