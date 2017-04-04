package lyy.wjbzyzz.graph;


public class DirectedDFS {

	private boolean[] marked; //用于标志下标所对应的顶点与给定顶点是否连通
	private int count;  //与给定顶点连通的顶点个数
	
	//得到与顶点s连通的所有顶点
	
	
	
	public DirectedDFS(Digraph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	//得到所有与sources中所有顶点连通的顶点
	public DirectedDFS(Digraph G,Iterable<Integer> sources)
	{
		marked = new boolean[G.V()];
		for(int s : sources)
		{
			if(!marked[s]) dfs(G,s);
		}
	}
	
	//将所有与顶点s连通的顶点标记为true
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G,w);
	}
	
	public boolean marked(int v)
	{ return marked[v]; }
	
	public int count()
	{ return count; }
	
	//图是否全连通
		public boolean isAllConnected()
		{
			return count == marked.length;
		}
		
}
