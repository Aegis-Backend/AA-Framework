package kobley.ap;

public class Main {
	public static void main(String[] args) {

		/*
		* Database Handling test:
			Database db = new Database("test");
			DatabaseService dbs = new DatabaseService(db);

			dbs.createTable("people", "id INTEGER PRIMARY KEY, name TEXT");

			dbs.addRow("people", "1, 'leo'");
			dbs.addRow("people", "1, 'leo'");

			try (ResultSet rs = dbs.getRows("people")) {
				while (rs != null && rs.next()) {
					System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		*/

		/*
		* Garbling test:
			char[] msg = "Hello".toCharArray();
			System.out.println(GarbleUtil.garbleChars(GarbleUtil.GarbleVersion.V1, msg, 1, true));
			System.out.println(GarbleUtil.garbleChars(GarbleUtil.GarbleVersion.V1, msg, 16, true));
			System.out.println(GarbleUtil.garbleChars(GarbleUtil.GarbleVersion.V2, msg, 1, true));
			System.out.println(GarbleUtil.garbleChars(GarbleUtil.GarbleVersion.V2, msg, 16, true));
			System.out.println(SeasoningUtil.getPepper(msg));
		 */

		System.out.println("HELLO WORLD!!!!!");
	}
}