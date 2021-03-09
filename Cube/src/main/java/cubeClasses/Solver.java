package cubeClasses;


import java.util.ArrayList;

public class Solver 
{
	Node head;
	int counter;
	//instantiates a solver
	//This method takes the initial cube and returns a node(head) that will be plugged into one of the solving methods
	public Solver(Cube c)
	{
		head = new Node(c, null,"", 0);
		counter = 0; 
	}
	//Iterative deepening search
	//will not return anything, but will print the solution if there is one. 
	public void IDA()
	{
		counter = 0;
		long startTime = System.currentTimeMillis();
		//counter++;
		//defineSolColor();
		//double s = heuristic(head.state);
		//define the color of each face in order to minimize f(n)
		defineSolColor(head.state);

		//find the heuristic of the head. 
		double s = heuristic(head.state);
		//min is the placeholder for the new threshold which will be passed along the 
		//call of the recursion function. 
		double min = 0; 
		
		Node n = DFS(head, s, head.cost,min);
		
		//System.out.println(head);
		//when the returned node is an "empty" node which is used to contain the new threshold. 
		while(n.state == null && n.action == "" && n.parent == null)
		{		
			n = DFS(head, n.cost, head.cost,min);			
		}
		
		//The program will get here only if it finds a solution
		//the arraylist is used hold all the solutions 
		ArrayList<String> solution = new ArrayList<String>();
		//from the returned node and trace back to the initial node to get a sequence of actions
		Node current = n;
		@SuppressWarnings("unused")
		int size = 0;
		//System.out.println(n.action);
		while(current.parent != null)
		{
			solution.add(current.action);
			current = current.parent;
			size ++;
		}
		System.out.println("The solution has "+ solution.size()+" actions!");
		//print out the solution
		for(int i = solution.size()-1; i>-1;i--)
		{
			System.out.println(solution.get(i));
		}
		//System.out.println("Done!");
		
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("CPU time in milliseconds: "+timeElapsed);
		System.out.println(counter + " nodes.");

	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	//depth first search
	//n: the node that will be expanded
	//threshold: the threshold of the current iteration that will be used to cutoff branches
	//fn: the evaluation of node n
	//inc: the increment for the new threshold which will be the minimum evaluation value of the nodes that have been cut.
	//Returns a Node in which the state is solved, otherwise an empty node with new threshold.
	public Node DFS(Node n, double threshold, double fn, double inc)
	{
		counter ++;
		//double fn =cost + heuristic(n.getState());
		//if node n is the goal, return n.
		if(n.getState().isSolved())
		{
			return n;
		}
		//if node n exceeds the threshold, return "empty" node which holds the new candidate of the threshold
		if(fn > threshold)
		{
			Node fnode;
			if(inc < fn)
			{
				inc = fn;
			}
			fnode = new Node(null,null,"",inc);
			return fnode;
		}
		//list of children if the node is neither the goal or exceeds the threshold.
		ArrayList<Node> children = new ArrayList<Node>();
		//the if conditions are used to prevent repeat state. 
		if(n.action != "counterleft")
		{
			Cube cl = (Cube)n.getState().clone();
			cl.left(1);
			Node left = new Node(cl,n,"left",fn+1+heuristic(cl));
			Node tl = DFS(left, threshold,left.cost,inc);
			if(tl.state != null && tl.state.isSolved())
			{
				return tl;
			}
			children.add(tl);
		}
		if(n.action != "counterback")
		{
			Cube cb = (Cube)n.getState().clone();
			cb.back(1);
			Node back = new Node(cb,n,"back",fn+1+heuristic(cb));
			Node tb =DFS(back, threshold,back.cost,inc);
			if(tb.state != null && tb.state.isSolved())
			{
				return tb;
			}
			children.add(tb);
		}
		if(n.action != "counterup")
		{
			Cube cu = (Cube)n.getState().clone();
			cu.up(1);
			Node up = new Node(cu,n,"up",fn+1+heuristic(cu));
			Node tu =DFS(up, threshold,up.cost,inc);
			if(tu.state != null && tu.state.isSolved())
			{
				return tu;
			}
			children.add(tu);
		}
		if(n.action != "up")
		{
			Cube ccu = (Cube)n.getState().clone();
			ccu.up(3);
			Node ccup = new Node(ccu,n,"counterup",fn+1+heuristic(ccu));
			Node tcu =DFS(ccup, threshold,ccup.cost,inc);
			if(tcu.state != null && tcu.state.isSolved())
			{
				return tcu;
			}
			children.add(tcu);
		}
		if(n.action != "left")
		{
			Cube ccl = (Cube)n.getState().clone();
			ccl.left(3);
			Node ccleft = new Node(ccl,n,"counterleft",fn+1+heuristic(ccl));
			Node tcl =DFS(ccleft, threshold,ccleft.cost,inc);
			if(tcl.state != null &&tcl.state.isSolved())
			{
				return tcl;
			}
			children.add(tcl);
		}
		if(n.action != "back")
		{
			Cube ccb = (Cube)n.getState().clone();
			ccb.back(3);
			Node ccback = new Node(ccb,n,"counterback",fn+1+heuristic(ccb));
			Node tcb =DFS(ccback, threshold,ccback.cost,inc);
			if(tcb.state != null && tcb.state.isSolved())
			{
				return tcb;
			}
			children.add(tcb);
		}
		Node mini = new Node(null,null,"",0);
		//for all the children, if one of them is the goal then return the goal. 
		//if none of them is the goal, then find the minimum of the empty state and return that empty node.
		for(int i = 0; i<children.size();i++)
		{
			//System.out.println(children[i]);
			if(children.get(i).state == null && children.get(i).action == "" && children.get(i).parent == null)
			{
				if(mini.cost > children.get(i).cost);
				{
					mini = children.get(i);
				}
			}
		}
		return mini;
	}


    //this function is used to calculate the heuristic of the state
	//go through every square and compare them to the color that has been set for the face in order to calculate 
	//the misplaced squares.
	//c: current state
	//h: heuristic function f(n)
	public double heuristic(Cube c)
	{
		if(c.isSolved())
		{
			return 0;
		}
		double h = 0;
		//System.out.println(h);
		for(int i = 0; i<6;i++)
		{
			for(int j = 0; j<2;j++)
			{
				for(int m = 0; m<2;m++)
				{
					if(c.getFaces()[i].getSquares()[j][m].getColor() != c.getFaces()[i].getSolColor())
					{
						h = h+0.125;
						//System.out.println(c.getFaces()[i].getSquares()[j][m].getColor());
						//System.out.println(c.getFaces()[i].getSolColor());
					}
				}
			}
		}
		//System.out.println(h);
		return h;
		
	}
	//find out what of the each face should be set to. 
	public void defineSolColor(Cube cube)
	{
		//arraylist contains all the colors. 
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("#84A59D");
		colors.add("#98C1D9");
		colors.add("#E5989B");
		colors.add("#FFF3B0");
		colors.add("#BCB8B1");
		colors.add("#DDA15E");
		//Face[] f = SortFace();
		//in order to minimize h(n), go through each face, find out the number of squares of each color and 
		//sort the number. 
		int c[][] = new int [4][3];
		int max[];
		int maxInd;
		for (int m = 0; m < 6;m++)
		{
			c[0][0] = 0;
			c[0][1] = 0;
			c[0][2] = 0;
			c[1][0] = 0;
			c[1][1] = 0;
			c[1][2] = 1;
			c[2][0] = 0;
			c[2][1] = 1;
			c[2][2] = 0;
			c[3][0] = 0;
			c[3][1] = 1;
			c[3][2] = 1;
			//compare color of squares of with other squares
			if (cube.getFaces()[m].getSquares()[0][1].equals(cube.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			if (cube.getFaces()[m].getSquares()[1][0].equals(cube.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (cube.getFaces()[m].getSquares()[1][0].equals(cube.getFaces()[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			if (cube.getFaces()[m].getSquares()[1][1].equals(cube.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (cube.getFaces()[m].getSquares()[1][1].equals(cube.getFaces()[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			else if (cube.getFaces()[m].getSquares()[1][1].equals(cube.getFaces()[m].getSquares()[1][0]))
			{
				c[2][0]++;
			}
			int n = 0;
			//sort the numbers
			//the array contains the number is a 2D array
			//the first element of the subarray is the number, the second is the index of
			//the square.
			while (!isSort(c))
			{
				max = c[n];
				maxInd = n;
				for (int l = n;l<4;l++)
				{
					if(c[l][0] > max[0])
					{
						max = c[l];
						maxInd = l;
					}
					//if there are two colors with number 2, then use the origin color of the face.
					//this set a priority for the color which will minimize the number misplaced squares. 
					else if(cube.getFaces()[m].getSquares()[c[l][1]][c[l][2]].getColor() == cube.getFaces()[m].getOrigiColor() && c[l][0] == max[0])
					{
						max = c[l];
						maxInd = l;
					}
				}
				int temp[] = c[n];
				c[n] = max;
				c[maxInd] = temp;
				n++;
			}
			//if the colors arraylist has the color with the largest number, then set the
			//color to be the color with the largest number, it the color is not in the arraylist,
			//try the second large one. After setting the color, remove the used from the from arraylist. 
			int t;
			for(int h = 0; h<4;h++)
			{	
				if(colors.contains(cube.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor()))
				{
					cube.getFaces()[m].setSolColor(cube.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor());
					t = colors.indexOf(cube.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor());
					colors.remove(t);
					break;
				}
			}

		}
		//go through each face and find out if there are any faces who have not been set
		//if there are, then use the first color left in the arraylist and remove it after setting. 
		for(int m = 0; m<6;m++)
		{
			if(cube.getFaces()[m].getSolColor() == "")
			{
				cube.getFaces()[m].setSolColor(colors.get(0));
				colors.remove(0);
			}
		}
			
	}
	//this is a helper function to help define the color of each face
	//it helps decide of the numbers of colors have been sorted
	public boolean isSort(int arr[][])
	{
		if(!(arr[0][0] >= arr[1][0] && arr[0][0] >= arr[2][0] && arr[0][0] >= arr[3][0]))
		{
			return false;
		}
		if(!(arr[1][0] >= arr[2][0] && arr[1][0] >= arr[3][0]))
		{
			return false;
		}
		if(!(arr[2][0] >= arr[3][0]))
		{
			return false;
		}
		return true;		
	}

}
