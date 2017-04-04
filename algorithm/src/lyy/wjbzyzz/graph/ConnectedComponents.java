package lyy.wjbzyzz.graph;


//�õ�������ͨ����  ��union find�� ���ʺ���������ͼ�ṹ�����  �������unionfind����
public class ConnectedComponents {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ���ͨ
	private int[] id;  //ͬunionfind ֵ��ͬ�ı�ʾ��ͨ
	private  int count;  //��ͨ��ʶ id[i] ��ֵ��0��count-1֮��
	
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
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue
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
