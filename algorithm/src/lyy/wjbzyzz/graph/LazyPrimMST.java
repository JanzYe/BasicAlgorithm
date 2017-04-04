package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;



//��Ȩ����ͼ ��С��������Prim�㷨����ʱʵ��
//�Ӷ���0��ʼ ����ѡ��һ�����������ж���һ���㲻�����е���̵ı��������С������
//������ʱʵ�ֻᱣ��ʧЧ�ı� ��v-w-j�������еĵ�  ��v-j����ʧЧ��
public class LazyPrimMST {

	private boolean[] marked;  //��С�������Ķ���
	private Queue<Edge> mst; //��С�������ı�
	private MinPQ<Edge> pq; //���б� ����ʧЧ�ı�
	
	public LazyPrimMST(EdgeWeightedGraph G)
	{
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		
		visit(G, 0);  //����G����ͨ��
		while(!pq.isEmpty())
		{
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.enqueue(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v)
	{
		//������v���Ϊ�ѷ���  ������v����������һ���㲻�����еı߼��뵽���ȶ�����
		marked[v] = true;
		for(Edge e : G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
	}
	
	public Iterable<Edge> edges()
	{ return mst; }
	
	//������С��������Ȩ��
	public double weight()
	{
		double weight = 0;
		for(Edge e : edges())
			weight += e.weight();
		return weight;
	}
	
}
