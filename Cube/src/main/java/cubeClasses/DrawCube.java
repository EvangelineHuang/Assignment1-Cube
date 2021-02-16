package cubeClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawCube extends JFrame{


	public void cubeGraphics(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(0,0,30,30);
		g2.fillRect(0,0,30,30);
		
	}

	public DrawCube()
	{
		//to  Set JFrame title
		super("Draw a Cube");

		//Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		JButton back = new JButton();
		back.setText("Back");		
		panel.add(back);
		back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             back.setText("Ok Button is clicked here");
	          }});
		JButton forward = new JButton();
		forward.setText("Forward");		
		panel.add(forward);
		
		//Set JFrame size
		setSize(500,500);

		//Make JFrame visible
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);

		//draw rectangle outline
		g.drawRect(200,200,30,30);

		//set color to Green
		g.setColor(Color.RED);

		//fill rectangle with GREEN color
		g.fillRect(200,200,30,30);
		g.drawRect(230,230,30,30);
		g.fillRect(230,230,30,30);
		g.drawRect(230,200,30,30);
		g.fillRect(230,200,30,30);
	}
	

	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		DrawCube cube=new DrawCube();
	}
}