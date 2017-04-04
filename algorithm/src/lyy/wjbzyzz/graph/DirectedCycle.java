package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;



//���ڲ�������ͼ�Ƿ���ڻ�
public class DirectedCycle {

	//����������Ƿ�һ�����㱻�������β����ж��Ƿ��л����ǲ�ͬ·���ľ���ͬһ����
	private boolean[] marked;  //��Ƕ����Ƿ񱻷��ʹ� 
	private boolean[] onStack;  //�ݹ�ʱһ��·���ϵĶ��� ������ظ��� ���л�
	private Stack<Integer> cycle;  //���е����ж��� ������ڻ�
	private int[] edgeTo;  //����㵽һ��������֪·�������һ������  ����union find 

	
	public DirectedCycle(Digraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new int[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
	}
	
	public DirectedCycle(EdgeWeightedDigraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new int[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
	}
	
	private void dfs(Digraph Dg, int v)
	{
		marked[v] = true;
		onStack[v] = true;
		for(int w : Dg.adj(v))
		{
			if(hasCycle()) return;
			else if(!marked[w]) 
			{
				edgeTo[w] = v; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;  //һ��·���ж����  onStack���������
	}
	
	private void dfs(EdgeWeightedDigraph Dg, int v)
	{
		marked[v] = true;
		onStack[v] = true;
		for(DirectedEdge e : Dg.adj(v))
		{
			int w = e.to();
			if(hasCycle()) return;
			else if(!marked[w]) 
			{
				edgeTo[w] = v; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;  //һ��·���ж����  onStack���������
	}
	
	public boolean hasCycle()
	{ return cycle != null; }
	
	public Iterable<Integer> cycle()
	{ return cycle; }
	
}
