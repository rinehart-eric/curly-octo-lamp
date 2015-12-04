import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class DatabaseBuilder {
	
	public static void createDatabse(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "username", "password");
				System.out.println("Connected to server");
				Statement statement = conn.createStatement();
				try{
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
					System.out.println(e.getMessage());
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
		DatabaseBuilder.createDatabse();
	}
}
