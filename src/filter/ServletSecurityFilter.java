package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSecurityFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse resp = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
	    String loginPage = "/Lost-And-Found/";
	    String homePage = "/Lost-And-Found/home";
	    String currentURI = req.getRequestURI();
	    Object role = session.getAttribute("role");
	    if ((role == null) && (!currentURI.equals(loginPage)) && (!currentURI.equals(homePage))&&(!currentURI.startsWith("/Lost-And-Found/jsp"))) {
	    	resp.sendRedirect(req.getContextPath());
	    	session.invalidate();
	        return;
	    }
	    chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}
}
