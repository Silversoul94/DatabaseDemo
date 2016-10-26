import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Xcom {
	private static  Scanner keyboard = new Scanner(System.in);

	final static String PATH= "jdbc:mysql://localhost/Xcom";
	final static String USER="root";
	final static String PASSWORD ="";
	
	

	public void showDataOfXcom(){
		try(
				Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD);

				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				ResultSet rs = stmt.executeQuery("SELECT * from XCOM" );

				)   

				{   
			while(rs.next())
			{
				int id = rs.getInt("id");
				String rank = rs.getString("Rank");
				String fname = rs.getString("Fname");
				String lname =rs.getString("Lname");
				String type = rs.getString("type");

				System.out.println(id+"|"+rank+"|"+fname+"|"+lname+"|"+type);

			}

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}
	}
	public void CreateXcom() {

		try

		(
				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("INSERT INTO xcom(Rank,Fname,Lname,Type)values(?,?,?,?) ");

				)

				{
			System.out.println("Välj en Rank");
			stmt.setString(1,keyboard.nextLine() );

			System.out.println("Välj en Fname");
			stmt.setString(2,keyboard.nextLine() );

			System.out.println("Välj en Lname");
			stmt.setString(3,keyboard.nextLine() );

			System.out.println("Välj en Type mellan 1,2,3,4");
			stmt.setInt(5,keyboard.nextInt());

			stmt.executeUpdate();

				}

		catch (SQLException e)

		{

			System.out.println(e.getMessage());

		}


	}

	public void UpdateXcom() {

		try

		(

				Connection conn = DriverManager.getConnection(PATH,USER,PASSWORD);

				PreparedStatement stmt = conn.prepareStatement("update xcom set Rank=?,Fname=?,Lname=?,Type=? where id= ? ");

				)

				{

			System.out.println("Välj en Rank");
			stmt.setString(1,keyboard.nextLine() );

			System.out.println("Välj en Fname");
			stmt.setString(2,keyboard.nextLine() );

			System.out.println("Välj en Lname");
			stmt.setString(3,keyboard.nextLine() );

			System.out.println("Välj en Type");
			stmt.setInt(4,keyboard.nextInt());

			System.out.println("vilken ID ska du ändra på");
			stmt.setInt(5,keyboard.nextInt());

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

				PreparedStatement stmt = conn.prepareStatement("DELETE FROM xcom where id= ? ");

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