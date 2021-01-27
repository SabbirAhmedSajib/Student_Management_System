package Student_Information;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connect {
	Connection con = null;
	public static Connection dbConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/student_information?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			
			return con;
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(null,E);
			return null;
		}
	}
}




