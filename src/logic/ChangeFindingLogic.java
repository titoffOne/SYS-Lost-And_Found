package logic;

import datalayer.data.Finding;

public class ChangeFindingLogic {
	public static Finding getFindingForUserID(int id) {
		Finding finding = Logic.getFinding().getFindingForFindingID(id);
		return finding;
	}
}
