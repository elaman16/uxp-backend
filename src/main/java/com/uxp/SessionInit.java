package com.uxp;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class SessionInit extends AbstractHttpSessionApplicationInitializer { 

        public SessionInit() {
                super(HttpSessionConfig.class); 
        }
}