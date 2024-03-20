package logic;
public class BlockUserLogic {
	public static void changeUserStatus(int userID) {
		Logic.getSystemUser().UpdateUserStatusForUserId(userID);
	}
}
