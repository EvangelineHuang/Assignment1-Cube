package cubeClasses;

public class Face 
{	
	//2D array will hold the squares according to their orders.
	Square[][] squares = new Square[2][2];

	/* Face: the constructor, sets all squares to the same color
	 * color: a string representing the desired color of the side
	 */
	public Face(String color)
	{
		//System.out.println(squares);
		squares[0][0] = new Square(color,1);
		squares[1][0] = new Square(color,2);
		squares[0][1] = new Square(color,3);
		squares[1][1] = new Square(color,4);
	}
	
	//getSquares: returns an array of squares
	//square; the current array of squares of the face
	public Square[][] getSquares()
	{
		return squares;
	}
	/*setSquares: replaces the side with a pre-existing array of squares, may not be used
	 * squares: an array of squares
	 */
	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
}
