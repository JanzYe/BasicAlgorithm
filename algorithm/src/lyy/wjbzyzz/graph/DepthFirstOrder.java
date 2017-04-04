package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.algorithm.Stack;


//����ͼ�л���������������Ķ�������
public class DepthFirstOrder {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ���ͨ
	private Queue<Integer> pre;  //���ж����ǰ������
	private Queue<Integer> post;  //���ж���ĺ�������
	private Stack<Integer> reversePost;  //���ж������������� = ���������޻�������£�
	
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
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue
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
