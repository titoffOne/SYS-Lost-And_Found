package command;

import javax.servlet.http.HttpServletRequest;

import logic.ChangeUserLogic;
import resource.ConfigurationManager;

//РАБОТАЕТ С БД
public class ChangeUserCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession().getAttribute("adminID")) {
				String userID = request.getParameter("userid");
				if (userID != null) {
					request.setAttribute("user", ChangeUserLogic.getUserForUserID(Integer.parseInt(userID)));
				}
				page = ConfigurationManager.getProperty("path.page.changeuser");
			}
			return page;
		}
		return page;
	}

}
