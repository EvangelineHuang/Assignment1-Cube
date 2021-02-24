package cubeClasses;
public class Square 
{

	String color;//color will be displayed on GUI
	int order;//valid values are 1,2,3,4 corresponding to positions on the Face
	//these two attributes are used to decide will to draw the square on GUI
	int xPos;
	int yPos;
	/**
	 * @param color
	 * @param order
	 */

	/*Square: The constructor
	 * color: A string representing the color
	 * order: An int representing where the square is on the face
	 */
	public Square(String color, int order)
	{
		//System.out.println("sss");
		this.color = color;
		this.order = order;
		xPos = 0;
		yPos = 0;
	}
	////getters and setters, will be used when clone a cube 
	//color: the current color of the square
	public String getColor()
	{
		return color;
	}
	//color: the color that we want to set the square to
	public void setColor(String color)
	{
		this.color = color;
	}
	//order: the order of the square in the face
	public int getOrder() {
		return order;
	}
	//order: the order that we want to give the square
	public void setOrder(int order) {
		this.order = order;
	}
	//setX and setY will be used when the cube is rotated and the position of the cube is changed
	//x: x position we want to move the square to 
	public void setX(int x)
	{
		xPos = x;
	}
	//y: y position we want to move the square to 
	public void setY(int y)
	{
		yPos = y;
	}
	//xPos: current x position of the square
	public int getxPos() 
	{
		return xPos;
	}
	//yPos: current y position of the square
	public int getyPos() 
	{
		return yPos;
	}
	
	/*equals: returns true if two squares are the same, false otherwise, overrides the object.equals method
	 * other: the square that the current one is being compared to
	 */
	public boolean equals(Square other)
	{
		if(this.getColor().equals(other.getColor()))
		{
			return true;
		}
		return false;
	}
	//the same thing as toString()
	public String String() 
	{
		return "Square [color=" + color + ", order=" + order + ", xPos=" + xPos + ", yPos=" + yPos + "]";
	}

}
