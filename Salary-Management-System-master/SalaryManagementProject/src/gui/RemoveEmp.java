package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveEmp extends JFrame {
	public RemoveEmp() {

		super("Remove Employee");
		ImageIcon img = new ImageIcon("img/logo.png");
		Image newImage = img.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		setIconImage(newImage);

		JLabel login, userLabel;
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.CENTER;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		cons.gridx = 0;
		cons.gridwidth = 2;
		cons.ipady = 10;
		cons.ipadx = 10;

		JPanel panel = new JPanel() {
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
		login = new JLabel("Remove Employee");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		gbag.setConstraints(login, cons);
		panel.add(login);

		cons.gridy = 2;
		cons.insets = new Insets(0, 0, 0, 300);
		userLabel = new JLabel("Username : ");
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setFont(new Font("Serif", Font.BOLD, 23));
		gbag.setConstraints(userLabel, cons);
		panel.add(userLabel);

		cons.ipadx = 250;
		cons.insets = new Insets(0, 300, 0, 0);
		JTextField userTextField = new JTextField();
		userTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		userTextField.setHorizontalAlignment(JTextField.CENTER);
		gbag.setConstraints(userTextField, cons);
		panel.add(userTextField);
		
		cons.gridy = 3;
        cons.ipadx = 10;
        cons.insets = new Insets(0,0,0,20);
        JButton confirm = new JButton("Confirm");
        confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirm.setForeground(new Color(0, 0, 0));
        confirm.setBackground(new Color(240, 248, 255));
        confirm.setFont(new Font("Serif", Font.BOLD, 18 ));
        gbag.setConstraints(confirm, cons);
        panel.add(confirm);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            			String username = userTextField.getText();
            			Confirmation conf = new Confirmation(username);
            		    dispose();
            		}
            });

        cons.gridx = 0;
        cons.gridwidth = 3;
        cons.gridy = 4;
        JLabel l2 = new JLabel("Salary Management System");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 35));
        gbag.setConstraints(l2,cons);
        panel.add(l2);
        
		panel.setLayout(gbag);
		add(panel);

		setSize(800, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
