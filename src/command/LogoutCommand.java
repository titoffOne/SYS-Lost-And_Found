package command;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;
import logic.BlockUserLogic;

//РАБОТАЕТ С БД
public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			try {
				if (request.getParameter("blockUser").equals("true")) {
					BlockUserLogic.changeUserStatus((int) request.getSession().getAttribute("userId"));
				}
			} catch (Exception e) {
				//
			}
			request.getSession().invalidate();
		}
		page = ConfigurationManager.getProperty("path.page.index");

		return page;
	}

}