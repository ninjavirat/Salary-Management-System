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
import java.util.Properties;

/*
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import database.DAO_3;

public class AddEmp extends JFrame {
	public AddEmp() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Add Employee");
				ImageIcon img = new ImageIcon("img/logo.png");
				Image newImage = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				frame.setIconImage(newImage);

				JLabel image, userLabel, passwordLabel;
				JLabel confirmPasswordLabel;
				JButton signupbutton, resetButton;
				JLabel signup;
				JCheckBox showPassword;

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

				cons.gridy = 0;
				image = new JLabel((new ImageIcon(img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH))));
				gbag.setConstraints(image, cons);
				panel.add(image);

				cons.gridy = 1;
				signup = new JLabel("Add Employee");
				signup.setForeground(new Color(255, 255, 255));
				signup.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
				gbag.setConstraints(signup, cons);
				panel.add(signup);

				cons.gridy = 2;
				cons.insets = new Insets(0, 0, 0, 250);
				userLabel = new JLabel("Username : ");
				userLabel.setForeground(new Color(255, 255, 255));
				userLabel.setFont(new Font("Serif", Font.BOLD, 23));
				gbag.setConstraints(userLabel, cons);
				panel.add(userLabel);

				cons.ipadx = 250;
				cons.insets = new Insets(0, 250, 0, 0);
				JTextField userTextField = new JTextField();
				userTextField.setFont(new Font("Arial", Font.PLAIN, 17));
				userTextField.setHorizontalAlignment(JTextField.CENTER);
				gbag.setConstraints(userTextField, cons);
				panel.add(userTextField);

				cons.gridy = 3;
				cons.ipadx = 10;
				cons.insets = new Insets(0, 0, 0, 250);
				JLabel emailLabel = new JLabel("email : ");
				emailLabel.setForeground(new Color(255, 255, 255));
				emailLabel.setFont(new Font("Serif", Font.BOLD, 23));
				gbag.setConstraints(emailLabel, cons);
				panel.add(emailLabel);

				cons.ipadx = 250;
				cons.insets = new Insets(0, 250, 0, 0);
				JTextField emailTextField = new JTextField();
				emailTextField.setFont(new Font("Arial", Font.PLAIN, 17));
				emailTextField.setHorizontalAlignment(JTextField.CENTER);
				gbag.setConstraints(emailTextField, cons);
				panel.add(emailTextField);

				cons.gridy = 4;
				cons.ipadx = 10;
				cons.insets = new Insets(0, 0, 0, 250);
				passwordLabel = new JLabel("Password : ");
				passwordLabel.setForeground(new Color(255, 255, 255));
				passwordLabel.setFont(new Font("Serif", Font.BOLD, 23));
				gbag.setConstraints(passwordLabel, cons);
				panel.add(passwordLabel);

				cons.ipadx = 250;
				cons.insets = new Insets(0, 250, 0, 0);
				JPasswordField passwordField = new JPasswordField();
				passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
				passwordField.setHorizontalAlignment(JPasswordField.CENTER);
				gbag.setConstraints(passwordField, cons);
				panel.add(passwordField);

				cons.gridy = 5;
				cons.ipadx = 10;
				cons.insets = new Insets(0, 0, 0, 250);
				confirmPasswordLabel = new JLabel("Confirm Password : ");
				confirmPasswordLabel.setForeground(new Color(255, 255, 255));
				confirmPasswordLabel.setFont(new Font("Serif", Font.BOLD, 23));
				gbag.setConstraints(confirmPasswordLabel, cons);
				panel.add(confirmPasswordLabel);

				cons.ipadx = 250;
				cons.insets = new Insets(0, 250, 0, 0);
				JPasswordField confirmPasswordField = new JPasswordField();
				confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 17));
				confirmPasswordField.setHorizontalAlignment(JPasswordField.CENTER);
				gbag.setConstraints(confirmPasswordField, cons);
				panel.add(confirmPasswordField);

				cons.gridy = 6;
				cons.ipadx = 10;
				cons.insets = new Insets(0, 0, 0, 0);
				showPassword = new JCheckBox("Show Password");
				showPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				showPassword.setBackground(new Color(66, 235, 205));
				showPassword.setForeground(new Color(255, 255, 255));
				showPassword.setFont(new Font("Serif", Font.PLAIN, 17));
				gbag.setConstraints(showPassword, cons);
				panel.add(showPassword);

				showPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (showPassword.isSelected()) {
							passwordField.setEchoChar((char) 0);
							confirmPasswordField.setEchoChar((char) 0);
						} else {
							passwordField.setEchoChar('\u25CF');
							confirmPasswordField.setEchoChar('\u25CF');
						}
					}
				});

				cons.gridy = 7;
				cons.ipadx = 10;
				cons.insets = new Insets(0, 0, 0, 250);
				signupbutton = new JButton("Confirm");
				signupbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				signupbutton.setForeground(new Color(0, 0, 0));
				signupbutton.setBackground(new Color(240, 248, 255));
				signupbutton.setFont(new Font("Serif", Font.BOLD, 18));
				gbag.setConstraints(signupbutton, cons);
				panel.add(signupbutton);

				signupbutton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						String confPwdText;
						String pwdText;
						String username = userTextField.getText();

						confPwdText = confirmPasswordField.getText();
						pwdText = passwordField.getText();

						if (confPwdText.equalsIgnoreCase(pwdText)) {
							JOptionPane.showMessageDialog(panel,
									"Successfully Signed Up!");
							UpdateEmpRecord uer = new UpdateEmpRecord();
							DAO_3.setCredentials(username, pwdText);

						} else {
							JOptionPane.showMessageDialog(panel, "Passwords do not match!");
						}
					}
				});

				cons.gridy = 7;
				cons.insets = new Insets(0, 250, 0, 0);
				resetButton = new JButton("Reset");
				resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				resetButton.setForeground(new Color(0, 0, 0));
				resetButton.setBackground(new Color(240, 248, 255));
				resetButton.setFont(new Font("Serif", Font.BOLD, 18));
				gbag.setConstraints(resetButton, cons);
				panel.add(resetButton);

				resetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						userTextField.setText("");
						passwordField.setText("");
						confirmPasswordField.setText("");
						emailTextField.setText("");
					}
				});

				panel.setLayout(gbag);
				frame.add(panel);

				frame.setSize(800, 700);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
