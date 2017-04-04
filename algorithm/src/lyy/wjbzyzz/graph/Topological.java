package lyy.wjbzyzz.graph;



//�����޻�ͼ����������    ������ȼ������µ�ִ��˳������
public class Topological {

	private Iterable<Integer> order;
	
	public Topological(Digraph G)
	{
		DirectedCycle cycle = new DirectedCycle(G);
		if(!cycle.hasCycle())
		{
			DepthFirstOrder dfo = new DepthFirstOrder(G);
			order = dfo.reversePost();
		}
	}
	
	public Topological(EdgeWeightedDigraph G)
	{
		DirectedCycle cycle = new DirectedCycle(G);
		if(!cycle.hasCycle())
		{
			DepthFirstOrder dfo = new DepthFirstOrder(G);
			order = dfo.reversePost();
		}
	}
	
	
	
	public Iterable<Integer> order()
	{ return order; }
	
	//ͼ�Ƿ����޻���
	public boolean isDAG()
	{ return order != null; }
	
}
