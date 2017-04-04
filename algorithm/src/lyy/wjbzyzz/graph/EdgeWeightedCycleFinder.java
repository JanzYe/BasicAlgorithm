package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;



//���ڲ��Ҽ�Ȩ����ͼ�Ƿ���ڸ�Ȩ�ػ�
public class EdgeWeightedCycleFinder {

	//����������Ƿ�һ�����㱻�������β����ж��Ƿ��л����ǲ�ͬ·���ľ���ͬһ����
	private boolean[] marked;  //��Ƕ����Ƿ񱻷��ʹ� 
	private boolean[] onStack;  //�ݹ�ʱһ��·���ϵĶ��� ������ظ��� ���л�
	private Stack<DirectedEdge> cycle;  //���е����ж��� ������ڻ�
	private DirectedEdge[] edgeTo;  //����㵽һ��������֪·�������һ����  ����union find 
	

	
	public EdgeWeightedCycleFinder(EdgeWeightedDigraph Dg)
	{
		marked = new boolean[Dg.V()];
		onStack = new boolean[Dg.V()];
		edgeTo = new DirectedEdge[Dg.V()];
		for(int v = 0; v < Dg.V(); v++)
			if(!marked[v]) 
				dfs(Dg, 0);
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
				edgeTo[w] = e; 
				dfs(Dg, w); 
			}
			else if(onStack[w])
			{
				cycle = new Stack<DirectedEdge>();
				for(int x = v; x != w; x = edgeTo[x].from() )
					cycle.push(edgeTo[x]);
				cycle.push(edgeTo[w]);
				//cycle.push(edgeTo[v]);
			}
		}
		
		//�жϻ���Ȩ���Ƿ�Ϊ��
		double weight = 0;
		for(DirectedEdge e : cycle)
			weight += e.weight();
		if(weight > 0) cycle = null;
		
		onStack[v] = false;  //һ��·���ж����  onStack���������
	}
	
	public boolean hasCycle()
	{ return cycle != null; }
	
	public Iterable<DirectedEdge> cycle()
	{ return cycle; }
	
}
