package searchSolution;


import java.util.ArrayList;

import cubeClasses.*;

public class Solver 
{
	Node head;
	
	//instantiates a solver
	//This method takes the initial cube and returns a node(head) that will be plugged into one of the solving methods
	public Solver(Cube c)
	{

		head = new Node(c, null,"",0, 0);
	}
	//Iterative deepening search
	//Returns a node in which the state is solved, null if it cannot
	public void IDA()
	{
		//defineSolColor();
		//double s = heuristic(head.state);
		defineSolColor();
		double s = heuristic(head.state);
		head.thre = s;
		double min = 0; 
		//System.out.println(head.thre);
		
		Node n = DFS(head, head.thre, head.cost, min);
		//System.out.println(n);
		while(n.state == null && n.action == null && n.parent == null && n.cost == 0)
		{
			//System.out.println(n.action);
			n = DFS(head, n.thre, head.cost, min);
		}
		ArrayList<String> solution = new ArrayList<String>();
		Node current = n;
		int size = 0;
		//System.out.println(n.action);
		while(current.parent != null)
		{
			
			current = current.parent;
			solution.add(current.action);
			size ++;
		}
		for(int i=0; i<size-1;i++)
		{
			System.out.println(solution.get(i));
		}
		System.out.println("Done!");
	}
	//depth first search
	//It takes the requested depth as an int
	//Returns a Node in which the state is solved, null if it cannot
	public Node DFS(Node n, double threshold, double fn, double inc)
	{
		//double fn =cost + heuristic(n.getState());
		if(n.getState().isSolved())
		{
			return n;
		}
		if(fn > threshold)
		{
			Node fnode;
			if(inc < fn)
			{
				inc = fn;
			}
			fnode = new Node(null,null,null,0,inc);
			return fnode;
		}
		Node[] children = new Node[6];
		Cube cl = (Cube)n.getState().clone();
		cl.left(1);
		Node left = new Node(cl,n,"left",fn+1+heuristic(cl), threshold);
		Node tl = DFS(left, left.thre,left.cost,threshold);
		children[0] = tl;
		
		Cube cb = (Cube)n.getState().clone();
		cb.back(1);
		Node back = new Node(cb,n,"back",fn+1+heuristic(cb),threshold);
		Node tb =DFS(back, back.thre,back.cost,threshold);
		children[1] = tb;
		
		Cube cu = (Cube)n.getState().clone();
		cu.up(1);
		Node up = new Node(cu,n,"up",fn+1+heuristic(cu),threshold);
		Node tu =DFS(up, up.thre,up.cost,threshold);
		children[2] = tu;
		
		Cube cd = (Cube)n.getState().clone();
		cd.down(1);
		Node down = new Node(cd,n,"down",fn+1+heuristic(cd),threshold);
		Node td =DFS(down, down.thre,down.cost,threshold);
		children[3] = td;
		
		Cube cr = (Cube)n.getState().clone();
		cr.right(1);
		Node right = new Node(cr,n,"right",fn+1+heuristic(cr),threshold);
		Node tr =DFS(right, right.thre,right.cost,threshold);
		children[4] = tr;
		
		Cube cf = (Cube)n.getState().clone();
		cf.front(1);
		Node front = new Node(cf,n,"front",fn+1+heuristic(cf),threshold);
		Node tf =DFS(front, front.thre,front.cost,threshold);
		children[5] = tf;
		
		Node mini = new Node(null,null,null,0,0);
		for(int i = 0; i<6;i++)
		{
			//System.out.println(children[i]);
			if(children[i].state != null && children[i].state.isSolved())
			{
				return children[i];
			}
			//System.out.println(children[i]);
			if(children[i].state == null && children[i].action == null && children[i].parent == null && children[i].cost == 0)
			{
				if(mini.thre > children[i].thre);
				{
					mini = children[i];
				}
			}
		}
		return mini;
	}


    //this function is used to calculate the heuristic of the state
	//c: current state
	//h: heuristic function f(n)
	public double heuristic(Cube c)
	{
		double h = 0;
		for(int i = 0; i<6;i++)
		{
			for(int j = 0; j<2;j++)
			{
				for(int m = 0; m<2;m++)
				{
					if(c.getFaces()[i].getSquares()[j][m].getColor() != c.getFaces()[i].getSolColor())
					{
						h = h+0.125;
					}
				}
			}
		}
		return h;
		
	}
	public void defineSolColor()
	{
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("#84A59D");
		colors.add("#98C1D9");
		colors.add("#E5989B");
		colors.add("#FFF3B0");
		colors.add("#BCB8B1");
		colors.add("#DDA15E");
		//Face[] f = SortFace();
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
			if (head.state.getFaces()[m].getSquares()[0][1].equals(head.state.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			if (head.state.getFaces()[m].getSquares()[1][0].equals(head.state.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (head.state.getFaces()[m].getSquares()[1][0].equals(head.state.getFaces()[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			if (head.state.getFaces()[m].getSquares()[1][1].equals(head.state.getFaces()[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (head.state.getFaces()[m].getSquares()[1][1].equals(head.state.getFaces()[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			else if (head.state.getFaces()[m].getSquares()[1][1].equals(head.state.getFaces()[m].getSquares()[1][0]))
			{
				c[2][0]++;
			}
			int n = 0;
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
					else if(head.state.getFaces()[m].getSquares()[c[l][1]][c[l][2]].getColor() == head.state.getFaces()[m].getOrigiColor() && c[l][0] == max[0])
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
			int t;
			for(int h = 0; h<4;h++)
			{	
				if(colors.contains(head.state.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor()))
				{
					head.state.getFaces()[m].setSolColor(head.state.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor());
					t = colors.indexOf(head.state.getFaces()[m].getSquares()[c[h][1]][c[h][2]].getColor());
					colors.remove(t);
					break;
				}
			}

		}
		for(int m = 0; m<6;m++)
		{
			if(head.state.getFaces()[m].getSolColor() == "")
			{
				head.state.getFaces()[m].setSolColor(colors.get(0));
				colors.remove(0);
			}
		}
			
	}
	//this is a helper function to help define the color of each face
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
