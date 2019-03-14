package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		log.info("[LoggerInterceptor] afterCompletion : Request is complete");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		response.addHeader("dummy-header1", "dummy-value1");

		log.info("[LoggerInterceptor] preHandle : Before Handler execution");
        log.info("===========================request begin================================================");
        log.info("URI         : {}", request.getRequestURL());
        log.info("Method      : {}", request.getMethod());
        log.info("Headers     : {}", request.getHeaderNames() );
        
        log.info("============================response begin==========================================");
        log.info("Status code : {}", response.getStatus()  );
        log.info("HeaderNames : {}", response.getHeaderNames() );
        log.info("Header1     : {}", response.getHeader("dummy-header1") );
        log.info("Header2     : {}", response.getHeader("dummy-header2") );
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		response.addHeader("dummy-header2", "dummy-value2");
        
		log.info("[LoggerInterceptor] postHandle : Handler execution is complete");	
        log.info("===========================request begin================================================");
        log.info("URI         : {}", request.getRequestURL());
        log.info("Method      : {}", request.getMethod());
        log.info("Headers     : {}", request.getHeaderNames() );
        
        log.info("============================response begin==========================================");
        log.info("Status code : {}", response.getStatus()  );
        log.info("HeaderNames : {}", response.getHeaderNames() );	
        log.info("Header1     : {}", response.getHeader("dummy-header1") );
        log.info("Header2     : {}", response.getHeader("dummy-header2") );
	}

}
