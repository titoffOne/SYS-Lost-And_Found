package datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import com.prutzkow.resourcer.*;
import datalayer.SystemUserDAO;
import datalayer.data.SystemUser;

public class OracleSystemUserDAO implements SystemUserDAO {

	private Connection connection;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public OracleSystemUserDAO(Connection connection) {
		this.setConnection(connection);
		Locale.setDefault(Locale.US);

	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public HashMap<String, String> getLoginsAndPasswds() {

		HashMap<String, String> loginsAndPasswds = new HashMap<String, String>();
		ArrayList<SystemUser> userList = (ArrayList<SystemUser>) this.getSystemUsers();
		Iterator<SystemUser> iterator = userList.iterator();
		while (iterator.hasNext()) {
			SystemUser user = iterator.next();
			loginsAndPasswds.put(user.getLogin(), user.getPassword());
		}
		return loginsAndPasswds;
	}

	@Override
	public List<SystemUser> getSystemUsers() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(resourcer.getString("select.all.users"));
			while (resultSet.next()) {
				int userID = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String login = resultSet.getString(4);
				String password = resultSet.getString(5);
				String status = resultSet.getString(6);
				String group = resultSet.getString(7);
				SystemUser newUser = new SystemUser(userID, fullName, email, login, password, status, group);
				userList.add(newUser);
			}
			if (userList.size() == 0) {
				userList.add(SystemUser.NULL_SYSTEM_USER);
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
		return userList;

	}

	@Override
	public int getGroupIdForLogin(String login) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.groupid.of.user.for.login"));
			ps.setString(1, login);
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
	public int getUserIDforLogin(String login) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.userid.for.login"));
			ps.setString(1, login);
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
	public SystemUser getSystemUserForUserID(int userID) {

		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.system.user.for.userid"));
			ps.setInt(1, userID);
			resultSet = ps.executeQuery();
			resultSet.next();
			int ID = resultSet.getInt(1);
			String fullName = resultSet.getString(2);
			String email = resultSet.getString(3);
			String login = resultSet.getString(4);
			String password = resultSet.getString(5);
			String status = resultSet.getString(6);
			String group = resultSet.getString(7);
			SystemUser foundedUser = new SystemUser(ID, fullName, email, login, password, status, group);
			return foundedUser;
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
	public void UpdateFullnamePhoneEmailForUserId(String fullname, String login, String email, int userId) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.fullname.login.email.foruserid"));
			ps.setString(1, fullname);
			ps.setString(2, login);
			ps.setString(3, email);
			ps.setInt(4, userId);
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
	public List<SystemUser> getClients() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(resourcer.getString("select.clients"));
			while (resultSet.next()) {
				int userID = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String login = resultSet.getString(4);
				String password = resultSet.getString(5);
				String status = resultSet.getString(6);
				String group = resultSet.getString(7);
				SystemUser newUser = new SystemUser(userID, fullName, email, login, password, status, group);
				userList.add(newUser);
			}
			if (userList.size() == 0) {
				userList.add(SystemUser.NULL_SYSTEM_USER);
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
		return userList;

	}

	@Override
	public void UpdateUserStatusForUserId(int userId) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.status.foruserid"));
			if (getUserStatusID(userId) == 1) {
				ps.setInt(1, 2);
			} else {
				ps.setInt(1, 1);
			}
			ps.setInt(2, userId);
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
	public int getUserStatusID(int userId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("select.user.status.for.id"));
			ps.setInt(1, userId);
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
	public void DeleteUserForUserId(int userId) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("delete.user.for.userid"));
			ps.setInt(1, userId);
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
	public void addNewUser(String fullname, String email, String login, String password, int status, int group) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("add.new.user"));
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, login);
			ps.setString(4, password);
			ps.setInt(5, status);
			ps.setInt(6, group);
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
	public void changeUser(int userID, String fullname, String email, String login, String password, int status,
			int group) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(resourcer.getString("update.all.info.for.systemuser"));
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, login);
			ps.setString(4, password);
			ps.setInt(5, status);
			ps.setInt(6, group);
			ps.setInt(7, userID);
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