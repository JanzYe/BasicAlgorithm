package lyy.wjbzyzz.graph;


//得到所有强连通分量    KosarajuStrongConnectedComponent
public class KosarajuSCC {

	private boolean[] marked; //用于标志下标所对应的顶点与给定顶点是否强连通
	private int[] id;  //同unionfind 值相同的表示强连通
	private  int count;  //连通标识 id[i] 的值在0到count-1之间
	
	public KosarajuSCC(Digraph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());
		for(int s : dfo.reversePost())
		{
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
		}
	}
	
	//将所有与顶点s连通的顶点标记为true
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w]) 
			{
				dfs(G,w);
			}
	}
	
	public boolean isStrongConnected(int v, int w)
	{ return id[v] == id[w]; }
	

	
		public int id(int v)
		{
			return id[v];
		}
		
		public int count()
		{ return count; }
	
		public void result()
		{
			for(int i = 0; i < id.length; i++)
			{
				System.out.print(id[i]+"\t");
			}
		}
}
