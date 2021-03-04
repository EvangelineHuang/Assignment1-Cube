package searchSolution;
import cubeClasses.*;

public class Main {

	public static void main(String[] args) 
	{
		//create a GUI which will be used to check if the solution if the right one
		GUI drawCube=new GUI();		
		Cube c = new Cube();
		c.randomize(10);
		//drawCube.setCube(c);
		//c.back(1);
		//c.down(1);
		drawCube.setCube(c);
		Solver s = new Solver(c);
		//s.defineSolColor();
		s.IDA();
		//System.out.println(c.isSolved());
		/*for (int i = 0; i<6;i++)
		{
			System.out.println(i);
			System.out.println(c.getFaces()[i].getSolColor());
		}*/
		//drawCube.setCube(c);
	}

}
