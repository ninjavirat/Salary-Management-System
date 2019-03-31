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
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import database.DAO;
import database.DAO_2;

public class Index extends JFrame{

    public Index(){
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        JFrame frame = new JFrame("Salary Management System Login");
        ImageIcon img = new ImageIcon("img/logo.png");
        Image newImage = img.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
        frame.setIconImage(newImage);
        
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

        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();

        cons.fill = GridBagConstraints.CENTER;
        cons.weightx = 0.7;
        cons.weighty = 0.7;
        cons.ipadx = 5;
        cons.ipady = 5;
        cons.gridy = 2;
        cons.gridx = 0;

        JLabel l1,l2;

        JButton b1 = new JButton("Admin Login");
        JButton b2 = new JButton("Employee Login");

        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setForeground(new Color(0, 0, 0));
        b1.setBackground(new Color(240, 248, 255));
        b1.setFont(new Font("Serif", Font.BOLD, 20));
        gbag.setConstraints(b1, cons);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdmLogin log = new AdmLogin();
				frame.dispose();
            }
        });

        cons.gridx = 1;
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setForeground(new Color(0, 0, 0));
        b2.setBackground(new Color(240, 248, 255));
        b2.setFont(new Font("Serif", Font.BOLD, 20));
        gbag.setConstraints(b2, cons);
        panel.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmpLogin empLog = new EmpLogin();
                frame.dispose();
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

        cons.gridy=3;
        l2=new JLabel("Salary Management System");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 35));
        gbag.setConstraints(l2,cons);
        panel.add(l2);

        panel.setLayout(gbag);
        frame.add(panel);
        
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
    	   });
    }

    public static void main(String args[]){
        Index i = new Index();
    }
}