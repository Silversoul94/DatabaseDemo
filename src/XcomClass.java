import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class XcomClass {
	private static  Scanner keyboard = new Scanner(System.in);

	final static String PATH= "jdbc:mysql://localhost/XCOM";
	final static String USER="root";
	final static String PASSWORD ="";

	public void showDataOfClass(){
		try(
				Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD);

				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				ResultSet rs = stmt.executeQuery("SELECT * from class" );

				)   

				{   

			while(rs.next())

			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id+"|"+name);

			}

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}
	}
	public void CreateClass() {

		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Class(Name)values(?) ");

				)

				{

			System.out.println("V�lj en Name");
			stmt.setString(1,keyboard.nextLine() );


			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}

	}


	public void UpdateClass() {
		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("update Class set Name=? where id= ? ");

				)

				{

			System.out.println("V�lj en Name");
			stmt.setString(1,keyboard.nextLine() );


			System.out.println("vilken ID ska du �ndra p�");
			stmt.setInt(2,keyboard.nextInt());

			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}


	}
	public void DeleteXcom() {
		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("DELETE FROM Class where id= ? ");

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
