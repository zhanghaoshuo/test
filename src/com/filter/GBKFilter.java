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
		System.out.println("�������ٹ���������......");

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("���ڹ����û�������........");
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("���ڳ�ʼ��������......");

	}

}
