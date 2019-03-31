package database;

import java.awt.event.ActionEvent;


import java.sql.*;
import java.util.Arrays;

import javax.swing.JButton;

import gui.ViewYearlyRecord;

public class DAO_2 {
		
	public static Object data[][];
	static int t = 0;
	static int count = 0;


	public static void getEmployee()
	{
		ViewYearlyRecord vr = new ViewYearlyRecord();
		
		Connection conn = DBConnection.getConnection();
		Connection conn1 = DBConnection.getConnection();
		try {

			String insert = "select * from projectDatabase.SalaryRecord";

			PreparedStatement ps = conn.prepareStatement(insert);
			PreparedStatement ps1 = conn1.prepareStatement(insert);

			ResultSet rs1 = ps.executeQuery();
			ResultSet rs2 = ps1.executeQuery();
            while (rs2.next()){
                count++;
            }
			
			while(rs1.next())
			{
					
				String name = rs1.getString("NAME");
				float basicsal = rs1.getFloat("BASIC SALARY");
				float hra = rs1.getFloat("HRA");
				float da = rs1.getFloat("DA");
				int year = rs1.getInt("YEAR");
				String years = Integer.toString(year);
				String month = rs1.getString("MONTH");
				vr.btn1.addActionListener(new java.awt.event.ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						float sal = 0.0f;
						JButton b = (JButton)e.getSource();
						if(b.equals(vr.btn1))
							t++;
						
						if(t == count+1)
						{
							t = 1;
							    for (int i = vr.model.getRowCount() - 1; i > -1; i--) {
							    	vr.model.removeRow(i);
							}
						}
						
						if(((String)vr.cb1.getSelectedItem()).equalsIgnoreCase(name) && ((String)vr.cb3.getSelectedItem()).equalsIgnoreCase(years))
						{
							
							sal = (float) (basicsal + (basicsal * da)/100.00 + (basicsal * hra)/100.00);
							
							Object dat[] = {month, Float.toString(basicsal), Float.toString(hra), Float.toString(da), Float.toString(sal)};
							vr.model.addRow(dat);
						} 
						
					}
			});
		}
			
	} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
