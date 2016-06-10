package com.uxp.controller;


import java.security.Key;

import io.jsonwebtoken.impl.crypto.MacProvider;

public class ControllerConfig {
	
	
	static Key key = MacProvider.generateKey();
	
	
	
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
