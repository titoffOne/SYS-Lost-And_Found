package command;

import javax.servlet.http.HttpServletRequest;
import logic.FindingsLogic;
import resource.ConfigurationManager;

//РАБОТАЕТ С БД
public class FindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("clientID")) {
				try {
					if (request.getParameter("setOwnershipForUser").equals("true")) {
						FindingsLogic.setUserForFinding(Integer.parseInt(request.getParameter("findingId")),
								(int) request.getSession().getAttribute("userId"));
					}
				} catch (Exception e) {
				}
				request.setAttribute("foundItems", FindingsLogic.getFreeFindings());
				page = ConfigurationManager.getProperty("path.page.findings_user");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				request.setAttribute("foundItems", FindingsLogic.getAllFindings());
				page = ConfigurationManager.getProperty("path.page.findings_moderator");
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				request.setAttribute("foundItems",
						FindingsLogic.getFindingsForReceiver((int) request.getSession().getAttribute("userId")));
				page = ConfigurationManager.getProperty("path.page.receiver.findings");
			}
		}
		return page;
	}
}
