package searchSolution;

import cubeClasses.*;

public class Node 
{
	Cube state;
	String action;
	Node parent;
	double cost;
	public Node(Cube s, Node p, String a, double c)
	{
		state = s;
		parent = p;
		action = a;
		cost = c;
	}

}
