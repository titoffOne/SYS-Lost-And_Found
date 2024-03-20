package logic;

import datalayer.*;

public class Logic {
	private static DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
	private static SystemUserDAO systemUser = factory.getSystemUserDAO();
	private static UserGroupDAO userGroup = factory.getUserGroupDAO();
	private static UserStatusDAO userStatus = factory.getUserStatusDAO();
	private static FindingDAO finding = factory.getFindingDAO();
	private static FindingStatusDAO findingStatus = factory.getFindingStatusDAO();
	private static FindingCategoryDAO findingCategory = factory.getFindingCategoryDAO();
	private static FinalQuestionDAO finalQuestion = factory.getFinalQuestionDAO();

	public static DAOFactory getFactory() {
		return factory;
	}

	public static void setFactory(DAOFactory factory) {
		Logic.factory = factory;
	}

	public static SystemUserDAO getSystemUser() {
		return systemUser;
	}

	public static void setSystemUser(SystemUserDAO systemUser) {
		Logic.systemUser = systemUser;
	}

	public static UserGroupDAO getUserGroup() {
		return userGroup;
	}

	public static void setUserGroup(UserGroupDAO userGroup) {
		Logic.userGroup = userGroup;
	}

	public static UserStatusDAO getUserStatus() {
		return userStatus;
	}

	public static void setUserStatus(UserStatusDAO userStatus) {
		Logic.userStatus = userStatus;
	}

	public static FindingDAO getFinding() {
		return finding;
	}

	public static void setFinding(FindingDAO finding) {
		Logic.finding = finding;
	}

	public static FindingStatusDAO getFindingStatus() {
		return findingStatus;
	}

	public static void setFindingStatus(FindingStatusDAO findingStatus) {
		Logic.findingStatus = findingStatus;
	}

	public static FindingCategoryDAO getFindingCategory() {
		return findingCategory;
	}

	public static void setFindingCategory(FindingCategoryDAO findingCategory) {
		Logic.findingCategory = findingCategory;
	}

	public static FinalQuestionDAO getFinalQuestion() {
		return finalQuestion;
	}

	public static void setFinalQuestion(FinalQuestionDAO finalQuestionCategory) {
		Logic.finalQuestion = finalQuestionCategory;
	}

}
