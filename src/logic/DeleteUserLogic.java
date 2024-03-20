package logic;
public class DeleteUserLogic {
	public static void deleteUserForUserID(int id) {
		Logic.getSystemUser().DeleteUserForUserId(id);
	}
}
