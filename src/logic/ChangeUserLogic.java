package logic;
import datalayer.data.SystemUser;

public class ChangeUserLogic {
	public static SystemUser getUserForUserID(int id) {
		SystemUser usr = Logic.getSystemUser().getSystemUserForUserID(id);
		return usr;
	}
}
