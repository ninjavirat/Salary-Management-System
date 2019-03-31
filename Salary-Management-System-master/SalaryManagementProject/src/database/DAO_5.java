package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO_5 {
		public static int getEmp(String userText, String pwdText) {
			
			int f = 0;
			Connection conn = DBConnection.getConnection();
			try {

				String insert = "select * from projectdatabase.Signup";

				PreparedStatement ps = conn.prepareStatement(insert);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String name = rs.getString("USERNAME");
					String pwd = rs.getString("PASSWORD");

					if (userText.equals(name)) {
						if(pwdText.equals(pwd)) {
							f = 1;
						}
					} 
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
			return f;
		}
}
