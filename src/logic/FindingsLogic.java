package logic;

import java.util.List;

import datalayer.data.Finding;

public class FindingsLogic {
	public static List<Finding> getAllFindings() {
		List<Finding> lst = Logic.getFinding().getFindings();
		return lst;
	}

	public static List<Finding> getFreeFindings() {
		List<Finding> lst = Logic.getFinding().getFreeFindings();
		return lst;
	}

	public static List<Finding> getFindingsForReceiver(int receiverID) {
		List<Finding> lst = Logic.getFinding().getFindingsForReceiver(receiverID);
		return lst;
	}

	public static List<Finding> getFindingForUser(int userId) {
		List<Finding> list = Logic.getFinding().getFindingsForUser(userId);
		return list;
	}

	public static void setUserForFinding(int findingId, int userId) {
		 Logic.getFinding().setUserForFinding(findingId, userId);
	}
}
