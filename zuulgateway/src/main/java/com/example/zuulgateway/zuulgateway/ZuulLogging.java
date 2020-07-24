package com.example.zuulgateway.zuulgateway;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogging extends ZuulFilter{
	
	private Logger logger=(Logger) LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		//getting the current HTTP request that is to be handle  
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();  
		//printing the detail of the request  
		logger.info("request -> {} request uri-> {}", request, request.getRequestURI());  
		return null;  
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
