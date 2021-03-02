package searchSolution;
import cubeClasses.*;

public class Solver 
{
	Node head;
	
	//instantiates a solver
	//This method takes the initial cube and returns a node(head) that will be plugged into one of the solving methods
	public Solver(Cube c)
	{
		head = new Node(c, null,"",0);
	}
	
	//depth first search
	//It takes the requested depth as an int
	//Returns a Node in which the state is solved, null if it cannot
	public Node DFS(int depth)
	{
		return null;
	}
	
	//Iterative deepening search
	//Returns a node in which the state is solved, null if it cannot
	public Node IDA()
	{
		return null;
	}
	public void setFace(Cube c)
	{
		
	}
	public double heuristic()
	{
		return 0;
		
	}
	public void defineSolColor()
	{
		
	}
}
