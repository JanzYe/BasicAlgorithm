package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;



//最小生成树的Kruskal算法   能实现各种无向图  但慢  
//添加剩下的最短边到树中  判断是否有环  有环则撤销添加  直到得到V-1条边
public class KruskalMST {

	private Queue<Edge> mst; //保存最小生成树的边
	private MinPQ<Edge> pq;  //从所有边中得到最小边
	private WeightedQuickUnionFind uf;  //用于判断无效边
	
	public KruskalMST(EdgeWeightedGraph G)
	{
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>(G.edges());
		uf = new WeightedQuickUnionFind(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if(uf.connected(v, w)) continue;  //在树中已连通  忽略失效的边
			uf.union(v, w);  //未连通 则有效 连通  用于以后排除无效边
			mst.enqueue(e);
		}
		
	}
	
	
	
	public Iterable<Edge> edges()
	{ return mst; }
	
	//返回最小生成树的权重
	public double weight()
	{
		double weight = 0;
		for(Edge e : edges())
			weight += e.weight();
		return weight;
	}
	
	
}
