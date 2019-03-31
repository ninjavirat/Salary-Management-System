package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class DAO_3 {
	public static void setCredentials(String username, String password) {

		String mname = "";
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);

		Connection con1 = DBConnection.getConnection();
		try {

			String insert = "INSERT INTO projectDatabase.SignUp VALUES(?,?,NULL)";
			String insert2 = "INSERT INTO projectDatabase.SalaryRecord VALUES(?,?,?,?,?,?,?,NULL)";

			PreparedStatement ps1 = con1.prepareStatement(insert);

			ps1.setString(1, username);
			ps1.setString(2, password);

			ps1.executeUpdate();

			PreparedStatement ps2 = con1.prepareStatement(insert2);

			switch (month) {
			case 1:
				mname = "JANUARY";
				break;
			case 2:
				mname = "FEBRUARY";
				break;
			case 3:
				mname = "MARCH";
				break;
			case 4:
				mname = "APRIL";
				break;
			case 5:
				mname = "MAY";
				break;
			case 6:
				mname = "JUNE";
				break;
			case 7:
				mname = "JULY";
				break;
			case 8:
				mname = "AUGUST";
				break;
			case 9:
				mname = "SEPTEMBER";
				break;
			case 10:
				mname = "OCTOBER";
				break;
			case 11:
				mname = "NOVEMBER";
				break;
			case 12:
				mname = "DECEMBER";
				break;
			}
			ps2.setString(1, username);
			ps2.setFloat(2, 0.0f);
			ps2.setFloat(3, 0.0f);
			ps2.setFloat(4, 0.0f);
			ps2.setString(5, mname);
			ps2.setInt(6, year);
			ps2.setFloat(7, 0.0f);

			ps2.executeUpdate();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}
}