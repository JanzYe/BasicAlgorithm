package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;



//��С��������Kruskal�㷨   ��ʵ�ָ�������ͼ  ����  
//���ʣ�µ���̱ߵ�����  �ж��Ƿ��л�  �л��������  ֱ���õ�V-1����
public class KruskalMST {

	private Queue<Edge> mst; //������С�������ı�
	private MinPQ<Edge> pq;  //�����б��еõ���С��
	private WeightedQuickUnionFind uf;  //�����ж���Ч��
	
	public KruskalMST(EdgeWeightedGraph G)
	{
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>(G.edges());
		uf = new WeightedQuickUnionFind(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if(uf.connected(v, w)) continue;  //����������ͨ  ����ʧЧ�ı�
			uf.union(v, w);  //δ��ͨ ����Ч ��ͨ  �����Ժ��ų���Ч��
			mst.enqueue(e);
		}
		
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
