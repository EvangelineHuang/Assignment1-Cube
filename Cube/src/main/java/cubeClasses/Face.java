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
	
	public Face getFaceLeft() {
		return faceLeft;
	}


	public void setFaceLeft(Face faceLeft) {
		this.faceLeft = faceLeft;
	}


	public Face getFaceRight() {
		return faceRight;
	}


	public void setFaceRight(Face faceRighr) {
		this.faceRight = faceRighr;
	}


	public Face getFaceUp() {
		return faceUp;
	}


	public void setFaceUp(Face faceUp) {
		this.faceUp = faceUp;
	}


	public Face getFaceDown() {
		return faceDown;
	}


	public void setFaceDown(Face faceDown) {
		this.faceDown = faceDown;
	}

	
	
	//These are the two methods that correspond to the rotations the manipulator could make
	
	//for reference, 0 is front, 1 is top, 2 is right, 3 is back, 4 is bottom, 5 is left. This is all from the perspective of the initially red face
	
	
	
	public Square[][] getSquares()
	{
		return squares;
	}
	public void clockwise()
	{
		
	}
	public void counterclockwise() 
	{
		
	}
	
	

}
