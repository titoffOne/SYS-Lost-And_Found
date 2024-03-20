package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datalayer.data.SystemUser;
import logic.*;

public class CheckStatusFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (httpRequest.getSession(false) != null) {
			if ((httpRequest.getSession().getAttribute("userId")!=null) ) {
			SystemUser user = Logic.getSystemUser()
					.getSystemUserForUserID(((int) httpRequest.getSession().getAttribute("userId")));
			//System.out.print(user.getStatus());
			if (user== null || user.getStatus().equals("Заблокирован")) {
				
				((HttpServletRequest)request).getSession().invalidate();
				httpResponse.sendRedirect(httpRequest.getContextPath());
				return;
			}
		}
			
	}
		chain.doFilter(request,response);

	

	}

	public void destroy() {
	}

}
