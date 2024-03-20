package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

//НЕ ТРЕБУЕТ РАБОТЫ С БД
public class MyTasksCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession().getAttribute("adminID")) {
				page = ConfigurationManager.getProperty("path.page.admintasks");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				page = ConfigurationManager.getProperty("path.page.moderatortasks");
			}
		}

		return page;
	}

}
