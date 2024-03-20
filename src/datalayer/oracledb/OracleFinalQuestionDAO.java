package datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import datalayer.FinalQuestionDAO;
import datalayer.data.FinalQuestion;

public class OracleFinalQuestionDAO implements FinalQuestionDAO {

	private Connection connection;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public OracleFinalQuestionDAO(Connection connection) {
		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<FinalQuestion> getFinalQuestionByFindingsId(int currentFindingId) {
		ArrayList<FinalQuestion> finalQuestionList = new ArrayList<FinalQuestion>();

		PreparedStatement ps = null;
		ResultSet resultSet = null;
		FinalQuestion newFinalQuestion = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.final_question.by.finding"));
			ps.setInt(1, currentFindingId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int questionId = resultSet.getInt(1);
				int findingId = resultSet.getInt(2);
				String question = resultSet.getString(3);
				String rightAnswer = resultSet.getString(4);
				String alternativeAnswer1 = resultSet.getString(5);
				String alternativeAnswer2 = resultSet.getString(6);

				newFinalQuestion = new FinalQuestion(questionId, findingId, question, rightAnswer, alternativeAnswer1,
						alternativeAnswer2);
				finalQuestionList.add(newFinalQuestion);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return finalQuestionList;
	}

	@Override
	public FinalQuestion getFinalQuestionById(int currentQuestionId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		FinalQuestion finalQuestion = null;

		try {
			ps = connection.prepareStatement(resourcer.getString("select.final_question.by.id"));
			ps.setInt(1, currentQuestionId);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int questionId = resultSet.getInt(1);
				int findingId = resultSet.getInt(2);
				String question = resultSet.getString(3);
				String rightAnswer = resultSet.getString(4);
				String alternativeAnswer1 = resultSet.getString(5);
				String alternativeAnswer2 = resultSet.getString(6);

				finalQuestion = new FinalQuestion(questionId, findingId, question, rightAnswer, alternativeAnswer1,
						alternativeAnswer2);
			}

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return finalQuestion;
	}

	@Override
	public void refreshFinalQuestion(int questionId, String question, String rightAnswer, String alternativeAnswer1,
			String alternativeAnswer2) {

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.info.for.final_question"));
			ps.setString(1, question);
			ps.setString(2, rightAnswer);
			ps.setString(3, alternativeAnswer1);
			ps.setString(4, alternativeAnswer2);
			ps.setInt(5, questionId);
		
			ps.executeQuery();
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void addFinalQuestion(int findingId, String question, String rightAnswer, String alternativeAnswer1,
			String alternativeAnswer2) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("insert.new.final_question"));
			ps.setInt(1, findingId);
			ps.setString(2, question);
			ps.setString(3, rightAnswer);
			ps.setString(4, alternativeAnswer1);
			ps.setString(5, alternativeAnswer2);
			ps.executeQuery();
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteFinalQuestionsForFindingId(int findingId) {
		PreparedStatement ps = null;
		try {
			
			ps = connection.prepareStatement(resourcer.getString("delete.finalquestion.for.finding.id"));
			ps.setInt(1, findingId);
			ps.executeQuery();
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteFinalQuestion(int questionId) {
		PreparedStatement ps = null;
		try {
			
			ps = connection.prepareStatement(resourcer.getString("delete.finalquestion.for.questionid"));
			ps.setInt(1, questionId);
			ps.executeQuery();
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
