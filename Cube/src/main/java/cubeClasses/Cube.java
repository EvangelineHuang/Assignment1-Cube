package cubeClasses;

import java.util.Random;

public class Cube 
{
	//red=0, yellow=1, green=2, black=3, white = 4, orange = 5
	Face[] Faces;
	Boolean isSolved;
	
	public void genCube()
	{
		isSolved = true;
		
		Faces[0]=new Face("red");
		Faces[1]=new Face("yellow");
		Faces[2]=new Face("green");
		Faces[3]=new Face("black");
		Faces[4]=new Face("white");
		Faces[5]=new Face("orange");

		
		//sets the adjacent face values
		Faces[0].setFaceUp(Faces[1]);
		Faces[0].setFaceRight(Faces[2]);
		Faces[0].setFaceDown(Faces[4]);
		Faces[0].setFaceLeft(Faces[5]);
		
		Faces[1].setFaceUp(Faces[3]);
		Faces[1].setFaceRight(Faces[2]);
		Faces[1].setFaceDown(Faces[0]);
		Faces[1].setFaceLeft(Faces[5]);
		
		Faces[2].setFaceUp(Faces[1]);	
		Faces[2].setFaceRight(Faces[3]);
		Faces[2].setFaceDown(Faces[4]);
		Faces[2].setFaceLeft(Faces[0]);
		
		Faces[3].setFaceUp(Faces[1]);
		Faces[3].setFaceRight(Faces[5]);
		Faces[3].setFaceDown(Faces[4]); 	
		Faces[3].setFaceLeft(Faces[2]);
		
		Faces[4].setFaceUp(Faces[0]);
		Faces[4].setFaceRight(Faces[2]);
		Faces[4].setFaceDown(Faces[3]);
		Faces[4].setFaceLeft(Faces[5]);
		
		Faces[5].setFaceUp(Faces[1]);
		Faces[5].setFaceRight(Faces[0]);
		Faces[5].setFaceDown(Faces[4]);
		Faces[5].setFaceLeft(Faces[3]);
	}
	
	void shuffle()
	{
		//does a set of random operations on the cube so that it becomes shuffled while still being solvable, as it was made with moves the manipulator can replicate
		Random gen = new Random();
		int selection = 0;
		int current;
		for (int x = 0; x<100; x++)
		{
			current = gen.nextInt(5);
			selection = gen.nextInt(1);
			if(selection == 0)
			{
				Faces[current].clockwise(current);
			}
			else if(selection ==1)
			{
				Faces[current].counterclockwise(current);
			}
		}
		isSolved = checkSolved();
	}
	
	boolean checkSolved() {
		//checks if the cube has been solved, returns true if it has been
		//solved in this case means that all sides are only single colored, not that all squares are in their original places
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
}
