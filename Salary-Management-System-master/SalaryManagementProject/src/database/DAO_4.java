package database;

import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.RemoveEmp;
import gui.SalaryDetails;

public class DAO_4 {
	public void removeEmp(String userTextField, JPanel panel) {

		int f = 0;
		Connection conn = DBConnection.getConnection();
		try {

			String insert = "select * from projectDatabase.SalaryRecord";
			String delete = "DELETE FROM projectDatabase.SalaryRecord WHERE name=?";

			PreparedStatement ps = conn.prepareStatement(insert);
			PreparedStatement ps1 = conn.prepareStatement(delete);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("NAME");

				ps1.setString(1, name);

				if (userTextField.equalsIgnoreCase(name)) {
					Connection con = DBConnection.getConnection();
					try {

						ps1.executeUpdate();
						f = 1;

					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		if(f==1) {
		try {
			
		String insert2 = "select * from projectDatabase.Signup";
		String delete2 = "DELETE FROM projectDatabase.Signup WHERE USERNAME=?";
		
		PreparedStatement ps2 = conn.prepareStatement(insert2);
		PreparedStatement ps3 = conn.prepareStatement(delete2);
		
		ResultSet rs2 = ps2.executeQuery();
		
		while (rs2.next()) {
			String name = rs2.getString("USERNAME");
			ps3.setString(1, name);

			if (userTextField.equalsIgnoreCase(name)) {
				Connection con = DBConnection.getConnection();
				try {

					ps3.executeUpdate();
					f = 2;

				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}

	} catch (Exception e) {

		e.printStackTrace();
	}
		}
		
		
		if(f==2)
		{
			JOptionPane.showMessageDialog(panel, "Successfully deleted the employee from our records");
		}
		else {
			JOptionPane.showMessageDialog(panel, "No employee with entered username in our records!");
		}
	}

}
