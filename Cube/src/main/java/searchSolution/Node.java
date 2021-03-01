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
	public Cube getState() {
		return state;
	}
	public void setState(Cube state) {
		this.state = state;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
