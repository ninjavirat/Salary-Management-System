package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalaryDetails extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel l1, basicsal, hra, da, total,sym1, sym2;
	public static JTextField t1, t2, t3, t4;
    public static JButton btn2, btn3;
    
	public SalaryDetails() {
		
		super("Salary Details");
	    ImageIcon img = new ImageIcon("img/logo.png");
	    Image newImage = img.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	    setIconImage(newImage);
		
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
        
        panel.setLayout(null);
        
		l1 = new JLabel("Salary Details");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        l1.setBounds(300, 20, 250, 50);
        panel.add(l1);

        basicsal = new JLabel("Basic Salary :            ₹");
        basicsal.setFont(new Font("Serif", Font.BOLD, 20));
        basicsal.setForeground(new Color(255, 255, 255));
        basicsal.setBounds(160, 100, 210, 30);
        panel.add(basicsal);


        t1 = new JTextField("");
        t1.setBounds(350, 100, 120, 30);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(t1);

        hra = new JLabel("HRA :");
        hra.setFont(new Font("Serif", Font.BOLD, 20));
        hra.setForeground(new Color(255, 255, 255));
        hra.setBounds(220, 200, 100, 30);
        panel.add(hra);

        t2 = new JTextField("");
        t2.setBounds(350, 200, 120, 30);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(t2);

        sym1 = new JLabel("%");
        sym1.setBounds(475,200,50,30);
        sym1.setForeground(new Color(255, 255, 255));
        sym1.setFont(new Font("Serif",Font.BOLD,15));
        panel.add(sym1);

        da = new JLabel("DA :");
        da.setFont(new Font("Serif", Font.BOLD, 20));
        da.setForeground(new Color(255, 255, 255));
        da.setBounds(230, 300, 100, 30);
        panel.add(da);

        t3 = new JTextField("");
        t3.setBounds(350, 300, 120, 30);
        t3.setHorizontalAlignment(JTextField.CENTER);
        t3.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(t3);

        sym2 = new JLabel("%");
        sym2.setBounds(475,300,50,30);
        sym2.setForeground(new Color(255, 255, 255));
        sym2.setFont(new Font("Serif",Font.BOLD,15));
        panel.add(sym2);

        btn3 = new JButton("Calculate");
        btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn3.setFont(new Font("Serif", Font.BOLD, 15));
        btn3.setBounds(320, 400, 100, 30);
        panel.add(btn3);

        total = new JLabel("Total :            ₹");
        total.setFont(new Font("Serif", Font.BOLD, 20));
        total.setForeground(new Color(255, 255, 255));
        total.setBounds(220, 500, 150, 30);
        panel.add(total);

        t4 = new JTextField("");
        t4.setBounds(350, 500, 120, 30);
        t4.setHorizontalAlignment(JTextField.CENTER);
        t4.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(t4);

        btn2 = new JButton("Save");
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.setForeground(new Color(0, 0, 0));
        btn2.setBackground(new Color(240, 248, 255));
        btn2.setFont(new Font("Serif", Font.BOLD, 15));
        btn2.setBounds(320, 600, 100, 30);
        panel.add(btn2);
        
        add(panel);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
	}
}