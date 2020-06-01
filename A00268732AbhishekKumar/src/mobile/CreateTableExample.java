package mobile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {

	public void dataconnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("CREATE TABLE MOBILE( ID INTEGER IDENTITY PRIMARY KEY , MOBILENAME varchar(30) NOT NULL, PRICE INTEGER NOT NULL, DESCRIPTION varchar(30) NOT NULL)");
		
      System.out.println("done");
	}

}
