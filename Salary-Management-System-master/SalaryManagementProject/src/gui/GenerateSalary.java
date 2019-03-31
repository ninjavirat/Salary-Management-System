package gui;

import javax.swing.*;

import database.DBConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GenerateSalary extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l, l1, name, designation, month, year, basicsal, hra, da, total,sym1, sym2;
    public static JTextField t1, t2, t3, t4;
    public static JComboBox<?> cb1, cb2, cb3,cb4;
    public JButton btn1, btn2, btn3;
    //public static JSpinner months;

    public GenerateSalary() {
        super("Generate Current Employee Salary");
        ImageIcon img = new ImageIcon("img/logo.png");
        Image newImage = img.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
        setIconImage(newImage);
        
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();

        cons.fill = GridBagConstraints.CENTER;
        cons.weightx = 0.5;
        cons.weighty = 0.5;
        cons.gridx = 0;
        cons.gridwidth = 2;
        cons.ipady = 10;
        cons.ipadx = 10;

        JPanel panel = new JPanel()
        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
        
        cons.gridy = 1;
        l = new JLabel("Generate Current Employee Salary");
        l.setForeground(new Color(255, 255, 255));
        l.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        gbag.setConstraints(l, cons);
        panel.add(l);

        cons.gridy = 2;
        cons.insets = new Insets(0,0,0,250);
        name = new JLabel("Name:");
        name.setFont(new Font("Serif", Font.BOLD, 18));
        name.setForeground(new Color(255, 255, 255));
        gbag.setConstraints(name, cons);
        panel.add(name);

        //Temporary string array which will be replaced by database
        cons.ipadx = 50;
        cons.insets = new Insets(0,150,0,0);
		Connection conn = DBConnection.getConnection();
		ArrayList<String> empname = new ArrayList<String>();
		empname.add("       ");
		int c= 0;
		try {

			String insert = "select * from projectDatabase.Signup";

			PreparedStatement ps = conn.prepareStatement(insert);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("Username");
				empname.add(name);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		String employee_name[] = new String[empname.size()];
		empname.toArray(employee_name);
        cb1 = new JComboBox<Object>(employee_name);
        cb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb1.setForeground(new Color(0, 0, 0));
        cb1.setBackground(new Color(240, 248, 255));
        cb1.setFont(new Font("Serif", Font.PLAIN, 15));
        gbag.setConstraints(cb1, cons);
        panel.add(cb1);

        cons.gridy = 3;
        cons.ipadx = 10;
        cons.insets = new Insets(0,0,0,250);
        designation = new JLabel("Designation :");
        designation.setFont(new Font("Serif", Font.BOLD, 18));
        designation.setForeground(new Color(255, 255, 255));
        gbag.setConstraints(designation, cons);
        panel.add(designation);

        //Temporary string array which will be replaced by database
        cons.ipadx = 50;
        cons.insets = new Insets(0,150,0,0);
        String designate[] = {"", "Registrar", "Assistant Registrar", "Assistant Professor","Lab Assistant"};
        cb2 = new JComboBox<Object>(designate);
        cb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb2.setForeground(new Color(0, 0, 0));
        cb2.setBackground(new Color(240, 248, 255));
        cb2.setFont(new Font("Serif", Font.PLAIN, 15));
        gbag.setConstraints(cb2, cons);
        panel.add(cb2);

        cons.gridy = 4;
        cons.ipadx = 10;
        cons.insets = new Insets(0, 0, 0, 250);
        month = new JLabel("Month :");
        month.setFont(new Font("Serif", Font.BOLD, 18));
        month.setForeground(new Color(255, 255, 255));
        gbag.setConstraints(month, cons);
        panel.add(month);

        cons.ipadx = 50;
        cons.insets = new Insets(0,90,0,0);
        String months[] = {"","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        cb4 = new JComboBox<Object>(months);
        cb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb4.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb4.setForeground(new Color(0, 0, 0));
        cb4.setBackground(new Color(240, 248, 255));
        cb4.setFont(new Font("Serif", Font.PLAIN, 10));
        gbag.setConstraints(cb4, cons);
        panel.add(cb4);

        cons.gridy = 5;
        cons.ipadx = 10;
        cons.insets = new Insets(0, 0, 0, 250);
        year = new JLabel("Year :");
        year.setFont(new Font("Serif", Font.BOLD, 18));
        year.setForeground(new Color(255, 255, 255));
        gbag.setConstraints(year, cons);
        panel.add(year);

        cons.ipadx = 10;
        cons.insets = new Insets(0,30,0,0);
        String years[] = {"", "2015", "2016", "2017", "2018","2019","2020","2021","2022"};
        cb3 = new JComboBox<Object>(years);
        cb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb3.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb3.setForeground(new Color(0, 0, 0));
        cb3.setBackground(new Color(240, 248, 255));
        cb3.setFont(new Font("Serif", Font.PLAIN, 15));
        gbag.setConstraints(cb3, cons);
        panel.add(cb3);

        cons.gridy = 6;
        cons.ipadx = 10;
        cons.insets = new Insets(0, 40, 0, 0);
        btn1 = new JButton("Generate");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn1.setFont(new Font("Serif", Font.BOLD, 15));
        btn1.setForeground(new Color(0, 0, 0));
        btn1.setBackground(new Color(240, 248, 255));
        gbag.setConstraints(btn1, cons);
        panel.add(btn1);

        panel.setLayout(gbag);
        add(panel);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}