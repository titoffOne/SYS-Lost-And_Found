package logic;

public class RefreshUsersLogic {
	public static void addUser(String fullname, String email, String login, String password,
			String status, String group) {
		int groupId = Logic.getUserGroup().getGroupIdForGroupName(group);
		int statusId = Logic.getUserStatus().getStatusIdForStatusDescription(status);
		Logic.getSystemUser().addNewUser(fullname, email, login, password, statusId, groupId);
	}
	
	public static void changeUser(int userID, String fullname, String email, String login, String password,
			String status, String group) {
		int groupId = Logic.getUserGroup().getGroupIdForGroupName(group);
		int statusId = Logic.getUserStatus().getStatusIdForStatusDescription(status);
		Logic.getSystemUser().changeUser(userID, fullname, email, login, password, statusId, groupId);
	}
}
