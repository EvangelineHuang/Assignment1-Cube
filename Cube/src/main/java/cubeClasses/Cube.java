package cubeClasses;

import java.util.Random;

public class Cube implements A1Cube
{
	//red=0, yellow=1, green=2, black=3, white = 4, orange = 5
	Face[] Faces = new Face[6]; //keep all six faces of the cube 
	boolean isSolved;// flag that is used to keep track of if the cube is in solved state. 
	
	//Constructor: creates a solved cube with six faces, each of a unique color
	public Cube()
	{
		isSolved = true;//the cube is solved when it is just created. 
		
		// add all the faces to the cube along with the color of each face. 
		Faces[0]=new Face("#84A59D");
		Faces[1]=new Face("#98C1D9");
		Faces[2]=new Face("#E5989B");
		Faces[3]=new Face("#FFF3B0");
		Faces[4]=new Face("#BCB8B1");
		Faces[5]=new Face("#DDA15E");
		//set positions for the first face;
		Faces[0].getSquares()[0][0].setX(200);
		Faces[0].getSquares()[0][0].setY(200);
		Faces[0].getSquares()[1][1].setX(232);
		Faces[0].getSquares()[1][1].setY(232);
		Faces[0].getSquares()[0][1].setX(232);
		Faces[0].getSquares()[0][1].setY(200);
		Faces[0].getSquares()[1][0].setX(200);
		Faces[0].getSquares()[1][0].setY(232);
		//set positions for the second face
		Faces[1].getSquares()[0][0].setX(200);
		Faces[1].getSquares()[0][0].setY(136);
		Faces[1].getSquares()[1][1].setX(232);
		Faces[1].getSquares()[1][1].setY(168);
		Faces[1].getSquares()[0][1].setX(232);
		Faces[1].getSquares()[0][1].setY(136);
		Faces[1].getSquares()[1][0].setX(200);
		Faces[1].getSquares()[1][0].setY(168);
		//set positions for the third face
		Faces[2].getSquares()[0][0].setX(200);
		Faces[2].getSquares()[0][0].setY(264);
		Faces[2].getSquares()[1][1].setX(232);
		Faces[2].getSquares()[1][1].setY(296);
		Faces[2].getSquares()[0][1].setX(232);
		Faces[2].getSquares()[0][1].setY(264);
		Faces[2].getSquares()[1][0].setX(200);
		Faces[2].getSquares()[1][0].setY(296);
		//set positions for the fourth face
		Faces[3].getSquares()[0][0].setX(136);
		Faces[3].getSquares()[0][0].setY(200);
		Faces[3].getSquares()[1][1].setX(168);
		Faces[3].getSquares()[1][1].setY(232);
		Faces[3].getSquares()[0][1].setX(168);
		Faces[3].getSquares()[0][1].setY(200);
		Faces[3].getSquares()[1][0].setX(136);
		Faces[3].getSquares()[1][0].setY(232);
		//set positions for the fifth face
		Faces[4].getSquares()[0][0].setX(264);
		Faces[4].getSquares()[0][0].setY(200);
		Faces[4].getSquares()[1][1].setX(296);
		Faces[4].getSquares()[1][1].setY(232);
		Faces[4].getSquares()[0][1].setX(296);
		Faces[4].getSquares()[0][1].setY(200);
		Faces[4].getSquares()[1][0].setX(264);
		Faces[4].getSquares()[1][0].setY(232);
		//set positions for the sixth face
		Faces[5].getSquares()[0][0].setX(328);
		Faces[5].getSquares()[0][0].setY(200);
		Faces[5].getSquares()[1][1].setX(360);
		Faces[5].getSquares()[1][1].setY(232);
		Faces[5].getSquares()[0][1].setX(360);
		Faces[5].getSquares()[0][1].setY(200);
		Faces[5].getSquares()[1][0].setX(328);
		Faces[5].getSquares()[1][0].setY(232);
		//sets the adjacent face values for the first face	
		Faces[0].setFaceUp(Faces[1]);	
		Faces[0].setFaceRight(Faces[4]);	
		Faces[0].setFaceDown(Faces[2]);	
		Faces[0].setFaceLeft(Faces[3]);	
		//second face	
		Faces[1].setFaceUp(Faces[5]);	
		Faces[1].setFaceRight(Faces[4]);	
		Faces[1].setFaceDown(Faces[0]);	
		Faces[1].setFaceLeft(Faces[3]);	
		//third face	
		Faces[2].setFaceUp(Faces[1]);		
		Faces[2].setFaceRight(Faces[4]);	
		Faces[2].setFaceDown(Faces[5]);	
		Faces[2].setFaceLeft(Faces[3]);	
		//fourth face	
		Faces[3].setFaceUp(Faces[1]);	
		Faces[3].setFaceRight(Faces[0]);	
		Faces[3].setFaceDown(Faces[2]); 		
		Faces[3].setFaceLeft(Faces[5]);	
		//fifth face	
		Faces[4].setFaceUp(Faces[1]);	
		Faces[4].setFaceRight(Faces[5]);	
		Faces[4].setFaceDown(Faces[2]);	
		Faces[4].setFaceLeft(Faces[0]);	
		//sixth face	
		Faces[5].setFaceUp(Faces[1]);	
		Faces[5].setFaceRight(Faces[3]);	
		Faces[5].setFaceDown(Faces[2]);	
		Faces[5].setFaceLeft(Faces[4]);
		
	}
	
