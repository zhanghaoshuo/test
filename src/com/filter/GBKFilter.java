package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GBKFilter implements Filter {
	
	public void destroy() {
		System.out.println("正在销毁过滤器对象......");

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("正在过滤用户的请求........");
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("正在初始化过滤器......");

	}

}
