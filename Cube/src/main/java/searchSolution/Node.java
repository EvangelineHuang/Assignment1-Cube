package searchSolution;

import cubeClasses.*;

public class Node 
{
	Cube state;
	String action;
	Node parent;
	double cost;
	double thre;
	public Node(Cube s, Node p, String a, double c, double sh)
	{
		state = s;
		parent = p;
		action = a;
		cost = c;
		thre = sh;
	}
	@Override
	public String toString() {
		return "Node [state=" + state + ", action=" + action + ", parent=" + parent + ", cost=" + cost + ", thre="
				+ thre + "]";
	}
	public double getThre() {
		return thre;
	}
	public void setThre(double thre) {
		this.thre = thre;
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
