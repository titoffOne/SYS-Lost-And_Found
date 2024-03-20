package logic;

import java.util.List;

import datalayer.data.SystemUser;

public class UsersLogic {
	public static List<SystemUser> getUsersForAdmin() {
		 List<SystemUser> lst = Logic.getSystemUser().getSystemUsers();
		return lst;
	}
	
	public static List<SystemUser> getUsersForModerator() {
		 List<SystemUser> lst = Logic.getSystemUser().getClients();
		return lst;
	}

}
