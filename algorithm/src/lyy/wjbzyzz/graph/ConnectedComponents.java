package lyy.wjbzyzz.graph;


//得到所有连通分量  与union find比 跟适合利用已有图结构的情况  其他情况unionfind更好
public class ConnectedComponents {

	private boolean[] marked; //用于标志下标所对应的顶点与给定顶点是否连通
	private int[] id;  //同unionfind 值相同的表示连通
	private  int count;  //连通标识 id[i] 的值在0到count-1之间
	
	public ConnectedComponents(Graph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0; s < G.V(); s++)
		{
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
		}
	}
	
	//将所有与顶点s连通的顶点标记为true
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w]) 
			{
				dfs(G,w);
			}
	}
	
	public boolean isConnected(int v, int w)
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
