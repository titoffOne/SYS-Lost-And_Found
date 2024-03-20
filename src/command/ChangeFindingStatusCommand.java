package command;

import javax.servlet.http.HttpServletRequest;

import logic.ChangeFindingStatusLogic;
import logic.FindingsLogic;
import resource.ConfigurationManager;

public class ChangeFindingStatusCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				String findingId = request.getParameter("findingId");
				if (findingId != null) {
					ChangeFindingStatusLogic.changeFindingStatus((Integer.parseInt(findingId)));
				}else {
					return page;
				}
				request.setAttribute("foundItems",
						FindingsLogic.getFindingsForReceiver((int) request.getSession().getAttribute("userId")));
				page = ConfigurationManager.getProperty("path.page.receiver.findings");
			}
		}
		return page;
	}

}
