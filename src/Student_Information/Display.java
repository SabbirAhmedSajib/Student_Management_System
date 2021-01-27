package Student_Information;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Display {
	public static Connection dbDisplay() {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//serverhost = localhost, port=3306, username=root, password=123
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sudent_information","root","123");
			Statement smt=cn.createStatement();
			
			//query to display all records from table employee
			String q="Select * from employees";
			
			//to execute query
			ResultSet rs=smt.executeQuery(q);
			
			//to print the resultset on console
			if(rs.next()){ 
				do{
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6));
				}while(rs.next());
			}
			else{
				System.out.println("Record Not Found...");
			}
			cn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

}
