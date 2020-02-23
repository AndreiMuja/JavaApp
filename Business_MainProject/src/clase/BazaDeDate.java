package clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BazaDeDate {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		Connection con=DriverManager.getConnection("jdbc:sqlite:BazaDate.db");
		Statement st=con.createStatement();
		st.executeUpdate("CREATE TABLE AvionPasageri(serie string, tonaj float, marca string,"
				+ "capacitate float, CNP string)");
		st.executeUpdate("CREATE TABLE AvionCargo(serie string, tonaj float, marca string,"
				+ "capacitate float, SERII string)");
	}
}
