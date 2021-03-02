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
					h = h+0.125;
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
		Face[] f = SortFace();
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
			if (f[m].getSquares()[0][1].equals(f[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			if (f[m].getSquares()[1][0].equals(f[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (f[m].getSquares()[1][0].equals(f[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			if (f[m].getSquares()[1][1].equals(f[m].getSquares()[0][0]))
			{
				c[0][0]++;
			}
			else if (f[m].getSquares()[1][1].equals(f[m].getSquares()[0][1]))
			{
				c[1][0]++;
			}
			else if (f[m].getSquares()[1][1].equals(f[m].getSquares()[1][0]))
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
				}
				int temp[] = c[n];
				c[n] = max;
				c[maxInd] = temp;
				n++;
			}
			int t;
			for(int h = 0; h<4;h++)
			{		
				if(colors.contains(f[m].getSquares()[c[h][1]][c[h][2]].getColor()))
				{
					f[m].setSolColor(f[m].getSquares()[c[h][1]][c[h][2]].getColor());
					t = colors.indexOf(f[m].getSquares()[c[h][1]][c[h][2]].getColor());
					colors.remove(t);
					break;
				}
			}

		}
		for(int m = 0; m<6;m++)
		{
			if(f[m].getSolColor() == "")
			{
				f[m].setSolColor(colors.get(0));
				colors.remove(0);
			}
		}
			
	}
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
	public boolean isSortFace(Face arr[])
	{
		if(!(arr[0].getNumOfcolor() >= arr[1].getNumOfcolor()  && arr[0].getNumOfcolor()  >= arr[2].getNumOfcolor()  && arr[0].getNumOfcolor()  >= arr[3].getNumOfcolor() && arr[0].getNumOfcolor()  >= arr[4].getNumOfcolor() && arr[0].getNumOfcolor()  >= arr[5].getNumOfcolor()))
		{
			return false;
		}
		if(!(arr[1].getNumOfcolor() >= arr[2].getNumOfcolor() && arr[1].getNumOfcolor()>= arr[3].getNumOfcolor() && arr[1].getNumOfcolor()>= arr[4].getNumOfcolor() && arr[1].getNumOfcolor()>= arr[5].getNumOfcolor()))
		{
			return false;
		}
		if(!(arr[2].getNumOfcolor() >= arr[3].getNumOfcolor() && arr[2].getNumOfcolor() >= arr[4].getNumOfcolor() && arr[2].getNumOfcolor() >= arr[5].getNumOfcolor()))
		{
			return false;
		}
		if(!(arr[3].getNumOfcolor() >= arr[4].getNumOfcolor() && arr[3].getNumOfcolor() >= arr[5].getNumOfcolor()))
		{
			return false;
		}
		if(!(arr[4].getNumOfcolor() >= arr[5].getNumOfcolor()))
		{
			return false;
		}
		return true;		
	}
	public Face[] SortFace()
	{
		Face f[] = new Face[6];
		int c[][] = new int [4][3];
		int max[];
		int maxInd;
		Face maxN;
		int maxNInd;
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
				}
				int temp[] = c[n];
				c[n] = max;
				c[maxInd] = temp;
				n++;
			}
			head.state.getFaces()[m].setNumOfcolor(c[0][0]);
			f[m] = head.state.getFaces()[m];
		}
		int n = 0;
		while (!isSortFace(f))
		{
			maxN = f[n];
			maxNInd = n;
			for (int l = n;l<6;l++)
			{
				if(f[l].getNumOfcolor()> maxN.getNumOfcolor())
				{
					maxN = f[l];
					maxNInd = l;
				}
			}
			Face t= f[n];
			f[n] = maxN;
			f[maxNInd] = t;
			n++;
		}
		return f;
	}
}
