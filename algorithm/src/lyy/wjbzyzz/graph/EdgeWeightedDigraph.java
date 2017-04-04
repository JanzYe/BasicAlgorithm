package lyy.wjbzyzz.graph;

import edu.princeton.cs.algs4.In;
import lyy.wjbzyzz.algorithm.Bag;




//��Ȩ����ͼ  ����Bag����   
//Ҳ�����÷��ű������ ֧�ָ������ ɾ����Ӷ��� ������Ч�ʻ��½�logV Ҳ�����ӣ�
public class EdgeWeightedDigraph {

	private int V;  //��������
	private int E ; //�ߵ�����
	private Bag<DirectedEdge>[] adj; // �ڽӱ� 
	//private Bag<DirectedEdge> edges; // ���б� 
	
	public EdgeWeightedDigraph(int V)
	{
		this.V = V;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		//edges = (Bag<DirectedEdge>)new Bag();
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in)
	{
		/*this(in.readInt());  //��ȡV����ʼ������
		int E = in.readInt();  //��ȡE
		//��ȡ��
		for(int i = 0; i < E; i++)
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}*/
	}
	
	//���һ����
	public void addEdge(DirectedEdge edge)
	{
		adj[edge.from()].add(edge);
		
		//edges.add(edge);//�����ķѿռ�
		
		E++;
	}
	
	public int V() { return V; }
	public int E() { return E; }
	
	//�����붥��v���ڵ����б�
	public Iterable<DirectedEdge> adj(int v)
	{
		return adj[v];
	}
	
	//���ظ�ͼ�����б�
		public Iterable<DirectedEdge> edges()
		{
			//Ҫ������������ڽӱ���ķ�ʱ��
			Bag<DirectedEdge> edges = (Bag<DirectedEdge>)new Bag();
			for(int v = 0; v < V; v++)
				for( DirectedEdge e : adj(v))
					edges.add(e);
			
			return edges;  
		}
	
	//���ض���v�Ķ��� �����ڶ���ĸ���
	public int degree(int v)
	{
		return adj[v].size();
	}
	
	//�ҳ����ж����ж�������
	public int maxDegree()
	{
		int max = 0;
		for(int v = 0; v < V; v++)
		{
			if(degree(v) > max) max = degree(v);
			v++;
		}
		return max;
	}
	
	//ͼ��ƽ������ 
	public double avgDegree()
	{
		return 2*E/V;
	}
	
	/*
	//�����Ի��ĸ���
	public int numberOfSelfLoops()
	{
		int count = 0;
		for(int v = 0; v < V; v++)
			for(int w : adj[v])
				if(v == w) count++;
		return count;
	}
	
	//�ڽӱ���ַ�����ʾ
	public String toString()
	{
		String s = V + " vertices " + E + " edges\n";
		for(int v = 0; v < V; v++)
		{
			s += v + ": ";
			for(int w : adj[v])
			{
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	*/

}
