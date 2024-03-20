package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

//НЕ ТРЕБУЕТ РАБОТЫ С БД
public class InformationAboutProjectCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("clientID")) {
				page = ConfigurationManager.getProperty("path.page.useraboutproject");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				page = ConfigurationManager.getProperty("path.page.moderatoraboutproject");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				page = ConfigurationManager.getProperty("path.page.receiver.about_project");
			}
		}
		return page;
	}

}
