package lyy.wjbzyzz.graph;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Bag;

import edu.princeton.cs.algs4.In;



//无向图  基于Bag数组   
//也可以用符号表（更灵活 支持更多操作 删除添加顶点 但可能效率会下降logV 也更复杂）
public class Graph {

	private int V;  //顶点数量
	private int E ; //边的数量
	private Bag<Integer>[] adj; // 邻接表 
	
	public Graph(int V)
	{
		this.V = V;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<Integer>();
		}
	}
	
	public Graph(In in)
	{
		this(in.readInt());  //读取V并初始化该类
		int E = in.readInt();  //读取E
		//读取边
		for(int i = 0; i < E; i++)
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	
	//添加一条边
	public void addEdge(int v, int w)
	{
		adj[v].add(w);  //将w添加到v的链表中
		adj[w].add(v);  //将v添加到w的链表中
		E++;
	}
	
	public int V() { return V; }
	public int E() { return E; }
	
	//返回与顶点v相邻的所有顶点
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
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
	
}
