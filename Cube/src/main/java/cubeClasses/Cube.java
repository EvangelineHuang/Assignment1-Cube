package cubeClasses;

import java.util.Arrays;
import java.util.Random;

public class Cube implements A1Cube
{
	//green=0, blue=1, red=2, yellow=3, grey=4, orange=5
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
		/*
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
		*/
		
	}
	
	public Face[] getFaces() {
		return Faces;
	}

	//clone: returns a deep copy of the current cube
	public Cube clone() 
	{
		Cube ccube = new Cube();
		for(int i = 0; i<6; i++)
		{
			
			for (int j = 0; j<2 ; j++)
			{
				for(int m= 0; m<2 ; m++)
				{
					Square s = new Square("default",0);
					s.setColor(this.Faces[i].getSquares()[j][m].getColor());
					s.setX(this.Faces[i].getSquares()[j][m].getxPos());
					s.setY(this.Faces[i].getSquares()[j][m].getyPos());
					s.setOrder(this.Faces[i].getSquares()[j][m].getOrder());
					ccube.Faces[i].getSquares()[j][m] = s;
				}
			}
		}
		return ccube;
	}
	
	/*front, back, right, left, up, down: Rotates the side as designated by the name clockwise
	 * k = the amount of times to rotate
	 */
	@Override
	public void front(int k) {
		k=k%4;
		for(int x=0; x<k;x++)
		{
			Square temp1 = Faces[1].getSquares()[1][0];
			Square temp2 = Faces[1].getSquares()[1][1];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();
			Faces[1].getSquares()[1][0].setX(Faces[4].getSquares()[0][0].getxPos());
			Faces[1].getSquares()[1][1].setX(Faces[4].getSquares()[1][0].getxPos());
			Faces[1].getSquares()[1][0].setY(Faces[4].getSquares()[0][0].getyPos());
			Faces[1].getSquares()[1][1].setY(Faces[4].getSquares()[1][0].getyPos());

			Faces[4].getSquares()[0][0].setX(Faces[2].getSquares()[0][1].getxPos());
			Faces[4].getSquares()[1][0].setX(Faces[2].getSquares()[0][0].getxPos());
			Faces[4].getSquares()[0][0].setY(Faces[2].getSquares()[0][1].getyPos());
			Faces[4].getSquares()[1][0].setY(Faces[2].getSquares()[0][0].getyPos());
		
			Faces[2].getSquares()[0][0].setX(Faces[3].getSquares()[0][1].getxPos());
			Faces[2].getSquares()[0][1].setX(Faces[3].getSquares()[1][1].getxPos());
			Faces[2].getSquares()[0][0].setY(Faces[3].getSquares()[0][1].getyPos());
			Faces[2].getSquares()[0][1].setY(Faces[3].getSquares()[1][1].getyPos());
		
			Faces[3].getSquares()[1][1].setX(tempx1);
			Faces[3].getSquares()[0][1].setX(tempx2);
			Faces[3].getSquares()[1][1].setY(tempy1);
			Faces[3].getSquares()[0][1].setY(tempy2);
	
			Faces[1].getSquares()[1][1] = Faces[3].getSquares()[0][1];
			Faces[1].getSquares()[1][0] = Faces[3].getSquares()[1][1];
			Faces[3].getSquares()[0][1] = Faces[2].getSquares()[0][0];
			Faces[3].getSquares()[1][1] = Faces[2].getSquares()[0][1];
			Faces[2].getSquares()[0][1] = Faces[4].getSquares()[0][0];
			Faces[2].getSquares()[0][0] = Faces[4].getSquares()[1][0];
			Faces[4].getSquares()[0][0] = temp1;
			Faces[4].getSquares()[1][0] = temp2;
		
			//rotates the current face
			temp1=Faces[0].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
		
			Square[][] currentSquares=Faces[0].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
			
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
		
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
		
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
			
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
		
		}
		isSolved = isSolved();
	}

	@Override
	public void left(int k) {
		k=k%4;
		for(int x=0; x<k;x++)
		{
			Square temp1 = Faces[1].getSquares()[0][0];
			Square temp2 = Faces[1].getSquares()[1][0];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();
			Faces[1].getSquares()[0][0].setX(Faces[0].getSquares()[0][0].getxPos());
			Faces[1].getSquares()[1][0].setX(Faces[0].getSquares()[1][0].getxPos());
			Faces[1].getSquares()[0][0].setY(Faces[0].getSquares()[0][0].getyPos());
			Faces[1].getSquares()[1][0].setY(Faces[0].getSquares()[1][0].getyPos());

			Faces[0].getSquares()[0][0].setX(Faces[2].getSquares()[0][0].getxPos());
			Faces[0].getSquares()[1][0].setX(Faces[2].getSquares()[1][0].getxPos());
			Faces[0].getSquares()[0][0].setY(Faces[2].getSquares()[0][0].getyPos());
			Faces[0].getSquares()[1][0].setY(Faces[2].getSquares()[1][0].getyPos());
			
			Faces[2].getSquares()[0][0].setX(Faces[5].getSquares()[1][1].getxPos());
			Faces[2].getSquares()[1][0].setX(Faces[5].getSquares()[0][1].getxPos());
			Faces[2].getSquares()[0][0].setY(Faces[5].getSquares()[1][1].getyPos());
			Faces[2].getSquares()[1][0].setY(Faces[5].getSquares()[0][1].getyPos());
			
			Faces[5].getSquares()[1][1].setX(tempx1);
			Faces[5].getSquares()[0][1].setX(tempx2);
			Faces[5].getSquares()[1][1].setY(tempy1);
			Faces[5].getSquares()[0][1].setY(tempy2);
			
			Faces[1].getSquares()[0][0] = Faces[5].getSquares()[1][1];
			Faces[1].getSquares()[1][0] = Faces[5].getSquares()[0][1];
			Faces[5].getSquares()[0][1] = Faces[2].getSquares()[1][0];
			Faces[5].getSquares()[1][1] = Faces[2].getSquares()[0][0];
			Faces[2].getSquares()[1][0] = Faces[0].getSquares()[1][0];
			Faces[2].getSquares()[0][0] = Faces[0].getSquares()[0][0];
			Faces[0].getSquares()[0][0] = temp1;
			Faces[0].getSquares()[1][0] = temp2;
			
			//rotates the current face
			temp1=Faces[3].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
			
			Square[][] currentSquares=Faces[3].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
			
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
			
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
			
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
			
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
			
		}
		isSolved = isSolved();
	}

	@Override
	public void right(int k) {
		k=k%4;
		for(int x=0; x<k;x++)
		{
			Square temp1 = Faces[1].getSquares()[0][1];
			Square temp2 = Faces[1].getSquares()[1][1];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();
			Faces[1].getSquares()[1][1].setX(Faces[5].getSquares()[0][0].getxPos());
			Faces[1].getSquares()[0][1].setX(Faces[5].getSquares()[1][0].getxPos());
			Faces[1].getSquares()[1][1].setY(Faces[5].getSquares()[0][0].getyPos());
			Faces[1].getSquares()[0][1].setY(Faces[5].getSquares()[1][0].getyPos());

			Faces[5].getSquares()[0][0].setX(Faces[2].getSquares()[1][1].getxPos());
			Faces[5].getSquares()[1][0].setX(Faces[2].getSquares()[0][1].getxPos());
			Faces[5].getSquares()[0][0].setY(Faces[2].getSquares()[1][1].getyPos());
			Faces[5].getSquares()[1][0].setY(Faces[2].getSquares()[0][1].getyPos());
		
			Faces[2].getSquares()[0][1].setX(Faces[0].getSquares()[0][1].getxPos());
			Faces[2].getSquares()[1][1].setX(Faces[0].getSquares()[1][1].getxPos());
			Faces[2].getSquares()[0][1].setY(Faces[0].getSquares()[0][1].getyPos());
			Faces[2].getSquares()[1][1].setY(Faces[0].getSquares()[1][1].getyPos());
		
			Faces[0].getSquares()[0][1].setX(tempx1);
			Faces[0].getSquares()[1][1].setX(tempx2);
			Faces[0].getSquares()[0][1].setY(tempy1);
			Faces[0].getSquares()[1][1].setY(tempy2);
	
			Faces[1].getSquares()[0][1] = Faces[0].getSquares()[0][1];
			Faces[1].getSquares()[1][1] = Faces[0].getSquares()[1][1];
			Faces[0].getSquares()[0][1] = Faces[2].getSquares()[0][1];
			Faces[0].getSquares()[1][1] = Faces[2].getSquares()[1][1];
			Faces[2].getSquares()[0][1] = Faces[5].getSquares()[1][0];
			Faces[2].getSquares()[1][1] = Faces[5].getSquares()[0][0];
			Faces[5].getSquares()[1][0] = temp1;
			Faces[5].getSquares()[0][0] = temp2;
		
			//rotates the current face
			temp1=Faces[4].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
		
			Square[][] currentSquares=Faces[4].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
		
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
		
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
		
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
		
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
		
		}
		isSolved = isSolved();
	}

	@Override
	public void up(int k) {
		
		k=k%4;
		for (int i = 0; i<k;i++ )
		{
			Square temp1 = Faces[0].getSquares()[0][0];
			Square temp2 = Faces[0].getSquares()[0][1];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();
			Faces[0].getSquares()[0][0].setX(Faces[3].getSquares()[0][0].getxPos());
			Faces[0].getSquares()[0][1].setX(Faces[3].getSquares()[0][1].getxPos());
			Faces[0].getSquares()[0][0].setY(Faces[3].getSquares()[0][0].getyPos());
			Faces[0].getSquares()[0][1].setY(Faces[3].getSquares()[0][1].getyPos());
	
			Faces[3].getSquares()[0][0].setX(Faces[5].getSquares()[0][0].getxPos());
			Faces[3].getSquares()[0][1].setX(Faces[5].getSquares()[0][1].getxPos());
			Faces[3].getSquares()[0][0].setY(Faces[5].getSquares()[0][0].getyPos());
			Faces[3].getSquares()[0][1].setY(Faces[5].getSquares()[0][1].getyPos());
			
			Faces[5].getSquares()[0][0].setX(Faces[4].getSquares()[0][0].getxPos());
			Faces[5].getSquares()[0][1].setX(Faces[4].getSquares()[0][1].getxPos());
			Faces[5].getSquares()[0][0].setY(Faces[4].getSquares()[0][0].getyPos());
			Faces[5].getSquares()[0][1].setY(Faces[4].getSquares()[0][1].getyPos());
			
			Faces[4].getSquares()[0][0].setX(tempx1);
			Faces[4].getSquares()[0][1].setX(tempx2);
			Faces[4].getSquares()[0][0].setY(tempy1);
			Faces[4].getSquares()[0][1].setY(tempy2);
		
			Faces[0].getSquares()[0][0] = Faces[4].getSquares()[0][0];
			Faces[0].getSquares()[0][1] = Faces[4].getSquares()[0][1];
			Faces[4].getSquares()[0][0] = Faces[5].getSquares()[0][0];
			Faces[4].getSquares()[0][1] = Faces[5].getSquares()[0][1];
			Faces[5].getSquares()[0][0] = Faces[3].getSquares()[0][0];
			Faces[5].getSquares()[0][1] = Faces[3].getSquares()[0][1];
			Faces[3].getSquares()[0][0] = temp1;
			Faces[3].getSquares()[0][1] = temp2;
			
			//rotates the current face
			temp1=Faces[1].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
			
			Square[][] currentSquares=Faces[1].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
			
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
			
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
			
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
			
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
		}
		isSolved = isSolved();
	}

	@Override
	public void down(int k) {
		k=k%4;
		for (int i = 0; i<k;i++ )
		{
			Square temp1 = Faces[0].getSquares()[1][0];
			Square temp2 = Faces[0].getSquares()[1][1];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();

			Faces[0].getSquares()[1][0].setX(Faces[4].getSquares()[1][0].getxPos());
			Faces[0].getSquares()[1][1].setX(Faces[4].getSquares()[1][1].getxPos());
			Faces[0].getSquares()[1][0].setY(Faces[4].getSquares()[1][0].getyPos());
			Faces[0].getSquares()[1][1].setY(Faces[4].getSquares()[1][1].getyPos());
			

			Faces[4].getSquares()[1][0].setX(Faces[5].getSquares()[1][0].getxPos());
			Faces[4].getSquares()[1][1].setX(Faces[5].getSquares()[1][1].getxPos());
			Faces[4].getSquares()[1][0].setY(Faces[5].getSquares()[1][0].getyPos());
			Faces[4].getSquares()[1][1].setY(Faces[5].getSquares()[1][1].getyPos());


			Faces[5].getSquares()[1][0].setX(Faces[3].getSquares()[1][0].getxPos());
			Faces[5].getSquares()[1][1].setX(Faces[3].getSquares()[1][1].getxPos());
			Faces[5].getSquares()[1][0].setY(Faces[3].getSquares()[1][0].getyPos());
			Faces[5].getSquares()[1][1].setY(Faces[3].getSquares()[1][1].getyPos());

		
			Faces[3].getSquares()[1][0].setX(tempx1);
			Faces[3].getSquares()[1][1].setX(tempx2);
			Faces[3].getSquares()[1][0].setY(tempy1);
			Faces[3].getSquares()[1][1].setY(tempy2);

			Faces[0].getSquares()[1][0] = Faces[3].getSquares()[1][0];
			Faces[0].getSquares()[1][1] = Faces[3].getSquares()[1][1];
			Faces[3].getSquares()[1][0] = Faces[5].getSquares()[1][0];
			Faces[3].getSquares()[1][1] = Faces[5].getSquares()[1][1];
			Faces[5].getSquares()[1][0] = Faces[4].getSquares()[1][0];
			Faces[5].getSquares()[1][1] = Faces[4].getSquares()[1][1];
			Faces[4].getSquares()[1][0] = temp1;
			Faces[4].getSquares()[1][1] = temp2;
			
			//rotates the current face
			temp1=Faces[2].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
			
			Square[][] currentSquares=Faces[2].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
			
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
			
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
			
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
			
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
		}
		isSolved = isSolved();
	}
	
	@Override
	public void back(int k) {
		k=k%4;
		for (int i = 0; i<k;i++ )
		{
			Square temp1 = Faces[1].getSquares()[0][0];
			Square temp2 = Faces[1].getSquares()[0][1];
			int tempx1 = temp1.getxPos();
			int tempx2 = temp2.getxPos();
			int tempy1 = temp1.getyPos();
			int tempy2 = temp2.getyPos();
			Faces[1].getSquares()[0][0].setX(Faces[3].getSquares()[1][0].getxPos());
			Faces[1].getSquares()[0][1].setX(Faces[3].getSquares()[0][0].getxPos());
			Faces[1].getSquares()[0][0].setY(Faces[3].getSquares()[1][0].getyPos());
			Faces[1].getSquares()[0][1].setY(Faces[3].getSquares()[0][0].getyPos());
			
			Faces[3].getSquares()[1][0].setX(Faces[2].getSquares()[1][1].getxPos());
			Faces[3].getSquares()[0][0].setX(Faces[2].getSquares()[1][0].getxPos());
			Faces[3].getSquares()[1][0].setY(Faces[2].getSquares()[1][1].getyPos());
			Faces[3].getSquares()[0][0].setY(Faces[2].getSquares()[1][0].getyPos());
			
			Faces[2].getSquares()[1][1].setX(Faces[4].getSquares()[0][1].getxPos());
			Faces[2].getSquares()[1][0].setX(Faces[4].getSquares()[1][1].getxPos());
			Faces[2].getSquares()[1][1].setY(Faces[4].getSquares()[0][1].getyPos());
			Faces[2].getSquares()[1][0].setY(Faces[4].getSquares()[1][1].getyPos());
			
			Faces[4].getSquares()[0][1].setX(tempx1);
			Faces[4].getSquares()[1][1].setX(tempx2);
			Faces[4].getSquares()[0][1].setY(tempy1);
			Faces[4].getSquares()[1][1].setY(tempy2);
			
			Faces[1].getSquares()[0][0] = Faces[4].getSquares()[0][1];
			Faces[1].getSquares()[0][1] = Faces[4].getSquares()[1][1];
			Faces[4].getSquares()[0][1] = Faces[2].getSquares()[1][1];
			Faces[4].getSquares()[1][1] = Faces[2].getSquares()[1][0];
			Faces[2].getSquares()[1][1] = Faces[3].getSquares()[1][0];
			Faces[2].getSquares()[1][0] = Faces[3].getSquares()[0][0];
			Faces[3].getSquares()[1][0] = temp1;
			Faces[3].getSquares()[0][0] = temp2;
			
			//rotates the current face
			temp1=Faces[5].getSquares()[0][0];
			tempx1=temp1.getxPos();
			tempy1=temp1.getyPos();
			
			Square[][] currentSquares=Faces[5].getSquares();
			currentSquares[0][0].setX(currentSquares[0][1].getxPos());
			currentSquares[0][0].setY(currentSquares[0][1].getyPos());
			
			currentSquares[0][1].setX(currentSquares[1][1].getxPos());
			currentSquares[0][1].setY(currentSquares[1][1].getyPos());
			
			currentSquares[1][1].setX(currentSquares[1][0].getxPos());
			currentSquares[1][1].setY(currentSquares[1][0].getyPos());
			
			currentSquares[1][0].setX(tempx1);
			currentSquares[1][0].setY(tempy1);
			
			currentSquares[0][0]=currentSquares[1][0];
			currentSquares[1][0]=currentSquares[1][1];
			currentSquares[1][1]=currentSquares[0][1];
			currentSquares[0][1]=temp1;
		}
		isSolved = isSolved();
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
		int randir; 
		for (int x = 0; x<k; x++)
		{
			randir = gen.nextInt(2);
			//System.out.println(randir);
			amountOfTurns = gen.nextInt(2)+1;
			currentFace = gen.nextInt(6);
			if(currentFace == 0)
			{	
				if(randir == 0)
				{
					front(amountOfTurns*3);
				}
				else 
				{
					front(amountOfTurns);
				}
				
			}
			else if(currentFace == 1)
			{
				if(randir == 0)
				{
					up(amountOfTurns*3);
				}
				else 
				{
					up(amountOfTurns);
				}
				
			}
			else if(currentFace == 2)
			{
				if(randir == 0)
				{
					right(amountOfTurns*3);
				}
				else 
				{
					right(amountOfTurns);
				}
				
			}
			else if(currentFace == 3)
			{
				if(randir == 0)
				{
					back(amountOfTurns*3);
				}
				else 
				{
					back(amountOfTurns);
				}
			}
			else if(currentFace == 4)
			{
				if(randir == 0)
				{
					down(amountOfTurns*3);
				}
				else 
				{
					down(amountOfTurns);
				}
			}
			else if(currentFace == 5)
			{
				if(randir == 0)
				{
					left(amountOfTurns*3);
				}
				else 
				{
					left(amountOfTurns);
				}
			}
		}
		isSolved = isSolved();
		//System.out.println(isSolved);
	}
	/*reset: sets the cube back to the base state
	 */
	public void reset() {
		isSolved = true;//the cube is solved when it is has been reset.
		
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

	}

	@Override
	public String toString() {
		return "Cube [Faces=" + Arrays.toString(Faces) + ", isSolved=" + isSolved + "]";
	}

}
