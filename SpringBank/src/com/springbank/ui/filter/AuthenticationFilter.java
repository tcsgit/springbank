package com.springbank.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbank.ui.bean.LoginBean;

public class AuthenticationFilter implements Filter {

	private String contextPath;
	private String loginPage;
	private String requestedUrl;
	private String requestedPage;
	private String pageExtension;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		contextPath = "/"+filterConfig.getServletContext().getServletContextName();
		loginPage = filterConfig.getInitParameter("loginPage");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		requestedUrl = ((HttpServletRequest) request).getRequestURI();
		requestedPage = requestedUrl.substring(requestedUrl.lastIndexOf("/"));
		pageExtension = requestedPage.substring(requestedPage.indexOf(".")+1);
		
		if ( requestedPage.equals(loginPage) || requestedPage.equals("/") || (!pageExtension.equals("faces") && !pageExtension.equals("jsp")) ) {				
	            chain.doFilter(request, response);	            
        } else {        	
    		HttpSession session = ((HttpServletRequest) request).getSession();
    		LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");		
            boolean isAuthenticated = (loginBean != null && loginBean.getOperator().getOperatorAlias() != null);
            
            if (isAuthenticated) {
            	chain.doFilter(request,response);
            } else {
            	((HttpServletResponse)response).sendRedirect(contextPath + loginPage);
            }            
        }

	}

	public void destroy() {
		contextPath = null;
		loginPage = null;
		requestedUrl = null;
		requestedPage = null;
		pageExtension = null;		
	}
	
}