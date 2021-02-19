package cubeClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//This is the GUI of the Cube. Every time a button get clicked on, the unfolded 
//cube will display how a real cube is rotated.
//When the cube is rotated, all the squares will be repainted.
@SuppressWarnings("serial")
public class GUI extends JFrame{

	static Color color = Color.red;// This is just used for test. 
	Cube cube = new Cube();//The cube that will be painted 
	//button listener will be added in the next turn in
	/*GUI: the constructor, creates the cube as well as the buttons necessary to manipulate it
	 */
	public GUI()
	{
		//to set title
		super("Draw a Cube");
		JPanel p = new JPanel();
		//set close button operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(p);
		//create back button for rotating
		JButton back = new JButton();
		back.setText("Back");		
		p.add(back);
		//button action listener, will repaint the cube
		back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  //panel.removeAll();
	        	  color = Color.green;
	        	  repaint();
	        	  //addButton();
	          }});
		//create forward button
		JButton forward = new JButton();
		forward.setText("Forward");		
		p.add(forward);
		forward.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  //panel.removeAll();
	        	  color = Color.decode("#FF5733");
	        	  repaint();
	        	  //addButton();
	          }});
		//create up button
		//create down button
		//create left button
		//create right button
		//there will be two extra buttons called clockwise and counterclockwise
		//which will be visible after one of the six side buttons is clicked. 
		//set size
		setSize(500,500);

		//make visible
		setVisible(true);
	}
	//this is the method that is used to paint the cube, it is inherited from JFrame
	//g: object of JFrame used to draw the square
	public void paint(Graphics g)
	{
		//this method will go through all the squares of a cube use the color attribute 
		//and xPos, yPos attribute to draw squares. 
		super.paint(g);
		for(int i = 0; i<6;i++)
		{	
			
			Face f =cube.Faces[i];
			g.setColor(Color.BLACK);
			g.drawRect(f.getSquares()[0][0].getxPos(), f.getSquares()[0][0].getyPos(), 30, 30);
			g.drawRect(f.getSquares()[1][1].getxPos(), f.getSquares()[1][1].getyPos(), 30, 30);
			g.drawRect(f.getSquares()[0][1].getxPos(), f.getSquares()[0][1].getyPos(), 30, 30);
			g.drawRect(f.getSquares()[1][0].getxPos(), f.getSquares()[1][0].getyPos(), 30, 30);
			g.setColor(Color.decode(f.getSquares()[0][0].getColor()));
			g.fillRect(f.getSquares()[0][0].getxPos(), f.getSquares()[0][0].getyPos(), 30, 30);
			g.fillRect(f.getSquares()[1][1].getxPos(), f.getSquares()[1][1].getyPos(), 30, 30);
			g.fillRect(f.getSquares()[0][1].getxPos(), f.getSquares()[0][1].getyPos(), 30, 30);
			g.fillRect(f.getSquares()[1][0].getxPos(), f.getSquares()[1][0].getyPos(), 30, 30);
			
		}
	    
	}
	//this is the update, every time a button is clicked, the GUI will be updated using 
	//this method. it is inherited from JFrame, it is the same as paint();
	//g: object of JFrame used to draw the square
	public void update(Graphics g) 
	{
		super.update(g);
	}
	@SuppressWarnings("unused")
	//main function that will run to start setting up the GUI
	public static void main(String[] args) 
	{
		GUI drawCube=new GUI();
	}
}