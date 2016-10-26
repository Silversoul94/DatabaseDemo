import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Items {
	private static  Scanner keyboard = new Scanner(System.in);

	final static String PATH= "jdbc:mysql://localhost/Xcom";
	final static String USER="root";
	final static String PASSWORD ="";

	public void showDataOfItems(){
		try(
				Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD);

				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				ResultSet rs = stmt.executeQuery("SELECT * from items" );

				)   

				{   

			while(rs.next())

			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String owner = rs.getString("owner");
				System.out.println("id|name|owner");
				System.out.println(id+"|"+name+"|"+owner);

			}

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}
	}
	public void CreateItems() {

		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Items(Name,Owner)values(?,?) ");

				)

				{

			System.out.println("Välj en Name");
			stmt.setString(1,keyboard.nextLine() );

			System.out.println("Välj hur många owner");
			stmt.setInt(2,keyboard.nextInt() );


			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}


	}


	public void UpdateItems() {
		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("update Items set Name=?,owner=? where id= ? ");

				)

				{

			System.out.println("Välj en Name");
			stmt.setString(1,keyboard.nextLine() );


			System.out.println("Välj hur många ägare");
			stmt.setInt(2,keyboard.nextInt());

			System.out.println("vilken ID ska du ändra på");
			stmt.setInt(3,keyboard.nextInt());

			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}

	}
	public void DeleteItems() {
		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("DELETE FROM Items where id= ? ");

				)

				{

			System.out.println("vart vill du ta bort");
			stmt.setInt(1,keyboard.nextInt());

			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}


	}
}
