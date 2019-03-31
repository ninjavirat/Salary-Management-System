package database;

import gui.GenerateSalary;
import gui.SalaryDetails;
import gui.home;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DAO {

	static int m = 1;

    public static void getEmployee()
    {

        GenerateSalary gs = new GenerateSalary();
        Connection conn = DBConnection.getConnection();
        try {

            String insert = "select * from projectDatabase.SalaryRecord";

            PreparedStatement ps = conn.prepareStatement(insert);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("NAME");
                float basicsal = rs.getFloat("BASIC SALARY");
                float hra = rs.getFloat("HRA");
                float da = rs.getFloat("DA");
                String month = rs.getString("MONTH");
                int year = rs.getInt("YEAR");
                String yr = Integer.toString(year);

                gs.btn1.addActionListener(new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // TODO Auto-generated method stub
                        String yea = (String)gs.cb3.getSelectedItem();
                        int ys = Integer.parseInt(yea);
                        String mont = null;
                        String s = (String)gs.cb4.getSelectedItem();

                        if(s.equalsIgnoreCase("JANUARY"))
                        {
                            if(yea.equalsIgnoreCase("2015"))
                            {
                                gs.t1.setText("0");
                                gs.t2.setText("0");
                                gs.t3.setText("0");
                                gs.t4.setText("0");
                            }
                            else
                            {
                                mont = "DECEMBER";
                                ys = ys - 1;
                                yea = Integer.toString(ys);
                            }
                        }
                        if(s.equalsIgnoreCase("FEBRUARY"))
                        {
                            mont = "JANUARY";
                        }
                        if(s.equalsIgnoreCase("MARCH"))
                        {
                            mont = "FEBRUARY";
                        }
                        if(s.equalsIgnoreCase("APRIL"))
                        {
                            mont = "MARCH";
                        }
                        if(s.equalsIgnoreCase("MAY"))
                        {
                            mont = "APRIL";
                        }
                        if(s.equalsIgnoreCase("JUNE"))
                        {
                            mont = "MAY";
                        }
                        if(s.equalsIgnoreCase("JULY"))
                        {
                            mont = "JUNE";
                        }
                        if(s.equalsIgnoreCase("AUGUST"))
                        {
                            mont = "JULY";
                        }
                        if(s.equalsIgnoreCase("SEPTEMBER"))
                        {
                            mont = "AUGUST";
                        }
                        if(s.equalsIgnoreCase("OCTOBER"))
                        {
                            mont = "SEPTEMBER";
                        }
                        if(s.equalsIgnoreCase("NOVEMBER"))
                        {
                            mont = "OCTOBER";
                        }
                        if(s.equalsIgnoreCase("DECEMBER"))
                        {
                            mont = "NOVEMBER";
                        }

                        if(((String)gs.cb1.getSelectedItem()).equalsIgnoreCase(name) && (month).equalsIgnoreCase(mont) && (yr).equalsIgnoreCase(yea))
                        {
                        	   m = 0;
                        	   SalaryDetails details = new SalaryDetails();
                        	    
                            details.t1.setText(Float.toString(basicsal));
                            details.t2.setText(Float.toString(hra));
                            details.t3.setText(Float.toString(da));
                            float sal = (float) (basicsal + (basicsal * da)/100.00 + (basicsal * hra)/100.00);
                            details.t4.setText(Float.toString(sal));
                            
                            details.btn3.addActionListener(new java.awt.event.ActionListener(){
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    float bs,hra,da,total;
                                    bs = Float.parseFloat(details.t1.getText());
                                    hra = Float.parseFloat(details.t2.getText());
                                    da = Float.parseFloat(details.t3.getText());
                                    total = (float)(bs + (bs * da) / 100.0 + (bs * hra) / 100.0);
                                    details.t4.setText(Float.toString(total));
                                    gs.dispose();
                                }
                            });

                            details.btn2.addActionListener(new java.awt.event.ActionListener() {
                            		
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // TODO Auto-generated method stub

                                	
                                    float basal = Float.parseFloat(details.t1.getText());
                                    float ha = Float.parseFloat(details.t2.getText());
                                    float d = Float.parseFloat(details.t3.getText());

                                    Connection con1 = DBConnection.getConnection();
                                    try {
                                        String insert = "INSERT INTO projectDatabase.SalaryRecord VALUES(?,?,?,?,?,?,?,NULL)";

                                        PreparedStatement ps1 = con1.prepareStatement(insert);

                                        ps1.setString(1, (String)gs.cb1.getSelectedItem());
                                        ps1.setFloat(2, basal);
                                        ps1.setFloat(3, ha);
                                        ps1.setFloat(4, d);
                                        ps1.setString(5, (String)gs.cb4.getSelectedItem());
                                        ps1.setInt(6, Integer.parseInt((String) gs.cb3.getSelectedItem()));
                                        ps1.setFloat(7, sal);

                                        ps1.executeUpdate();
                                        

                                		JPanel panel = new JPanel()
                                        {
                                            @Override
                                            public void paintComponent(Graphics grphcs) {
                                                super.paintComponent(grphcs);
                                                Graphics2D g2d = (Graphics2D) grphcs;
                                                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                                int w = getWidth();
                                                int h = getHeight();
                                                Color color1 = new Color(66, 223, 244);
                                                Color color2 = new Color(66, 244, 188);
                                                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                                                g2d.setPaint(gp);
                                                g2d.fillRect(0, 0, w, h);
                                            }
                                        };
                                        
                                        JOptionPane.showMessageDialog(panel, "Successfully Saved!");
                                        home h = new home();
                                        details.dispose();

                                    } catch (Exception e1) {

                                        e1.printStackTrace();
                                    }
                                	}
                            });
                        }
                        else if(m == 1)
                        {
                        m++;
                        	SalaryDetails details = new SalaryDetails();
                    	    
                            details.t1.setText(Float.toString(0.0f));
                            details.t2.setText(Float.toString(0.0f));
                            details.t3.setText(Float.toString(0.0f));
                            float sal = (float) (0.0f);
                            details.t4.setText(Float.toString(sal));
                            
                            details.btn3.addActionListener(new java.awt.event.ActionListener(){
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    float bs,hra,da,total;
                                    bs = Float.parseFloat(details.t1.getText());
                                    hra = Float.parseFloat(details.t2.getText());
                                    da = Float.parseFloat(details.t3.getText());
                                    total = (float)(bs + (bs * da) / 100.0 + (bs * hra) / 100.0);
                                    details.t4.setText(Float.toString(total));
                                    gs.dispose();
                                }
                            });

                            details.btn2.addActionListener(new java.awt.event.ActionListener() {
                            		
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // TODO Auto-generated method stub

                                	
                                    float basal = Float.parseFloat(details.t1.getText());
                                    float ha = Float.parseFloat(details.t2.getText());
                                    float d = Float.parseFloat(details.t3.getText());

                                    Connection con1 = DBConnection.getConnection();
                                    try {
                                        String insert = "INSERT INTO projectDatabase.SalaryRecord VALUES(?,?,?,?,?,?,?,NULL)";

                                        PreparedStatement ps1 = con1.prepareStatement(insert);

                                        ps1.setString(1, (String)gs.cb1.getSelectedItem());
                                        ps1.setFloat(2, basal);
                                        ps1.setFloat(3, ha);
                                        ps1.setFloat(4, d);
                                        ps1.setString(5, (String)gs.cb4.getSelectedItem());
                                        ps1.setInt(6, Integer.parseInt((String) gs.cb3.getSelectedItem()));
                                        ps1.setFloat(7, sal);

                                        ps1.executeUpdate();
                                        

                                		JPanel panel = new JPanel()
                                        {
                                            @Override
                                            public void paintComponent(Graphics grphcs) {
                                                super.paintComponent(grphcs);
                                                Graphics2D g2d = (Graphics2D) grphcs;
                                                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                                                int w = getWidth();
                                                int h = getHeight();
                                                Color color1 = new Color(66, 223, 244);
                                                Color color2 = new Color(66, 244, 188);
                                                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                                                g2d.setPaint(gp);
                                                g2d.fillRect(0, 0, w, h);
                                            }
                                        };
                                        
                                        JOptionPane.showMessageDialog(panel, "Successfully Saved!");
                                        home h = new home();
                                        details.dispose();

                                    } catch (Exception e1) {

                                        e1.printStackTrace();
                                    }
                                	}
                            });
                        }
                    }
                });

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}