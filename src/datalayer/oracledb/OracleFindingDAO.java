package datalayer.oracledb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prutzkow.resourcer.*;

import datalayer.FindingDAO;
import datalayer.data.Finding;

public class OracleFindingDAO implements FindingDAO {

	private Connection connection;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public OracleFindingDAO(Connection connection) {
		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Finding> getFindings() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Finding> findingsList = new ArrayList<Finding>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(resourcer.getString("select.all.findings"));
			while (resultSet.next()) {
				int findingID = resultSet.getInt(1);
				String name = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				String place = resultSet.getString(4);
				String description = resultSet.getString(5);
				String receiver = resultSet.getString(6);
				String owner = resultSet.getString(7);
				String status = resultSet.getString(8);
				String category = resultSet.getString(9);
				Finding newFinding = new Finding(findingID, name, date, place, description, receiver, owner, status,
						category);
				findingsList.add(newFinding);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return findingsList;

	}

	@Override
	public List<Finding> getFreeFindings() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Finding> findingsList = new ArrayList<Finding>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(resourcer.getString("select.all.free.findings"));
			while (resultSet.next()) {
				int findingID = resultSet.getInt(1);
				String name = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				String place = resultSet.getString(4);
				String description = resultSet.getString(5);
				String receiver = resultSet.getString(6);
				String owner = resultSet.getString(7);
				String status = resultSet.getString(8);
				String category = resultSet.getString(9);
				Finding newFinding = new Finding(findingID, name, date, place, description, receiver, owner, status,
						category);
				findingsList.add(newFinding);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return findingsList;
	}

	@Override
	public List<Finding> getFindingsForUser(int userId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		ArrayList<Finding> findingsList = new ArrayList<Finding>();
		Finding newFinding = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.findings.for.user"));
			ps.setInt(1, userId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int findingID = resultSet.getInt(1);
				String name = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				String place = resultSet.getString(4);
				String description = resultSet.getString(5);
				String receiver = resultSet.getString(6);
				String owner = resultSet.getString(7);
				String status = resultSet.getString(8);
				String category = resultSet.getString(9);
				newFinding = new Finding(findingID, name, date, place, description, receiver, owner, status,
						category);
				findingsList.add(newFinding);
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
		return findingsList;
	}
	
	@Override
	public List<Finding> getFindingsForReceiver(int receiverID) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		ArrayList<Finding> findingsList = new ArrayList<Finding>();
		try {
			ps = connection.prepareStatement(resourcer.getString("select.findings.for.receiver"));
			ps.setInt(1, receiverID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int findingID = resultSet.getInt(1);
				String name = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				String place = resultSet.getString(4);
				String description = resultSet.getString(5);
				String receiver = resultSet.getString(6);
				String owner = resultSet.getString(7);
				String status = resultSet.getString(8);
				String category = resultSet.getString(9);
				Finding newFinding = new Finding(findingID, name, date, place, description, receiver, owner, status,
						category);
				findingsList.add(newFinding);
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
		return findingsList;
	}

	@Override
	public Finding getFindingForFindingID(int findingId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.finding.for.findingid"));
			ps.setInt(1, findingId);
			resultSet = ps.executeQuery();
			resultSet.next();
			int ID = resultSet.getInt(1);
			String name = resultSet.getString(2);
			Date date = resultSet.getDate(3);
			String place = resultSet.getString(4);
			String description = resultSet.getString(5);
			String receiver = resultSet.getString(6);
			String owner = resultSet.getString(7);
			String status = resultSet.getString(8);
			String category = resultSet.getString(9);
			Finding newFinding = new Finding(ID, name, date, place, description, receiver, owner, status, category);
			return newFinding;
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
		return null;
	}

	@Override
	public void changeFinding(int findingID, String findingName, Date findingDate, String findingPlace,
			String findingDescription, int category) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.info.for.finding"));
			ps.setString(1, findingName);
			ps.setDate(2, findingDate);
			ps.setString(3, findingPlace);
			ps.setString(4, findingDescription);
			ps.setInt(5, category);
			ps.setInt(6, findingID);
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
	public void addNewFinding( String findingName, Date findingDate, String findingPlace,
			String findingDescription, int receiver, int category) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("insert.new.finding"));
			ps.setString(1, findingName);
			ps.setDate(2, findingDate);
			ps.setString(3, findingPlace);
			ps.setString(4, findingDescription);
			ps.setInt(5, receiver);
			ps.setInt(6, category);
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
	public void setUserForFinding(int findingId, int userId) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.owner.for.finding"));
			ps.setInt(1, userId);
			ps.setInt(2, findingId);
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
	public void deleteFindingForId(int findingID) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("delete.finding.for.id"));
			ps.setInt(1, findingID);
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