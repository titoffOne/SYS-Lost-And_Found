package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
//НЕ ТРЕБУЕТ РАБОТЫ С БД
public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}

}