package cubeClasses;


public class Face 
{	
	//2D array will hold the squares according to their orders.
	Square[][] squares = new Square[2][2];	
	String solColor;
	int rank;
	int numOfcolor;

	//flags that are used to mark which direction the face will be rotated	
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
		solColor = "";
		numOfcolor = 0;
	}
	
	public int getNumOfcolor() {
		return numOfcolor;
	}

	public void setNumOfcolor(int numOfcolor) {
		this.numOfcolor = numOfcolor;
	}

	public String getSolColor() {
		return solColor;
	}

	public void setSolColor(String solColor) {
		this.solColor = solColor;
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
		
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i<2; i++)
		{
			for (int j = 0; j<2; j++)
			{
				s = s+ "Face [squares=" + squares[i][j].String() + "]";
			}
		}
		return s;
	}

}
