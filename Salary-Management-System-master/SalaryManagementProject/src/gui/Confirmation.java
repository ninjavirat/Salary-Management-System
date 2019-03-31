package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DAO_4;

public class Confirmation extends JFrame{
	public Confirmation(String username) {
		super("Confirmation Dialog");

		RemoveEmp rem = new RemoveEmp();
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.CENTER;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		cons.gridx = 0;
		cons.gridy = 0;
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

		JLabel msg1 = new JLabel("Are you sure you want to");
		msg1.setForeground(new Color(255, 255, 255));
		msg1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		gbag.setConstraints(msg1, cons);
		panel.add(msg1);

		cons.gridy = 1;
		JLabel msg2 = new JLabel("remove the selected employee?");
		msg2.setForeground(new Color(255, 255, 255));
		msg2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		gbag.setConstraints(msg2, cons);
		panel.add(msg2);

		cons.gridy = 2;
		cons.fill = GridBagConstraints.SOUTH;
		cons.insets = new Insets(0, 0, 0, 150);
		JButton yesButton = new JButton("YES");
		yesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yesButton.setForeground(new Color(0, 0, 0));
		yesButton.setBackground(new Color(240, 248, 255));
		yesButton.setFont(new Font("Serif", Font.BOLD, 18));
		gbag.setConstraints(yesButton, cons);
		panel.add(yesButton);

		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO_4 dao = new DAO_4();
				dao.removeEmp(username,panel);
			
				UpdateEmpRecord uer = new UpdateEmpRecord();
				dispose();
				rem.dispose();
			}
		});

		cons.insets = new Insets(0, 150, 0, 0);
		JButton noButton = new JButton("NO");
		noButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		noButton.setForeground(new Color(0, 0, 0));
		noButton.setBackground(new Color(240, 248, 255));
		noButton.setFont(new Font("Serif", Font.BOLD, 18));
		gbag.setConstraints(noButton, cons);
		panel.add(noButton);

		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmpRecord uer = new UpdateEmpRecord();
				dispose();
			}
		});

		panel.setLayout(gbag);
		add(panel);

		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
