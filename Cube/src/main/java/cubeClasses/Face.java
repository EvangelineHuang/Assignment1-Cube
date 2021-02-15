package cubeClasses;

public class Face 
{
	Square[][] squares;
	Face faceLeft;
	Face faceRight;
	Face faceUp;
	Face faceDown;
	
	
	
	public Face(String color)
	{
		//Creates a solved face of all the same color, what color that is is determined by the method call
		//the array is representative of where the square is on the face
		//first number is horizontal placement and second is vertical, counting from left to right and from top to bottom respectively
		squares[0][0] = new Square(color,1);
		squares[1][0] = new Square(color,2);
		squares[0][1] = new Square(color,3);
		squares[1][1] = new Square(color,4);
	}
	
	
	//These are the two methods that correspond to the rotations the manipulator could make
	
	//for reference, 0 is front, 1 is top, 2 is right, 3 is back, 4 is bottom, 5 is left. This is all from the perspective of the initially red face
	
	
	void clockwise(int side)
	{
		//rotates the current face clockwise
		Square temp1;
		Square temp2;
		Square temp3;
		Square temp4;
		
		temp1 = squares[0][0];
		squares[0][0]=squares[0][1];
		
		temp2 = squares[1][0];
		squares[1][0] = temp1;
		
		temp1 = squares[1][1];
		squares[1][1] = temp2;
		
		squares[0][1] = temp1;
		
		
		
		if (side==0)
		{
			temp1 = getFaceRight().getSquares()[0][0];
			temp2 = getFaceRight().getSquares()[0][1];
			
			getFaceRight().getSquares()[0][0] = getFaceUp().getSquares()[0][1];
			getFaceRight().getSquares()[0][1] = getFaceUp().getSquares()[1][1];
			
			temp3 = getFaceDown().getSquares()[0][0];
			temp4 = getFaceDown().getSquares()[1][0];
			
			getFaceDown().getSquares()[1][0] = temp1;
			getFaceDown().getSquares()[0][0] = temp2;
			
			temp1 = getFaceLeft().getSquares()[1][0];
			temp2 = getFaceLeft().getSquares()[1][1];
			
			getFaceLeft().getSquares()[1][0] = temp3;
			getFaceLeft().getSquares()[1][1] = temp4;
			
			getFaceUp().getSquares()[0][1] = temp2;
			getFaceUp().getSquares()[1][1] = temp1;
		}
		else if (side==1)
		{
			
		}
		else if (side==2)
		{
			
		}
		else if (side==3)
		{
			
		}
		else if (side == 4)
		{
			
		}
		else
		{
			
		}
	}
	
	void counterclockwise(int side)
	{
	//rotates the current face counterclockwise
		clockwise(side);
		clockwise(side);
		clockwise(side);
	}
	
	
	
	public Square[][] getSquares()
	{
		return squares;
	}

	public Face getFaceLeft()
	{
		return faceLeft;
	}

	public void setFaceLeft(Face faceLeft)
	{
		this.faceLeft = faceLeft;
	}

	public Face getFaceRight()
	{
		return faceRight;
	}

	public void setFaceRight(Face faceRight)
	{
		this.faceRight = faceRight;
	}

	public Face getFaceUp()
	{
		return faceUp;
	}

	public void setFaceUp(Face faceUp)
	{
		this.faceUp = faceUp;
	}

	public Face getFaceDown()
	{
		return faceDown;
	}

	public void setFaceDown(Face faceDown)
	{
		this.faceDown = faceDown;
	}
	
	

}
