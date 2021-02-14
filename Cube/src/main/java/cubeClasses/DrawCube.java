package cubeClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JFrame;

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
		super("Draw A Rectangle In JFrame");

		//Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set JFrame size
		setSize(500,500);

		//Make JFrame visible
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		//draw rectangle outline
		g.drawRect(50,50,30,30);

		//set color to Green
		g.setColor(Color.GREEN);

		//fill rectangle with GREEN color
		g.fillRect(50,50,30,30);
	}

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("My Drawing");
		@SuppressWarnings("unused")
		DrawCube cube=new DrawCube();
		frame.setVisible(true);
	}
}