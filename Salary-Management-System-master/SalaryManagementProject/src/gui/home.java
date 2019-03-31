package gui;


import database.DAO_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame{
	private static final long serialVersionUID = 1L;

	public home(){
        super("Salary Management System");
        ImageIcon img = new ImageIcon("img/logo.png");
        Image newImage = img.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
        setIconImage(newImage);

        JPanel panel = new JPanel() {
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

        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();

        cons.fill = GridBagConstraints.CENTER;
        cons.weightx = 0.7;
        cons.weighty = 0.7;
        cons.ipadx = 5;
        cons.ipady = 5;
        cons.gridy = 3;
        cons.gridx = 0;

        JLabel l1,l2;

        JButton b2 = new JButton("View Yearly Record");
        JButton b3 = new JButton("Update Employee Record");
        JButton backButton;

        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setForeground(new Color(0, 0, 0));
        b2.setBackground(new Color(240, 248, 255));
        b2.setFont(new Font("Serif", Font.BOLD, 20));
        gbag.setConstraints(b2, cons);
        panel.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAO_2.getEmployee();
				dispose();
            }
        });

        cons.gridx = 1;
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setForeground(new Color(0, 0, 0));
        b3.setBackground(new Color(240, 248, 255));
        b3.setFont(new Font("Serif", Font.BOLD, 18));
        gbag.setConstraints(b3, cons);
        panel.add(b3);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new UpdateEmpRecord();
               dispose();
            }
        });

        cons.gridx = 0;
        cons.gridwidth = 3;

        cons.gridy = 0;
        l1=new JLabel("Indian  Institute  of  Information  Technology,  Kalyani");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        gbag.setConstraints(l1, cons);
        panel.add(l1);

        cons.gridy = 1;
        ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH));
        JLabel label = new JLabel();
        label.setLabelFor(label);
        label.setIcon(imageIcon);
        gbag.setConstraints(label, cons);
        panel.add(label);

        cons.gridy = 2;
        l2=new JLabel("Welcome Admin!");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 35));
        gbag.setConstraints(l2,cons);
        panel.add(l2);
        
        cons.gridy = 4;
        l2=new JLabel("Salary Management System");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 35));
        gbag.setConstraints(l2,cons);
        panel.add(l2);

        cons.ipady = 0;
        cons.ipadx = 0;
        cons.gridy = 5;
        cons.fill = GridBagConstraints.WEST;
        cons.insets = new Insets(0,0,0,700);
        backButton = new JButton("Back");
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setForeground(new Color(0, 0, 0));
        backButton.setBackground(new Color(240, 248, 255));
        backButton.setFont(new Font("Serif", Font.BOLD, 10 ));
        gbag.setConstraints(backButton, cons);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdmLogin a = new AdmLogin();
                dispose();
            }
        });


        panel.setLayout(gbag);
        add(panel);
        
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
