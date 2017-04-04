package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;
import edu.princeton.cs.algs4.IndexMinPQ;



//��Ȩ����ͼ ���·����Dijkstra�㷨  ����ʱ����ElogV������ ��֧�ָ�Ȩ��
//�Ӷ���s��ʼ ����������������������ķ�������
public class DijkstraSP {

	private double[] distTo;  //distTo[v]Ϊ����v�����s����̾���
	private DirectedEdge[] edgeTo; //edgeTo[v]Ϊ��㵽v�����·�������һ����
	private IndexMinPQ<Double> pq; //ѡ��distTo��̵Ķ���
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
		
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
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
			
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
	
}
