package lyy.wjbzyzz.graph;

import edu.princeton.cs.algs4.In;
import lyy.wjbzyzz.algorithm.Bag;




//加权有向图  基于Bag数组   
//也可以用符号表（更灵活 支持更多操作 删除添加顶点 但可能效率会下降logV 也更复杂）
public class EdgeWeightedDigraph {

	private int V;  //顶点数量
	private int E ; //边的数量
	private Bag<DirectedEdge>[] adj; // 邻接表 
	//private Bag<DirectedEdge> edges; // 所有边 
	
	public EdgeWeightedDigraph(int V)
	{
		this.V = V;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		//edges = (Bag<DirectedEdge>)new Bag();
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in)
	{
		/*this(in.readInt());  //读取V并初始化该类
		int E = in.readInt();  //读取E
		//读取边
		for(int i = 0; i < E; i++)
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}*/
	}
	
	//添加一条边
	public void addEdge(DirectedEdge edge)
	{
		adj[edge.from()].add(edge);
		
		//edges.add(edge);//这样耗费空间
		
		E++;
	}
	
	public int V() { return V; }
	public int E() { return E; }
	
	//返回与顶点v相邻的所有边
	public Iterable<DirectedEdge> adj(int v)
	{
		return adj[v];
	}
	
	//返回该图的所有边
		public Iterable<DirectedEdge> edges()
		{
			//要是在这里遍历邻接表则耗费时间
			Bag<DirectedEdge> edges = (Bag<DirectedEdge>)new Bag();
			for(int v = 0; v < V; v++)
				for( DirectedEdge e : adj(v))
					edges.add(e);
			
			return edges;  
		}
	
	//返回顶点v的度数 即相邻顶点的个数
	public int degree(int v)
	{
		return adj[v].size();
	}
	
	//找出所有顶点中度数最大的
	public int maxDegree()
	{
		int max = 0;
		for(int v = 0; v < V; v++)
		{
			if(degree(v) > max) max = degree(v);
			v++;
		}
		return max;
	}
	
	//图的平均度数 
	public double avgDegree()
	{
		return 2*E/V;
	}
	
	/*
	//返回自环的个数
	public int numberOfSelfLoops()
	{
		int count = 0;
		for(int v = 0; v < V; v++)
			for(int w : adj[v])
				if(v == w) count++;
		return count;
	}
	
	//邻接表的字符串表示
	public String toString()
	{
		String s = V + " vertices " + E + " edges\n";
		for(int v = 0; v < V; v++)
		{
			s += v + ": ";
			for(int w : adj[v])
			{
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	*/

}
