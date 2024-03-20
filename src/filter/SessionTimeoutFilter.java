package filter;

import javax.servlet.*;
import javax.servlet.http.*;

import resource.ConfigurationManager;
import resource.MessageManager;

import java.io.IOException;

public class SessionTimeoutFilter implements Filter {
	private int timeout;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String timeoutParam = filterConfig.getInitParameter("timeout");
		timeout = (timeoutParam != null) ? Integer.parseInt(timeoutParam) : 1; // Время сессии в минутах
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		long currentTime = System.currentTimeMillis();
		long lastAccessedTime = session.getLastAccessedTime();
		String loginPage = "/Lost-And-Found/";
		String currentURI = httpRequest.getRequestURI();
		long inactiveInterval = currentTime - lastAccessedTime;
		if (inactiveInterval > timeout * 50 * 1000 && session.getAttribute("userId") != null && currentURI!=loginPage) {
			session.invalidate();
			httpRequest.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			httpRequest.getSession().setAttribute("showTimeoutMessage", true);
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}
		if (((HttpServletRequest)request).getSession(false)!=null) {
			chain.doFilter(request, response);
			}
	}

	@Override
	public void destroy() {
	}
}