	public Face[] getFaces() {
		return Faces;
	}

	//clone: returns a deep copy of the current cube
	public A1Cube clone() 
	{
		return null;		
	}
	
	/*front, back, right, left, up, down: Rotates the side as designated by the name clockwise
	 * k = the amount of times to rotate
	 */
	@Override
	public void front(int k) {

		Square temp1;
		Square temp2;
		Square temp3;
		Square temp4;
		k = k % 4;
		for(int x = 0; x<k; x++)
		{
		//rotates the face itself
		temp1 = Faces[0].getSquares()[0][0];
		Faces[0].getSquares()[0][0]=Faces[0].getSquares()[0][1];
		temp2 = Faces[0].getSquares()[1][0];
		Faces[0].getSquares()[1][0] = temp1;
		temp1 = Faces[0].getSquares()[1][1];
		Faces[0].getSquares()[1][1] = temp2;
		Faces[0].getSquares()[0][1] = temp1;
		
		//rotates face 1 into face 2 and stores face 2's replaced values
		temp1 = Faces[2].getSquares()[0][0];
		temp2 = Faces[2].getSquares()[0][1];
		Faces[2].getSquares()[0][0] = Faces[1].getSquares()[0][1];
		Faces[2].getSquares()[0][1] = Faces[1].getSquares()[1][1];
		
		//rotates face 2 into face 4 and stores face 4's replaced values
		temp3 = Faces[4].getSquares()[0][0];
		temp4 = Faces[4].getSquares()[1][0];
		Faces[4].getSquares()[1][0] = temp1;
		Faces[4].getSquares()[0][0] = temp2;
			
		//rotates face 4 into face 5 and stores face 5's replaced values
		temp1 = Faces[5].getSquares()[1][0];
		temp2 = Faces[5].getSquares()[1][1];	
		Faces[5].getSquares()[1][0] = temp3;
		Faces[5].getSquares()[1][1] = temp4;
		
		//rotates face 5 into face one
		Faces[1].getSquares()[0][1] = temp2;
		Faces[1].getSquares()[1][1] = temp1;
		}
	}

	@Override
	public void left(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down(int k) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void back(int k) {
		// TODO Auto-generated method stub
		
	}
	
	/*isSolved: checks if the cube has been solved, returns true if it has been, false otherwise
	 *solved in this case means that all sides are only single colored, not that all Faces[0].getSquares() are in their original places
	 */
	/*
	 solved: boolean to indicate if the cube is solved.
	 */
	@Override
	public boolean isSolved() {

		boolean solved=true;
		Square[][] current;
		for(int side=0;side<6;side++)
		{
			current = Faces[side].getSquares();
			if(current[0][0].equals(current[1][0]) && current[0][0].equals(current[0][1]) && current[0][0].equals(current[1][1]))
			{
				
			}
			else
			{
				solved=false;
			}
		}
		
		return solved;
	}
	/*randomize: Turns faces randomly in order to create a randomly shuffled cube
	 * int k = the amount of turns that will be made
	 */
	@Override
	public void randomize(int k) {
		Random gen = new Random();
		int currentFace;
		int amountOfTurns;
		for (int x = 0; x<k; x++)
		{
			amountOfTurns = gen.nextInt(2)+1;
			currentFace = gen.nextInt(5);
			if(currentFace == 0)
			{
				front(amountOfTurns);
			}
			else if(currentFace == 1)
			{
				up(amountOfTurns);
			}
			else if(currentFace == 2)
			{
				right(amountOfTurns);
			}
			else if(currentFace == 3)
			{
				back(amountOfTurns);
			}
			else if(currentFace == 4)
			{
				down(amountOfTurns);
			}
			else if(currentFace == 5)
			{
				left(amountOfTurns);
			}
		}
		isSolved = isSolved();
	}
	/*reset: sets the cube back to the base state
	 */
	public void reset() {
		isSolved = true;//the cube is solved when it is has been reset.
		
		// add all the faces to the cube along with the color of each face. 
		Faces[0]=new Face("red");
		Faces[1]=new Face("yellow");
		Faces[2]=new Face("green");
		Faces[3]=new Face("black");
		Faces[4]=new Face("white");
		Faces[5]=new Face("orange");

	}
	
}
