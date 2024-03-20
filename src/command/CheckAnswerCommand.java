package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
import temporary.data.FinalQuestions;

public class CheckAnswerCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("clientID")) {
				request.setAttribute("foundItems", FinalQuestions.getQuestionsForFinding(1));
				page = ConfigurationManager.getProperty("path.page.user.final_questions");
			}
		}
		return page;
	}

}
