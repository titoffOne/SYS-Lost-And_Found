package logic;

import java.util.HashMap;
import logic.Logic;

public class LoginLogic {

	public static boolean checkLogin(String enterLogin, String enterPass) {
		HashMap<String, String> logsAndPasswds = Logic.getSystemUser().getLoginsAndPasswds();
		return logsAndPasswds.containsKey(enterLogin) && logsAndPasswds.get(enterLogin).equals(enterPass);
	}

	public static int getGroupIdForLogin(String login) {
		int group = Logic.getSystemUser().getGroupIdForLogin(login);
		return group;
	}

	public static int getGroupIdForGroupName(String groupName) {
		int group = Logic.getUserGroup().getGroupIdForGroupName(groupName);
		return group;
	}

	public static int getUserIdForLogin(String login) {
		int id = Logic.getSystemUser().getUserIDforLogin(login);
		return id;
	}

	public static boolean checkStatusNotBlocked(String login) {
		return (Logic.getSystemUser().getUserStatusID(Logic.getSystemUser().getUserIDforLogin(login)) == Logic
				.getUserStatus().getStatusIdForStatusDescription("Активен"));
	}

}
