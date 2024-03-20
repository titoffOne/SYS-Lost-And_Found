package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class AddUserCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession().getAttribute("adminID")) {
				page = ConfigurationManager.getProperty("path.page.adduser");
			}
		}
		return page;
	}
}
