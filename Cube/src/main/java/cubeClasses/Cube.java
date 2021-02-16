package cubeClasses;

import java.util.Random;

public class Cube implements A1Cube
{
	//red=0, yellow=1, green=2, black=3, white = 4, orange = 5
	Face[] Faces;
	boolean isSolved;
	
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
	
	
	public A1Cube clone() 
	{
		return null;		
	}

	@Override
	public void front(int k) {
		// 
		Square temp1;
		Square temp2;
		Square temp3;
		Square temp4;
		
		for(int x = 0; x<k; x++)
		{
		temp1 = Faces[0].getSquares()[0][0];
		Faces[0].getSquares()[0][0]=Faces[0].getSquares()[0][1];
		
		temp2 = Faces[0].getSquares()[1][0];
		Faces[0].getSquares()[1][0] = temp1;
		
		temp1 = Faces[0].getSquares()[1][1];
		Faces[0].getSquares()[1][1] = temp2;
		
		Faces[0].getSquares()[0][1] = temp1;
		
		temp1 = Faces[2].getSquares()[0][0];
		temp2 = Faces[2].getSquares()[0][1];
			
		Faces[2].getSquares()[0][0] = Faces[1].getSquares()[0][1];
		Faces[2].getSquares()[0][1] = Faces[1].getSquares()[1][1];
			
		temp3 = Faces[4].getSquares()[0][0];
		temp4 = Faces[4].getSquares()[1][0];
			
		Faces[4].getSquares()[1][0] = temp1;
		Faces[4].getSquares()[0][0] = temp2;
			
		temp1 = Faces[5].getSquares()[1][0];
		temp2 = Faces[5].getSquares()[1][1];
			
		Faces[5].getSquares()[1][0] = temp3;
		Faces[5].getSquares()[1][1] = temp4;
			
		Faces[1].getSquares()[0][1] = temp2;
		Faces[1].getSquares()[1][1] = temp1;
		}
	}

	@Override
	public void back(int k) {
		// TODO Auto-generated method stub
		
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
	public boolean isSolved() {
		//checks if the cube has been solved, returns true if it has been
		//solved in this case means that all sides are only single colored, not that all Faces[0].getSquares() are in their original places
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

	@Override
	public void randomize(int k) {
		// TODO Auto-generated method stub
		//does a set of random operations on the cube so that it becomes shuffled while still being solvable, as it was made with moves the manipulator can replicate
		Random gen = new Random();
		int selection = 0;
		int current;
		for (int x = 0; x<k; x++)
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
		isSolved = isSolved();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		isSolved = true;
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
	
}
