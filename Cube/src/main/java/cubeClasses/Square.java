package cubeClasses;
public class Square 
{
	String color;
	int order;
	/**
	 * @param color
	 * @param order
	 */
	public Square(String color, int order)
	{
		super();
		this.color = color;
		this.order = order;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public boolean equals(Square other)
	{
		if(this.getColor().equals(other.getColor()))
		{
			return true;
		}
		return false;
	}
}
