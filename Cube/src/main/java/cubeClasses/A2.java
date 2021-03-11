package cubeClasses;

public class A2 {

	public static void main(String[] args) 
	{
		//create a GUI which will be used to check if the solution if the right one
		//GUI drawCube=new GUI();	
		//GUI drawCube2=new GUI();
		/*Cube c1 = new Cube();
		Cube c2 = new Cube();
		Cube c3 = new Cube();
		Cube c4 = new Cube();
		Cube c5 = new Cube();
		Cube c6 = new Cube();
		Cube c7 = new Cube();
		Cube c8 = new Cube();
		Cube c9 = new Cube();
		Cube c10 = new Cube();*/
		
		int k = 1;
		//int n = 0;
		while (k<15)
		{
		//while (true)
		//{
			System.out.println("k = "+k);
			System.out.println("Cube1");
			Cube c1 = new Cube();
			c1.randomize(k);
			Solver s1 = new Solver(c1);
			s1.IDA();
	    
			System.out.println("Cube2");
			Cube c2 = new Cube();
			c2.randomize(k);
			Solver s2 = new Solver(c2);
			s2.IDA();
			System.out.println("Cube3");
			Cube c3 = new Cube();
			c3.randomize(k);
			Solver s3 = new Solver(c3);
			s3.IDA();
			System.out.println("Cube4");
			Cube c4 = new Cube();
			c4.randomize(k);
			Solver s4 = new Solver(c4);
			s4.IDA();
			System.out.println("Cube5");
			Cube c5 = new Cube();
			c5.randomize(k);
			Solver s5 = new Solver(c5);
			s5.IDA();
			System.out.println("Cube6");
			Cube c6 = new Cube();
			c6.randomize(k);
			Solver s6 = new Solver(c6);
			s6.IDA();
			System.out.println("Cube7");
			Cube c7 = new Cube();
			c7.randomize(k);
			Solver s7 = new Solver(c7);
			s7.IDA();
			System.out.println("Cube8");
			Cube c8 = new Cube();
			c8.randomize(k);
			Solver s8 = new Solver(c8);
			s8.IDA();
			System.out.println("Cube9");
			Cube c9 = new Cube();
			c9.randomize(k);
			Solver s9 = new Solver(c9);
			s9.IDA();
			System.out.println("Cube10");
			Cube c10 = new Cube();
			c10.randomize(k);
			Solver s10 = new Solver(c10);
			s10.IDA();
			k++;
		}
		//c.randomize(1000);
		//drawCube.setCube(c);
		/*c.back(2);
		c.down(2);
		c.left(2);
		c.back(1);
		c.front(2);
		c.right(1);
		c.up(2);*/
		//drawCube.setCube(c1);
		//Solver s = new Solver(c);
		//s.defineSolColor();
		
		//System.out.println(c.isSolved());

		//drawCube.setCube(c);
	}

}
