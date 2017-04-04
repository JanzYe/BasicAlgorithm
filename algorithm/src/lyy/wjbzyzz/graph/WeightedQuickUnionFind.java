package lyy.wjbzyzz.graph;

public class WeightedQuickUnionFind {
	
	private int[] id;   //���������飨�ɴ���������
	private int[] sz;   //�������ڵ�����Ӧ�ķ����Ĵ�С���ɴ���������
	private int count;  //��ͨ����������
	 
	public WeightedQuickUnionFind(int N)
	{
		count  = N;
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i < N; i++) 
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count()
	{
		return count;
	}
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	public int find(int p)
	{
		//���������ҵ����ڵ�
		while(p != id[p]) p = id[p];
		return p;
	}
	
	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		//��С���ĸ��ڵ����ӵ������ĸ��ڵ�
		if(sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else { id[j] = i; sz[i] += sz[j]; }
		count--;
		
	}
	
	public void result()
	{
		for(int i = 0; i < id.length; i++)
		{
			System.out.print(id[i]+"\t");
		}
	}
	
}
