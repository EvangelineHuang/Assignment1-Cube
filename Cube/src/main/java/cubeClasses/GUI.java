package cubeClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//This is the GUI of the Cube. Every time a button get clicked on, the unfolded 
//cube will display how a real cube is rotated.
//When the cube is rotated, all the squares will be repainted.
@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	Cube cube = new Cube();//The cube that will be painted 
	int k = 1;
	Boolean dir = true;
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
		JButton cw = new JButton();
		JButton ccw = new JButton();
		cw.setText("Clockwise");
		p.add(cw);
		cw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  dir = true;
	          }});
		
		ccw.setText("Counterclockwise");
		p.add(ccw);
		ccw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  dir = false;
	          }});
		JTextField field = new JTextField(5);
		p.add(field);
		//create back button for rotating
		JButton back = new JButton();
		back.setText("Back");		
		p.add(back);
		//button action listener, will repaint the cube
		back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.back(k);
	        	  repaint();
	          }});
		//create forward button
		JButton front = new JButton();
		front.setText("Front");		
		p.add(front);
		front.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.front(k);
	        	  repaint();
	          }});
		//create up button
		JButton up = new JButton();
		up.setText("Up");		
		p.add(up);
		up.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //System.out.println(cube.getFaces()[0]);
	        	 /*System.out.println(cube.getFaces()[1]);
	        	 System.out.println(cube.getFaces()[2]);
	        	 System.out.println(cube.getFaces()[3]);
	        	 System.out.println(cube.getFaces()[4]);
	        	 System.out.println(cube.getFaces()[5]);*/
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.up(k);
	        	  repaint();
	          }});
		//create down button
		JButton down = new JButton();
		down.setText("Down");		
		p.add(down);
		down.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.down(k);
	        	  repaint();
	          }});
		//create left button
		JButton left = new JButton();
		left.setText("Feft");		
		p.add(left);
		left.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.left(k);
	        	  repaint();
	          }});
		//create right button
		JButton right = new JButton();
		right.setText("Right");		
		p.add(right);
		right.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.right(k);
	        	  repaint();
	          }});

		
		JButton ran = new JButton();
		ran.setText("Randomize");
		p.add(ran);
		ran.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  try
	        	  {
	        		  k = Integer.parseInt(field.getText());
	        	  }
	        	  catch(NumberFormatException exception)
	        	  {
	        		  k = 1;
	        	  }
	        	  if (dir == false)
	        	  {
	        		  k = 3*k;
	        	  }
	        	  cube.randomize(k);
	        	  repaint();
	          }});
		JButton reset= new JButton();
		reset.setText("Reset");
		p.add(reset);
		reset.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  cube.reset();
	        	  repaint();
	          }});
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
			g.setColor(Color.decode(f.getSquares()[1][1].getColor()));
			g.fillRect(f.getSquares()[1][1].getxPos(), f.getSquares()[1][1].getyPos(), 30, 30);
			g.setColor(Color.decode(f.getSquares()[0][1].getColor()));
			g.fillRect(f.getSquares()[0][1].getxPos(), f.getSquares()[0][1].getyPos(), 30, 30);
			g.setColor(Color.decode(f.getSquares()[1][0].getColor()));
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