package com.elsevier.filesearch.in.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * This is Filter class I introduced as per standard
 * here we are not doing anything
 * @author prate
 *
 */

public class FileSearchInFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(FileSearchInFilter.class);

	 @Override
	 public void init(FilterConfig filterConfig) throws ServletException {
	  LOGGER.info("Initiating FileSearchInFilter filter");
	 }

	 @Override
	 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	  
	  HttpServletRequest request = (HttpServletRequest) servletRequest;
	  HttpServletResponse response = (HttpServletResponse) servletResponse;
	 
	  response.setHeader("Cache-Control", "no-store"); 
	  response.setHeader("Pragma", "no-cache"); 
	  response.setHeader("Expires", "0"); 
	  
	  //call next filter in the filter chain
	  filterChain.doFilter(request, response);
	 }

	 @Override
	 public void destroy() {

	 }
	 
	}
