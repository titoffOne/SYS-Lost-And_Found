package datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import datalayer.FindingStatusDAO;

public class OracleFindingStatusDAO implements FindingStatusDAO{
	private Connection connection;
	private static Resourcer resourcer =  ProjectResourcer.getInstance();

	public OracleFindingStatusDAO(Connection connection) {
		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int getFindingStatusIdForStatusDescription(String statusDescription) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.finding_statusid.for.description"));
			ps.setString(1, statusDescription);
			resultSet = ps.executeQuery();
			resultSet.next();
			return resultSet.getInt(1);
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
		return 0;
	}
	
	@Override
	public void updateFindingStatus(int findingId) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.status.for.finding"));
			if (getFindingStatusId(findingId) == 1) {
				ps.setInt(1, 2);
			} else {
				ps.setInt(1, 1);
			}
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
	public int getFindingStatusId(int findingId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.finding.status.for.id"));
			ps.setInt(1, findingId);
			resultSet = ps.executeQuery();
			resultSet.next();
			return resultSet.getInt(1);
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
		return 0;
	}

}
