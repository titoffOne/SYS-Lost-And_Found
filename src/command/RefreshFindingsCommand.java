package command;

import javax.servlet.http.HttpServletRequest;
import coder.Coder;
import logic.FindingsLogic;
import logic.RefreshFindingsLogic;
import resource.ConfigurationManager;
import java.sql.Date;

public class RefreshFindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("clientID")) {
				page = ConfigurationManager.getProperty("path.page.findings_user");
				request.setAttribute("foundItems", FindingsLogic.getFreeFindings());

			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")) {
				if (request.getParameter("act").equals("edit")) {
					int findingID = Integer.parseInt(request.getParameter("findingid"));
					String findingName = Coder.toUTF8(request.getParameter("findingName"));
					Date findingDate = Date.valueOf(Coder.toUTF8(request.getParameter("findingDate")));
					String findingPlace = Coder.toUTF8(request.getParameter("findingLocation"));
					String findingDescription = Coder.toUTF8(request.getParameter("findingDescription"));
					String category = Coder.toUTF8(request.getParameter("findingCategory"));
					RefreshFindingsLogic.changeFinding(findingID, findingName, findingDate, findingPlace,
							findingDescription, category);

					page = ConfigurationManager.getProperty("path.page.findings_moderator");
					request.setAttribute("foundItems", FindingsLogic.getAllFindings());
				} else if (request.getParameter("act").equals("delete")) {
					int findingID = Integer.parseInt(request.getParameter("findingId"));
					RefreshFindingsLogic.deleteFindingForFindingID(findingID);
					page = ConfigurationManager.getProperty("path.page.findings_moderator");
					request.setAttribute("foundItems", FindingsLogic.getAllFindings());
				}
			} else if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				String findingName = Coder.toUTF8(request.getParameter("findingName"));
				Date findingDate = Date.valueOf(Coder.toUTF8(request.getParameter("findingDate")));
				String findingPlace = Coder.toUTF8(request.getParameter("findingLocation"));
				String findingDescription = Coder.toUTF8(request.getParameter("findingDescription"));
				String category = Coder.toUTF8(request.getParameter("findingCategory"));
				if (request.getParameter("act").equals("edit")) {
					int findingID = Integer.parseInt(request.getParameter("findingid"));
					RefreshFindingsLogic.changeFinding(findingID, findingName, findingDate, findingPlace,
							findingDescription, category);
				}
				if (request.getParameter("act").equals("add")) {
					RefreshFindingsLogic.addFinding(findingName, findingDate, findingPlace, findingDescription,
							category, (int) request.getSession().getAttribute("userId"));
				}
				page = ConfigurationManager.getProperty("path.page.receiver.findings");
				request.setAttribute("foundItems",
						FindingsLogic.getFindingsForReceiver((int) request.getSession().getAttribute("userId")));

			}
		}
		return page;
	}
}
