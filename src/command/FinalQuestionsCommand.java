package command;

import javax.servlet.http.HttpServletRequest;

import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;

public class FinalQuestionsCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") != (int) request.getSession().getAttribute("adminID")) {
				int findingId = Integer.parseInt(request.getParameter("findingId"));
				if (findingId != 0) {
					if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
							.getAttribute("moderatorID")) {
						request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
						page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
					}

					if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
							.getAttribute("clientID")) {
						page = ConfigurationManager.getProperty("path.page.user.final_questions");
						request.setAttribute("findingId", findingId);
						request.setAttribute("foundQuestionAnswer",
								FinalQuestionsLogic.getQuestionsWithAnswersByFindingId(findingId));

					}

					if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
							.getAttribute("receiverID")) {
						try {
							if (request.getParameter("addFinalQuestion").equals("true")) {
								FinalQuestionsLogic.addFinalQuestion(request);
							}
						} catch (Exception e) {
							//
						}
						request.setAttribute("findingId", findingId);
						request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
						page = ConfigurationManager.getProperty("path.page.receiver.finalquestions");
					}
				}
			}
		}
		return page;
	}

}
