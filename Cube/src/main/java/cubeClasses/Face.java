package cubeClasses;

public class Face 
{	
	//2D array will hold the squares according to their orders.
	Square[][] squares;
	//four pointers used to connect one face to its four adjacent faces
	Face faceLeft;
	Face faceRight;
	Face faceUp;
	Face faceDown;
	//flags that are used to mark which direction the face will be rotated
	Boolean counterclock = false;
	Boolean clockwise = false;
	public Face(String color)
	{
		//Creates a solved face of all the same color, what color that is is determined by the method call
		//the array is representative of where the square is on the face
		//first number is horizontal placement and second is vertical, counting from left to right and from top to bottom respectively
		//x,y positions of the squares will also be set here.
		squares[0][0] = new Square(color,1);
		squares[1][0] = new Square(color,2);
		squares[0][1] = new Square(color,3);
		squares[1][1] = new Square(color,4);
	}
	//getters and setters for the completeness of the class. All the setters will be used to 
	//set current face's adjacent faces 
	public Face getFaceLeft() {
		return faceLeft;
	}


	public void setFaceLeft(Face faceLeft) {
		this.faceLeft = faceLeft;
	}


	public Face getFaceRight() {
		return faceRight;
	}


	public void setFaceRight(Face faceRight) {
		this.faceRight = faceRight;
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
	
	
	public Square[][] getSquares()
	{
		return squares;
	}
	//this setter may not be used 
	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
	//these two methods will be used to decide if the face will be rotated clockwise 
	//or counterclockwise, just be true or false.
	public void clockwise()
	{
		
	}
	
	public void counterclockwise() 
	{
		
	}
	
	

}
