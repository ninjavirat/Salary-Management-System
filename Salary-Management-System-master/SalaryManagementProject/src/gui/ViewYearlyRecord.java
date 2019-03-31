package gui;

import database.DAO_2;
import database.DBConnection;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewYearlyRecord extends JFrame{

    public static JComboBox cb1, cb2, cb3;
    public static JButton btn1, btn2, backButton;
    public static DefaultTableModel model;
    public JTable table;
    JLabel l,name, designation, year;

    public ViewYearlyRecord(){
        super("View Yearly Record");
        ImageIcon img = new ImageIcon("img/logo.png");
        Image newImage = img.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
        setIconImage(newImage);

        JPanel panel = new JPanel(){
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
        
        panel.setLayout(null);

        l = new JLabel("View Record");
        l.setForeground(new Color(255, 255, 255));
        l.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        l.setBounds(320, 20, 250, 50);
        panel.add(l);

        name = new JLabel("Name :");
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(new Color(255, 255, 255));
        name.setBounds(200, 100, 100, 30);
        panel.add(name);

        Connection conn = DBConnection.getConnection();
		ArrayList<String> empname = new ArrayList<String>();
		empname.add("");
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
        cb1 = new JComboBox(employee_name);
        cb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb1.setBounds(300, 100, 200, 30);
        cb1.setForeground(new Color(0, 0, 0));
        cb1.setBackground(new Color(240, 248, 255));
        cb1.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(cb1);

        designation = new JLabel("Designation :");
        designation.setFont(new Font("Serif", Font.BOLD, 20));
        designation.setForeground(new Color(255, 255, 255));
        designation.setBounds(150, 150, 150, 30);
        panel.add(designation);

        //Temporary string array which will be replaced by database
        String designate[] = {"", "Registrar", "Assistant Registrar", "Assistant Professor","Lab Assistant"};
        cb2 = new JComboBox(designate);
        cb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb2.setBounds(300, 150, 200, 30);
        cb2.setForeground(new Color(0, 0, 0));
        cb2.setBackground(new Color(240, 248, 255));
        cb2.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(cb2);

        year = new JLabel("Year :");
        year.setFont(new Font("Serif", Font.BOLD, 20));
        year.setForeground(new Color(255, 255, 255));
        year.setBounds(210, 200, 150, 30);
        panel.add(year);

        String years[]={"","2015","2016","2017","2018","2019","2020","2021","2022"};
        cb3 = new JComboBox(years);
        cb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ((JLabel)cb3.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb3.setBounds(350, 200, 100, 30);
        cb3.setForeground(new Color(0, 0, 0));
        cb3.setBackground(new Color(240, 248, 255));
        cb3.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(cb3);


        btn1 = new JButton("View");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn1.setFont(new Font("Serif", Font.BOLD, 15));
        btn1.setForeground(new Color(0, 0, 0));
        btn1.setBackground(new Color(240, 248, 255));
        btn1.setBounds(150, 260, 70, 30);
        panel.add(btn1);

        btn2 = new JButton("Print");
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.setFont(new Font("Serif", Font.BOLD, 15));
        btn2.setForeground(new Color(0, 0, 0));
        btn2.setBackground(new Color(240, 248, 255));
        btn2.setBounds(350, 260, 70, 30);
        panel.add(btn2);

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                    dispose();
                } catch (PrinterException pe) {
                    System.err.println("Error printing: " + pe.getMessage());
                }
            }
        });

        backButton = new JButton("Back");
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFont(new Font("Serif", Font.BOLD, 15));
        backButton.setForeground(new Color(0, 0, 0));
        backButton.setBackground(new Color(240, 248, 255));
        backButton.setBounds(550, 260, 70, 30);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home h = new home();
                dispose();
            }
        });

        Object columnNames[] = {"MONTH", "BASIC SALARY", "HRA", "DA","TOTAL"};
        DAO_2 dao2 = new DAO_2();

        model = new DefaultTableModel(dao2.data,columnNames);
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<5;x++){
            table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        table.setRowHeight(25);


        JScrollPane scrollPane = new JScrollPane(table){
            @Override
            public void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color2 = new Color(66, 223, 244);
                Color color1 = new Color(66, 244, 188);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }};
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 100, 10, 100));


        add(panel);
        add(scrollPane);
        setLayout(new GridLayout(2,1));
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
