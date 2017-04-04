package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Stack;




//�޻���Ȩ����ͼ�����·����õķ��� Acyclic�㷨  ����ʱ����E+V������ ֧�ָ�Ȩ��  
//���ܸ�Ϊ���·�� ��distToȫ����ʼ��Ϊ������   ���Ҹı�relax�в���ʽ�ķ��򼴿�
//����������������ж���  Ȼ���������̵ı�   
public class AcyclicSP {

	private double[] distTo;  //distTo[v]Ϊ����v�����s����̾���
	private DirectedEdge[] edgeTo; //edgeTo[v]Ϊ��㵽v�����·�������һ����
	
	public AcyclicSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		
		Topological topo = new Topological(G);
		for(int v : topo.order())
			relax(G, v);
		
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
