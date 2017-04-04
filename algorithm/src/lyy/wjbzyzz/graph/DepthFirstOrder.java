package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.algorithm.Stack;


//有向图中基于深度优先搜索的顶点排序
public class DepthFirstOrder {

	private boolean[] marked; //用于标志下标所对应的顶点与给定顶点是否连通
	private Queue<Integer> pre;  //所有顶点的前序排序
	private Queue<Integer> post;  //所有顶点的后序排序
	private Stack<Integer> reversePost;  //所有顶点的逆后序排序 = 拓扑排序（无环的情况下）
	
	public DepthFirstOrder(Digraph G)
	{
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		for(int v = 0; v < G.V(); v++)
			if(!marked[v]) dfs(G, v);
	}
	
	public DepthFirstOrder(EdgeWeightedDigraph G)
	{
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		for(int v = 0; v < G.V(); v++)
			if(!marked[v]) dfs(G, v);
	}
	
	//将所有与顶点s连通的顶点标记为true
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		pre.enqueue(v);
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G,w);
		post.enqueue(v);
		reversePost.push(v);
	}
	
	private void dfs(EdgeWeightedDigraph G, int v)
	{
		marked[v] = true;
		pre.enqueue(v);
		for(DirectedEdge e : G.adj(v))
			if(!marked[e.to()]) dfs(G,e.to());
		post.enqueue(v);
		reversePost.push(v);
	}
	
	
		
		public Iterable<Integer> pre()
		{ return pre; }
		public Iterable<Integer> post()
		{ return post; }
		public Iterable<Integer> reversePost()
		{ return reversePost; }
		
}
