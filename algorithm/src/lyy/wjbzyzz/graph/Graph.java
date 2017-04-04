package lyy.wjbzyzz.graph;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Bag;

import edu.princeton.cs.algs4.In;



//����ͼ  ����Bag����   
//Ҳ�����÷��ű������ ֧�ָ������ ɾ����Ӷ��� ������Ч�ʻ��½�logV Ҳ�����ӣ�
public class Graph {

	private int V;  //��������
	private int E ; //�ߵ�����
	private Bag<Integer>[] adj; // �ڽӱ� 
	
	public Graph(int V)
	{
		this.V = V;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<Integer>();
		}
	}
	
	public Graph(In in)
	{
		this(in.readInt());  //��ȡV����ʼ������
		int E = in.readInt();  //��ȡE
		//��ȡ��
		for(int i = 0; i < E; i++)
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	
	//���һ����
	public void addEdge(int v, int w)
	{
		adj[v].add(w);  //��w��ӵ�v��������
		adj[w].add(v);  //��v��ӵ�w��������
		E++;
	}
	
	public int V() { return V; }
	public int E() { return E; }
	
	//�����붥��v���ڵ����ж���
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
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
	
}
