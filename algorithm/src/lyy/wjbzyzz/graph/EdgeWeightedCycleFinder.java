package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;



//用于查找加权有向图是否存在负权重环
public class EdgeWeightedCycleFinder {

	//单单用这个是否一个顶点被访问两次不能判断是否有环还是不同路径的经过同一顶点
	private boolean[] marked;  //标记顶点是否被访问过 
	private boolean[] onStack;  //递归时一条路径上的顶点 如果有重复的 则有环
	private Stack<DirectedEdge> cycle;  //环中的所有顶点 如果存在环
	private DirectedEdge[] edgeTo;  //从起点到一个顶点已知路径的最后一条边  类似union find 
	

	
	public EdgeWeightedCycleFinder(EdgeWeightedDigraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new DirectedEdge[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
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
				edgeTo[w] = e; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<DirectedEdge>();
				for(int x = v; x != w; x = edgeTo[x].from() )
					cycle.push(edgeTo[x]);
				cycle.push(edgeTo[w]);
				//cycle.push(edgeTo[v]);
			}
		}
		
		//判断环的权重是否为负
		double weight = 0;
		for(DirectedEdge e : cycle)
			weight += e.weight();
		if(weight > 0) cycle = null;
		
		onStack[v] = false;  //一条路径判断完毕  onStack数组标记清空
	}
	
	public boolean hasCycle()
	{ return cycle != null; }
	
	public Iterable<DirectedEdge> cycle()
	{ return cycle; }
	
}
