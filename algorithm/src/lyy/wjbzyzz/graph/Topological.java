package lyy.wjbzyzz.graph;



//有向无环图的拓扑排序    解决优先级条件下的执行顺序问题
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
	
	//图是否是无环的
	public boolean isDAG()
	{ return order != null; }
	
}
