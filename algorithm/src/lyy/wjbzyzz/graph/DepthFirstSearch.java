package lyy.wjbzyzz.graph;


public class DepthFirstSearch {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ���ͨ
	private int count;  //�����������ͨ�Ķ������
	
	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue
	private void dfs(Graph G, int v)
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
	
	//ͼ�Ƿ�ȫ��ͨ
		public boolean isAllConnected()
		{
			return count == marked.length;
		}
		
}
