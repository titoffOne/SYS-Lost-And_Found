package logic;

import datalayer.data.Finding;

public class ChangeFindingStatusLogic {
	public static void changeFindingStatus(int findingId) {
		Logic.getFindingStatus().updateFindingStatus(findingId);
	}
}
