package com.lcm.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 自定义filter
 * @author aaaaa
 *
 */
@WebFilter(value="/myfilter")
public class MyFIiltert implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter into");
		
		response.getWriter().println("filter info");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
