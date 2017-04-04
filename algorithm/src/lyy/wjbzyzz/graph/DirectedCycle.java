package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;



//用于查找有向图是否存在环
public class DirectedCycle {

	//单单用这个是否一个顶点被访问两次不能判断是否有环还是不同路径的经过同一顶点
	private boolean[] marked;  //标记顶点是否被访问过 
	private boolean[] onStack;  //递归时一条路径上的顶点 如果有重复的 则有环
	private Stack<Integer> cycle;  //环中的所有顶点 如果存在环
	private int[] edgeTo;  //从起点到一个顶点已知路径的最后一个顶点  类似union find 

	
	public DirectedCycle(Digraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new int[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
	}
	
	public DirectedCycle(EdgeWeightedDigraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new int[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
	}
	
	private void dfs(Digraph Dg, int v)
	{
		marked[v] = true;
		onStack[v] = true;
		for(int w : Dg.adj(v))
		{
			if(hasCycle()) return;
			else if(!marked[w]) 
			{
				edgeTo[w] = v; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;  //一条路径判断完毕  onStack数组标记清空
	}
	
	private void dfs(EdgeWeightedDigraph Dg, int v)
	{
		marked[v] = true;
		onStack[v] = true;
		for(DirectedEdge e : Dg.adj(v))
		{
			int w = e.to();
			if(hasCycle()) return;
			else if(!marked[w]) 
			{
				edgeTo[w] = v; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;  //一条路径判断完毕  onStack数组标记清空
	}
	
	public boolean hasCycle()
	{ return cycle != null; }
	
	public Iterable<Integer> cycle()
	{ return cycle; }
	
}
