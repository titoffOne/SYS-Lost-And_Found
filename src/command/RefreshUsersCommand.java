package command;

import javax.servlet.http.HttpServletRequest;
import logic.RefreshUsersLogic;
import logic.UsersLogic;
import resource.ConfigurationManager;
import coder.Coder;

//РАБОТАЕТ С БД
public class RefreshUsersCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession().getAttribute("adminID")) {
				String fullname = Coder.toUTF8(request.getParameter("fullName"));
				String email = Coder.toUTF8(request.getParameter("email"));
				String login = Coder.toUTF8(request.getParameter("login"));
				String password = Coder.toUTF8(request.getParameter("password"));
				String status = Coder.toUTF8(request.getParameter("status"));
				String group = Coder.toUTF8(request.getParameter("group"));
				if (request.getParameter("act").equals("add")) {
					RefreshUsersLogic.addUser(fullname, email, login, password, status, group);
				}
				if (request.getParameter("act").equals("change")) {
					int userID = Integer.parseInt(request.getParameter("userid"));
					RefreshUsersLogic.changeUser(userID, fullname, email, login, password, status, group);
				}
				request.setAttribute("foundUsers", UsersLogic.getUsersForAdmin());
				page = ConfigurationManager.getProperty("path.page.users_admin");

			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				request.setAttribute("foundUsers", UsersLogic.getUsersForModerator());
				page = ConfigurationManager.getProperty("path.page.users_moderator");
			}
		}
		return page;
	}
}
