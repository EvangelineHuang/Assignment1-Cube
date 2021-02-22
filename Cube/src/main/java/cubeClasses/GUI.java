package cubeClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel label2 = new JLabel();

	//button listener will be added in the next turn in
	/*GUI: the constructor, creates the cube as well as the buttons necessary to manipulate it
	 */
	public GUI()
	{
		//to set title
		super("Draw a Cube");
		JPanel p = new JPanel();
	    p.setLayout(null);
		//set close button operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(p);
		JButton cw = new JButton();
		JButton ccw = new JButton();
		cw.setText("Clockwise");
	    Dimension size1 = cw.getPreferredSize();
	    cw.setBounds(440, 30, size1.width, size1.height);

		p.add(cw);
		cw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  dir = true;
	          }});
		
		ccw.setText("Counterclockwise");
	    Dimension size2 = ccw.getPreferredSize();
	    ccw.setBounds(440, 60, size2.width, size2.height);

		p.add(ccw);
		//ccw.setLocation(0, 0);
		ccw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  dir = false;
	          }});
		JLabel label1 = new JLabel();
		label1.setText("Enter the number of rotations:");
	    Dimension size3 = label1.getPreferredSize();
	    label1.setBounds(450, 90, size3.width, size3.height);

		p.add(label1);
		JTextField field = new JTextField(5);
	    Dimension size4 = field.getPreferredSize();
	    field.setBounds(445, 110, size4.width, size4.height);
		p.add(field);
	    label2.setBounds(200, 400, 200, 100);
	    label2.setFont(new Font("Serif", Font.PLAIN, 28));
		p.add(label2);
		//create back button for rotating
		JButton back = new JButton();
		back.setText("Back");	
	    Dimension size5 = back.getPreferredSize();
	    back.setBounds(440, 140, size5.width, size5.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		//create forward button
		JButton front = new JButton();
		front.setText("Front");	
	    Dimension size6 = front.getPreferredSize();
	    front.setBounds(440, 170, size6.width, size6.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    		  	  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		//create up button
		JButton up = new JButton();
		up.setText("Up");	
	    Dimension size7 = up.getPreferredSize();
	    up.setBounds(440, 200, size7.width, size7.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		//create down button
		JButton down = new JButton();
		down.setText("Down");
	    Dimension size8 = down.getPreferredSize();
	    down.setBounds(440, 230, size8.width, size8.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		//create left button
		JButton left = new JButton();
		left.setText("Feft");	
	    Dimension size9 = left.getPreferredSize();
	    left.setBounds(440, 260, size9.width, size9.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		//create right button
		JButton right = new JButton();
		right.setText("Right");	
	    Dimension size10 = right.getPreferredSize();
	    right.setBounds(440, 290, size10.width, size10.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  //System.out.println(cube.isSolved());
	        	  repaint();
	          }});

		
		JButton ran = new JButton();
		ran.setText("Randomize");
	    Dimension size11 = ran.getPreferredSize();
	    ran.setBounds(440, 320, size11.width, size11.height);
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
	      		  if(cube.isSolved() == true)
	    		  {
	    			  label2.setText("Solved");
	    		  }
	    		  else
	    		  {
	    			  label2.setText("Not Solved");
	    		  }
	        	  repaint();
	          }});
		JButton reset= new JButton();
		reset.setText("Reset");
	    Dimension size12 = reset.getPreferredSize();
	    reset.setBounds(440, 350, size12.width, size12.height);
		p.add(reset);
		reset.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	  cube.reset();
	        	  repaint();
	          }});
		//set position of buttons
		//set size
		setSize(650,600);

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
		if(cube.isSolved() == true)
	    {
     		label2.setText("Solved");
   	    }
		else
		{
			label2.setText("Not Solved");
		}
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
