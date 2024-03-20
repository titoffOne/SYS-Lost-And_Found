package command;

import javax.servlet.http.HttpServletRequest;
import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;

public class ChangeFinalQuestionCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (request.getSession().getAttribute("role") != null) {
			String finalQuestionID = request.getParameter("finalquestionid");
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("moderatorID")
					|| (int) request.getSession().getAttribute("role") == (int) request.getSession()
							.getAttribute("receiverID")) {
				request.setAttribute("finalQuestion",
						FinalQuestionsLogic.getFinalQuestionById(Integer.parseInt(finalQuestionID)));

				if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
						.getAttribute("moderatorID")) {
					page = ConfigurationManager.getProperty("path.page.changefinalquestion_moderator");
				}

				if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
						.getAttribute("receiverID")) {
					page = ConfigurationManager.getProperty("path.page.receiver.change_final_question");
				}
			}
		}
		return page;
	}

}
