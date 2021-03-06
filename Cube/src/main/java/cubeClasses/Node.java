package cubeClasses;

public class Node 
{
	Cube state;//current state of the cube
	String action;//which action that generated the state
	Node parent;//parent of the node
	double cost;//f(n) = cost + heuristic
	
	public Node(Cube s, Node p, String a, double c)
	{
		state = s;
		parent = p;
		action = a;
		cost = c;

	}
	@Override
	//used to print out the node
	//used for debugging 
	public String toString() {
		return "Node [state=" + state + ", action=" + action + ", parent=" + parent + ", cost=" + cost 
				 + "]";
	}
	//getters and setters. 
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
