package kobley.ap.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//temporary functions just to test if Database class worked.

public class DatabaseService {
	private final Database database;

	public DatabaseService(final Database database) {
		this.database = database;
	}

	public void createTable(String tableName, String columns) {
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + columns + ")";
		executeUpdate(sql);
	}

	public void addRow(String tableName, String values) {
		String sql = "INSERT INTO " + tableName + " VALUES (" + values + ")";
		executeUpdate(sql);
	}

	public ResultSet getRows(String tableName) {
		String sql = "SELECT * FROM " + tableName;
		return executeQuery(sql);
	}

	private void executeUpdate(String sql) {
		try (Connection connection = database.getConnection();
		     Statement statement = connection.createStatement()) {
			statement.setQueryTimeout(30);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ResultSet executeQuery(String sql) {
		try {
			Connection connection = database.getConnection();
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

