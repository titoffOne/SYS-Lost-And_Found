package datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import datalayer.UserStatusDAO;

public class OracleUserStatusDAO implements UserStatusDAO {

	private Connection connection;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public OracleUserStatusDAO(Connection connection) {
		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int getStatusIdForStatusDescription(String statusDescription) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.statusid.for.statusdescription"));
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

}
