import java.sql.*;

public class QueryCaller {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/MovieIndustry";
	static final String USERNAME = "root";
	static final String PASSWORD = "CarsBeLemon";
	Connection connection = null;
	Statement statement = null;
	
	public QueryCaller(){
		this.connection = null;
		this.statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connected to server");
			statement = connection.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void queryGame(String searchKey) throws SQLException{
		this.basicQuery("Game", "title", searchKey);
	}
	
	public void queryFranchise(String searchKey) throws SQLException{
		this.basicQuery("Franchise", "name", searchKey);
	}
	
	public void queryPlatform(String searchKey) throws SQLException{
		this.basicQuery("Platform", "platform name", searchKey);
	}
	
	public void queryDeveloper(String searchKey) throws SQLException{
		this.basicQuery("Developer", "developer_name", searchKey);
	}
	
	public void queryPublisher(String searchKey) throws SQLException{
		this.basicQuery("Publisher", "publisher_name", searchKey);
	}
	
	public ResultSet basicQuery(String table, String attribute, String searchKey) throws SQLException{
			String query = "SELECT * from " + table +" WHERE " + attribute + " = " + searchKey;
			return this.statement.executeQuery(query);
	}
	
	public ResultSet advancedQuery(String searchKey) throws SQLException{
		return this.statement.executeQuery(searchKey);
	}
	
	public void closeConnection(){
		try{
			if(this.statement != null){
				this.statement.close();
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
