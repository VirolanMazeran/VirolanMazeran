package incendie;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionSingleton {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/incendie";
	private static final String DB_USER = "virmaz";
	private static final String DB_PSWD = "virmaz";

	private static Connection connection; // l’objet Connection

	private ConnexionSingleton() {
		try {
			ConnexionSingleton.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		if (ConnexionSingleton.connection == null) {
			new ConnexionSingleton();
		}
		return ConnexionSingleton.connection;
	}
}

