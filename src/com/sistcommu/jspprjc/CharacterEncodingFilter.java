package com.sistcommu.jspprjc;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	private String encoding;

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response,
			FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
		// TODO Auto-generated method stub
//		System.out.println("before 필터라요");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
//		System.out.println("after 필터라요");
	}

	@Override
	public void init(final FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encoding = config.getInitParameter("encoding");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
