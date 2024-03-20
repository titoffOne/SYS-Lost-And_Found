package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

//РАБОТАЕТ С БД
public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		if (LoginLogic.checkLogin(login, pass)) {
			if(LoginLogic.checkStatusNotBlocked(login)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", LoginLogic.getUserIdForLogin(login));
				session.setAttribute("role", LoginLogic.getGroupIdForLogin(login));
				session.setAttribute("adminID", LoginLogic.getGroupIdForGroupName("Администратор"));
				session.setAttribute("moderatorID", LoginLogic.getGroupIdForGroupName("Модератор"));
				session.setAttribute("receiverID", LoginLogic.getGroupIdForGroupName("Приемщик"));
				session.setAttribute("clientID", LoginLogic.getGroupIdForGroupName("Клиент"));
				if ((int)session.getAttribute("role") == (int)session.getAttribute("clientID")) {
					page = ConfigurationManager.getProperty("path.page.main_user");
				} else if ((int)session.getAttribute("role") ==(int)session.getAttribute("adminID")) {
					page = ConfigurationManager.getProperty("path.page.main_admin");
				} else if ((int)session.getAttribute("role") == (int)session.getAttribute("moderatorID")) {
					page = ConfigurationManager.getProperty("path.page.main_moderator");
				} else if ((int)session.getAttribute("role") == (int)session.getAttribute("receiverID")) {
					page = ConfigurationManager.getProperty("path.page.main_receiver");
				}
			}else {
				request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.blocked"));
				page = ConfigurationManager.getProperty("path.page.login");
			}
			
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
	return page;
	}

}