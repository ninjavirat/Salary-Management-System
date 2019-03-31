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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import database.DAO_5;

public class EmpLogin extends JFrame{
   
		public EmpLogin() {
        
		        super("Employee Login");
         		ImageIcon img = new ImageIcon("img/logo.png");
         		Image newImage = img.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
         		setIconImage(newImage);

                JLabel login,image, userLabel, passwordLabel;
                JButton loginButton, resetButton, backButton;
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

                cons.gridy = 0;
                image = new JLabel((new ImageIcon(img.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH))));
                gbag.setConstraints(image, cons);
                panel.add(image);

                cons.gridy = 1;
                login = new JLabel("Employee Login");
                login.setForeground(new Color(255, 255, 255));
                login.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
                gbag.setConstraints(login, cons);
                panel.add(login);

                cons.gridy = 2;
                cons.insets = new Insets(0,0,0,250);
                userLabel = new JLabel("Username : ");
                userLabel.setForeground(new Color(255, 255, 255));
                userLabel.setFont(new Font("Serif", Font.BOLD, 23));
                gbag.setConstraints(userLabel, cons);
                panel.add(userLabel);

                cons.ipadx = 250;
                cons.insets = new Insets(0,250,0,0);
                JTextField userTextField = new JTextField();
                userTextField.setFont(new Font("Arial", Font.PLAIN, 17));
                userTextField.setHorizontalAlignment(JTextField.CENTER);
                gbag.setConstraints(userTextField, cons);
                panel.add(userTextField);

                cons.gridy = 3;
                cons.ipadx = 10;
                cons.insets = new Insets(0,0,0,250);
                passwordLabel = new JLabel("Password : ");
                passwordLabel.setForeground(new Color(255, 255, 255));
                passwordLabel.setFont(new Font("Serif", Font.BOLD, 23));
                gbag.setConstraints(passwordLabel, cons);
                panel.add(passwordLabel);

                cons.ipadx = 250;
                cons.insets = new Insets(0,250,0,0);
                JPasswordField passwordField = new JPasswordField();
                passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
                passwordField.setHorizontalAlignment(JPasswordField.CENTER);
                gbag.setConstraints(passwordField, cons);
                panel.add(passwordField);

                cons.gridy = 4;
                cons.ipadx = 10;
                cons.insets = new Insets(0,0,0,0);
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

                        } else {
                            passwordField.setEchoChar('\u25CF');
                        }
                    }
                });

                cons.gridy = 5;
                cons.insets = new Insets(0,0,0,250);
                loginButton = new JButton("Login");
                loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                loginButton.setForeground(new Color(0, 0, 0));
                loginButton.setBackground(new Color(240, 248, 255));
                loginButton.setFont(new Font("Serif", Font.BOLD, 18 ));
                gbag.setConstraints(loginButton, cons);
                panel.add(loginButton);

                loginButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String userText;
                        String pwdText;

                        userText = userTextField.getText();
                        pwdText = passwordField.getText();

                        int f = DAO_5.getEmp(userText, pwdText);
                        
                        
                        if (f == 1) {
                            JOptionPane.showMessageDialog(panel, "Login Successful");
                            HomeEmp h = new HomeEmp();
            					dispose();
                        } else {
                            JOptionPane.showMessageDialog(panel, "Invalid Username or Password");
                        }
                    }
                });

                cons.gridy = 5;
                cons.insets = new Insets(0,250,0,0);
                resetButton = new JButton("Reset");
                resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resetButton.setForeground(new Color(0, 0, 0));
                resetButton.setBackground(new Color(240, 248, 255));
                resetButton.setFont(new Font("Serif", Font.BOLD, 18 ));
                gbag.setConstraints(resetButton, cons);
                panel.add(resetButton);

                resetButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        userTextField.setText("");
                        passwordField.setText("");
                    }
                });

                cons.ipady = 0;
                cons.ipadx = 0;
                cons.gridy = 6;
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
                        Index i = new Index();
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