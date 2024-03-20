package logic;

import datalayer.data.SystemUser;

public class ProfileLogic {
	public static SystemUser getSystemUserForID(int id) {
		SystemUser foundedUser = Logic.getSystemUser().getSystemUserForUserID(id);
		return foundedUser;
	}
	
	public static void updateUserProfile(String fullname, String login, String email, int userId) {
		Logic.getSystemUser().UpdateFullnamePhoneEmailForUserId(fullname, login, email, userId);;
	}

}
