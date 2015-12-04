import java.sql.*;

public class QueryCaller {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/MovieIndustry";
	static final String USERNAME = "root";
	static final String PASSWORD = "CarsBeLemon";
	
	public static void main(String[] args){
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connected to server");
			statement = connection.createStatement();
			String query = "SELECT title, year From Movie";
			ResultSet rs = statement.executeQuery(query);
			String title1 = rs.getString("title");
			int year1 = rs.getInt("year");
			System.out.println(title1 + " " + year1);

			while(rs.next()){
				String title = rs.getString("title");
				int year = rs.getInt("year");
				System.out.println(title + " " + year);
			}
		    rs.close();
		    statement.close();
		    connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(statement != null){
					statement.close();
				}
			}	
			catch(SQLException e){
				e.printStackTrace();
			}
			try{
				if(connection != null){
					connection.close();
				}
			}	
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
