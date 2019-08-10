package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties properties = properties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				throw new DbExcecao(e.getMessage());
			}

		}

		return connection;
	}

	public static void fecharConexao() {
		if (connection == null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DbExcecao(e.getMessage());

			}

		}

	}

	public static Properties properties() {
		try {
			FileInputStream file = new FileInputStream("db.propriedades");
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (IOException e) {
			throw new DbExcecao(e.getMessage());
		}
	}
}
