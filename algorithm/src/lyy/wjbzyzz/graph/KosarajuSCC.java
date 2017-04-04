package lyy.wjbzyzz.graph;


//�õ�����ǿ��ͨ����    KosarajuStrongConnectedComponent
public class KosarajuSCC {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ�ǿ��ͨ
	private int[] id;  //ͬunionfind ֵ��ͬ�ı�ʾǿ��ͨ
	private  int count;  //��ͨ��ʶ id[i] ��ֵ��0��count-1֮��
	
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
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue
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
