package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.algorithm.Stack;




//�����л���Ȩ����ͼ�����·���Ļ��ڶ��е�BellmanFord�㷨 
//����ʱ�����EV������ �޸�Ȩ�ػ�������±�ͨ��Bellmanford�㷨��Ч�ܶ�  ֧�ָ�Ȩ��  
//�ж��Ƿ���ڸ�Ȩ�ػ�  ���������ܽ���������������Ƶ������������ �ҳ����·������

public class BellmanFordSP {

	private double[] distTo;  //distTo[v]Ϊ����v�����s����̾���
	private DirectedEdge[] edgeTo; //edgeTo[v]Ϊ��㵽v�����·�������һ����
	private Queue<Integer> q;  //��ű������˵Ķ���  ֻ���뱻�����˵Ķ��������ı߲��п��ܱ�����   ����������
	private boolean[] onQ;  //�����Ƿ��Ѵ����ڶ�����  ��ֹ�ظ����
	private int cost;  //relax�����õĴ���
	private Iterable<DirectedEdge> cycle;  //edgeTo���Ƿ���ڸ�Ȩ�ػ�
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		q = new Queue<Integer>();
		onQ = new boolean[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		
		q.enqueue(s);
		onQ[s] = true;
		
		while(!q.isEmpty() && !this.hasNegativeCycle())
		{
			int v = q.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
		
	}
	
	
	//���¶���v��ȥ�����б���һ���㵽�����̾���
	private void relax(EdgeWeightedDigraph G, int v)
	{
		for(DirectedEdge e : G.adj(v))
		{
			int w = e.to();
			
			if(distTo[w] > distTo[v] + e.weight())
			{
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w])
				{
					q.enqueue(w);
					onQ[w] = true;
				}
			}
		}
		
		if(cost++ % G.V() == 0)
			findNegativeCycle();
			
	}
	
	//������㵽v�����·��
	public Iterable<DirectedEdge> pathTo(int v)
	{ 
		if(!hasPathTo(v)) return null;
		
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		
		DirectedEdge e = edgeTo[v];
		while(e != null)
		{
			path.push(e);
			e = edgeTo[e.from()];
		}
		
		return path; 
	}
	
	//�������·���ĳ���
	public double distTo(int v)
	{
		return distTo[v];
	}
	
	//�Ƿ������·����s������v
	public boolean hasPathTo(int v)
	{
		return distTo[v] != Double.POSITIVE_INFINITY;
	}
	
	private void findNegativeCycle()
	{
		int V = edgeTo.length;
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
		for(int v = 0; v < V; v++)
			if(edgeTo[v] != null)
				G.addEdge(edgeTo[v]);
		
		EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(G);
		cycle = cf.cycle();
		
	}
	
	public boolean hasNegativeCycle()
	{
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> negativeCycle()
	{
		return cycle;
	}
	
}
