package logic;

import java.sql.Date;

public class RefreshFindingsLogic {

	public static void changeFinding(int findingID, String findingName, Date findingDate, String findingPlace,
			String findingDescription, String category) {

		int categoryId = Logic.getFindingCategory().getCategoryIdForCategoryName(category);
		Logic.getFinding().changeFinding(findingID, findingName, findingDate, findingPlace, findingDescription, categoryId);
	}
	
	public static void addFinding( String findingName, Date findingDate, String findingPlace,
			String findingDescription, String category, int userId) {
		int categoryId = Logic.getFindingCategory().getCategoryIdForCategoryName(category);
		Logic.getFinding().addNewFinding(findingName, findingDate, findingPlace, findingDescription,userId, categoryId);
	}

	public static void deleteFindingForFindingID(int findingID) {
		//Logic.getFinalQuestion().deleteFinalQuestionsForFindingId(findingID);
		Logic.getFinding().deleteFindingForId(findingID);
		
	}
	
}
