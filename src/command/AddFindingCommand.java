package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

//НЕ ТРЕБУЕТ РАБОТЫ С БД - ПРОСТО ПЕРЕХОД НА СТРАНИЦУ
public class AddFindingCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getSession().getAttribute("role") != null) {
			if ((int) request.getSession().getAttribute("role") == (int) request.getSession()
					.getAttribute("receiverID")) {
				page = ConfigurationManager.getProperty("path.page.receiver.add_finding");
			}
		}
		return page;
	}

}
