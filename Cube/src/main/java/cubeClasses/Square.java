package cubeClasses;
public class Square 
{
	String color;
	int order;
	int xPos;
	int yPos;
	/**
	 * @param color
	 * @param order
	 */
	public Square(String color, int order)
	{
		super();
		this.color = color;
		this.order = order;
		xPos = 0;
		yPos = 0;
	}
	////getters and setters
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setX(int x)
	{
		xPos = x;
	}
	public void setY(int y)
	{
		yPos = y;
	}
	public int getxPos() 
	{
		return xPos;
	}
	public int getyPos() 
	{
		return yPos;
	}
	//////
	public boolean equals(Square other)
	{
		if(this.getColor().equals(other.getColor()))
		{
			return true;
		}
		return false;
	}
}
