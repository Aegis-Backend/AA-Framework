package kobley.ap;

import kobley.ap.database.Database;
import kobley.ap.database.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		Database db = new Database("test");
		DatabaseService dbs = new DatabaseService(db);

		dbs.createTable("people", "id INTEGER PRIMARY KEY, name TEXT");

//		dbs.addRow("people", "1, 'leo'");

		try (ResultSet rs = dbs.getRows("people")) {
			while (rs != null && rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}