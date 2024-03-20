package datalayer;



public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract SystemUserDAO getSystemUserDAO();
	public abstract UserGroupDAO getUserGroupDAO();
	public abstract UserStatusDAO getUserStatusDAO();
	public abstract FindingDAO getFindingDAO();
	public abstract FindingStatusDAO getFindingStatusDAO();
	public abstract FindingCategoryDAO getFindingCategoryDAO();
	public abstract FinalQuestionDAO getFinalQuestionDAO();
	public abstract void closeConnection();
}
