package lyy.wjbzyzz.graph;

import lyy.wjbzyzz.algorithm.Stack;




//无环加权有向图找最长路径最好的方法 Acyclic算法  所需时间与E+V成正比 支持负权重  
//按拓扑排序放松所有顶点
public class AcyclicLP {

	private double[] distTo;  //distTo[v]为顶点v到起点s的最短距离
	private DirectedEdge[] edgeTo; //edgeTo[v]为起点到v的最短路径的最后一条边
	
	public AcyclicLP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.NEGATIVE_INFINITY;
		distTo[s] = 0;
		
		Topological topo = new Topological(G);
		for(int v : topo.order())
			relax(G, v);
		
	}
	
	
	//更新顶点v出去的所有边另一顶点到起点最短距离
	private void relax(EdgeWeightedDigraph G, int v)
	{
		for(DirectedEdge e : G.adj(v))
		{
			int w = e.to();
			if(distTo[w] < distTo[v] + e.weight())
			{
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
			
	}
	
	//返回起点到v的最长路径
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
	
	//返回最长路径的长度
	public double distTo(int v)
	{
		return distTo[v];
	}
	
	//是否有最长路径由s到顶点v
	public boolean hasPathTo(int v)
	{
		return distTo[v] != Double.NEGATIVE_INFINITY;
	}
	
}
