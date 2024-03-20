package command;

import javax.servlet.http.HttpServletRequest;
import logic.ChangeFindingLogic;
import resource.ConfigurationManager;

//РАБОТАЕТ С БД
public class ChangeFindingCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (request.getSession().getAttribute("role") != null) {
			String findingID = request.getParameter("findingid");
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")
					|| (int) request.getSession().getAttribute("role") == (int) request.getSession()
							.getAttribute("receiverID")) {
				if (findingID != null) {
					request.setAttribute("finding",
							ChangeFindingLogic.getFindingForUserID(Integer.parseInt(findingID)));
				}else
					return page;
				if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
						.getAttribute("moderatorID")) {
					page = ConfigurationManager.getProperty("path.page.changefinding_moderator");
				}
				if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
						.getAttribute("receiverID")) {
					page = ConfigurationManager.getProperty("path.page.receiver.change_finding");
				}
			}
		}
		return page;
	}

}
