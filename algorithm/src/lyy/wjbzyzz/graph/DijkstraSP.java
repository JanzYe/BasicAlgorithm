package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;
import edu.princeton.cs.algs4.IndexMinPQ;



//加权有向图 最短路径的Dijkstra算法  所需时间与ElogV成正比 不支持负权重
//从顶点s开始 不断向树中添加离起点最近的非树顶点
public class DijkstraSP {

	private double[] distTo;  //distTo[v]为顶点v到起点s的最短距离
	private DirectedEdge[] edgeTo; //edgeTo[v]为起点到v的最短路径的最后一条边
	private IndexMinPQ<Double> pq; //选出distTo最短的顶点
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
		
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
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
			
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
	
}
