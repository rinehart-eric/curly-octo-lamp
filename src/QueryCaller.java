import java.sql.*;

public class QueryCaller {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/VideoGames";
	static final String USERNAME = "username";
	static final String PASSWORD = "password";
	Connection connection = null;
	Statement statement = null;
	
	public QueryCaller(){
		this.connection = null;
		this.statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connected to server");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet queryGame(String searchKey) throws SQLException{
		return this.basicQuery("Game", "game_title", searchKey);
	}
	
	public ResultSet queryFranchise(String searchKey) throws SQLException{
		return this.basicQuery("Franchise", "franchise_name", searchKey);
	}
	
	public ResultSet queryPlatform(String searchKey) throws SQLException{
		return this.basicQuery("Platform", "platform_name", searchKey);
	}
	
	public ResultSet queryDeveloper(String searchKey) throws SQLException{
		return this.basicQuery("Developer", "developer_name", searchKey);
	}
	
	public ResultSet queryPublisher(String searchKey) throws SQLException{
		return this.basicQuery("Publisher", "publisher_name", searchKey);
	}
	
	public ResultSet basicQuery(String table, String attribute, String searchKey) throws SQLException{
		statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + attribute + " LIKE ?");
		PreparedStatement ps = (PreparedStatement) statement;
		ps.setString(1, '%' + searchKey + '%');
		return ps.executeQuery();
	}
	
	public ResultSet advancedQuery(String searchKey) throws SQLException{
		statement = connection.createStatement();
		return statement.executeQuery(searchKey);
	}
	
	public void closeConnection(){
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
