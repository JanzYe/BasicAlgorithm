package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.algorithm.Stack;




//可能有环加权有向图找最短路径的基于队列的BellmanFord算法 
//所需时间最坏与EV成正比 无负权重环的情况下比通用Bellmanford算法高效很多  支持负权重  
//判断是否存在负权重环  不存在则能解决相对最后期限限制的任务调度问题 找出最短路径及树

public class BellmanFordSP {

	private double[] distTo;  //distTo[v]为顶点v到起点s的最短距离
	private DirectedEdge[] edgeTo; //edgeTo[v]为起点到v的最短路径的最后一条边
	private Queue<Integer> q;  //存放被放松了的顶点  只有与被放松了的顶点相连的边才有可能被放松   减少运算量
	private boolean[] onQ;  //顶点是否已存在于队列中  防止重复添加
	private int cost;  //relax被调用的次数
	private Iterable<DirectedEdge> cycle;  //edgeTo中是否存在负权重环
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		q = new Queue<Integer>();
		onQ = new boolean[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		
		q.enqueue(s);
		onQ[s] = true;
		
		while(!q.isEmpty() && !this.hasNegativeCycle())
		{
			int v = q.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
		
	}
	
	
	//更新顶点v出去的所有边另一顶点到起点最短距离
	private void relax(EdgeWeightedDigraph G, int v)
	{
		for(DirectedEdge e : G.adj(v))
		{
			int w = e.to();
			
			if(distTo[w] > distTo[v] + e.weight())
			{
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w])
				{
					q.enqueue(w);
					onQ[w] = true;
				}
			}
		}
		
		if(cost++ % G.V() == 0)
			findNegativeCycle();
			
	}
	
	//返回起点到v的最短路径
	public Iterable<DirectedEdge> pathTo(int v)
	{ 
		if(!hasPathTo(v)) return null;
		
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		
		DirectedEdge e = edgeTo[v];
		while(e != null)
		{
			path.push(e);
			e = edgeTo[e.from()];
		}
		
		return path; 
	}
	
	//返回最短路径的长度
	public double distTo(int v)
	{
		return distTo[v];
	}
	
	//是否有最短路径由s到顶点v
	public boolean hasPathTo(int v)
	{
		return distTo[v] != Double.POSITIVE_INFINITY;
	}
	
	private void findNegativeCycle()
	{
		int V = edgeTo.length;
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
		for(int v = 0; v < V; v++)
			if(edgeTo[v] != null)
				G.addEdge(edgeTo[v]);
		
		EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(G);
		cycle = cf.cycle();
		
	}
	
	public boolean hasNegativeCycle()
	{
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> negativeCycle()
	{
		return cycle;
	}
	
}
