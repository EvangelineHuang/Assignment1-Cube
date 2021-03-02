package searchSolution;
import cubeClasses.*;

public class Main {

	public static void main(String[] args) 
	{
		GUI drawCube=new GUI();		
		Cube c = new Cube();
		//c.randomize(2);
		c.back(1);
		c.down(1);
		Solver s = new Solver(c);
		s.defineSolColor();
		for (int i = 0; i<6;i++)
		{
			System.out.println(i);
			System.out.println(c.getFaces()[i].getSolColor());
		}
		drawCube.setCube(c);
	}

}
