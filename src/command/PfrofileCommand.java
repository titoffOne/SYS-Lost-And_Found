package command;

import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import logic.ProfileLogic;
import resource.ConfigurationManager;

//РАБОТАЕТ С БД
public class PfrofileCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (request.getSession().getAttribute("role") != null) {
			if (request.getParameter("data").equals("refresh")) {
				changeUser(request);
			}

			request.setAttribute("profileData",
					ProfileLogic.getSystemUserForID((int) request.getSession().getAttribute("userId")));
			request.setAttribute("saveMessage", "no");
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("clientID")) {
				page = ConfigurationManager.getProperty("path.page.userprofile");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("adminID")) {
				page = ConfigurationManager.getProperty("path.page.adminprofile");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				page = ConfigurationManager.getProperty("path.page.moderatorprofile");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				page = ConfigurationManager.getProperty("path.page.receiver.profile");
			}

			if (request.getParameter("data").equals("refresh")) {
				request.setAttribute("saveMessage", "yes");
			}
		}

		return page;
	}

	private void changeUser(HttpServletRequest request) {
		ProfileLogic.updateUserProfile((Coder.toUTF8(request.getParameter("name"))),
				(Coder.toUTF8(request.getParameter("login"))), (Coder.toUTF8(request.getParameter("email"))),
				Integer.parseInt(request.getParameter("userid")));
	}

}
