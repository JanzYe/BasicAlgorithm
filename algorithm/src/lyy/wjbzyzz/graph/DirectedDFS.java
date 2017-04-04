package lyy.wjbzyzz.graph;


public class DirectedDFS {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ���ͨ
	private int count;  //�����������ͨ�Ķ������
	
	//�õ��붥��s��ͨ�����ж���
	
	
	
	public DirectedDFS(Digraph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	//�õ�������sources�����ж�����ͨ�Ķ���
	public DirectedDFS(Digraph G,Iterable<Integer> sources)
	{
		marked = new boolean[G.V()];
		for(int s : sources)
		{
			if(!marked[s]) dfs(G,s);
		}
	}
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue
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
	
	//ͼ�Ƿ�ȫ��ͨ
		public boolean isAllConnected()
		{
			return count == marked.length;
		}
		
}
