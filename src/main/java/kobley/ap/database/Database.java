package kobley.ap.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Creates directory and file/db if they don't already exist. Also provides db connection.

public class Database {
	private final String name;
	private final String path;

	public Database(String name) {
		this.name = name;
		this.path = "./db/" + name + ".db";
		createDatabaseFile();
	}

	public String getName() {
		return this.name;
	}

	public String getPath() {
		return this.path;
	}

	private void createDatabaseFile() {
		File dbDir = new File("./db");
		if (!dbDir.exists()) {
			dbDir.mkdir();
		}

		File dbFile = new File(this.getPath());
		try {
			if (dbFile.createNewFile()) {
				System.out.println("Database file created: " + this.getPath());
			} else {
				System.out.println("Database file already exists: " + this.getPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + this.getPath());
	}
}

