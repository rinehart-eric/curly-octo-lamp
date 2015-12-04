import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class DatabaseBuilder {
	
	public static void createDatabse() throws IOException, SQLException{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "username", "password");
				System.out.println("Conneced to server");
				Statement statement = conn.createStatement();
				try{
					statement.executeUpdate("CREATE DATABASE VideoGames");
					conn.setCatalog("VideoGames");
					statement = conn.createStatement();
					File file = new File("database.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					while((line = br.readLine()) != null){
						statement.executeUpdate(line);
					}
					br.close();
				}
				catch(SQLException e){
					System.out.println("Database already exists");
				}
			}
			catch (ClassNotFoundException e ) {
				e.printStackTrace();
			}
			catch (IOException e){
				System.out.println("There was an IO error");
			}
			catch (SQLException e){
				e.printStackTrace();
				System.out.println("There was an SQL error");
			}
	}
	
	public static void main(String[] args){
		try{
			DatabaseBuilder.createDatabse();
		}
		catch(SQLException | IOException e){
			e.printStackTrace();
		}
	}
}
