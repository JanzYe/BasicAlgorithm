package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;


public class DepthFirstPaths {

	private boolean[] marked; //用于标志下标所对应的顶点与给定顶点是否连通
	private int[] edgeTo;  //从起点到一个顶点已知路径的最后一个顶点  类似union find
	private final int s;  //起点
	
	public DepthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	//将所有与顶点s连通的顶点标记为true
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]) 
			{
				edgeTo[w] = v;
				dfs(G,w);
			}
	}
	
	public boolean hasPathTo(int v)
	{ return marked[v]; }
	
	public Iterable<Integer> pathTo(int v)
	{ 
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		while(v != s)
		{
			//System.out.println(v);
			path.push(v);
			v = edgeTo[v];
		}
		path.push(s);
		//System.out.println("path length:"+path.size());
		return path;
	}
	
	public String pathToString(int v)
	{
		String str = s +"->"+ v + ":\n";
		for(int w : pathTo(v))
			str += w+"->";
		return str;
	}
	
	//图是否全连通
		public boolean isAllConnected()
		{
			for(int i = 0; i < marked.length; i++)
				if(!marked[i]) return false;
			return true;
		}
	
}
