package searchSolution;
import cubeClasses.*;

public class Main {

	public static void main(String[] args) 
	{
		Cube c = new Cube();
		c.randomize(0);
		Solver s = new Solver(c);
	}

}
