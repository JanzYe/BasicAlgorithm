package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;



//加权有向图 最小生成树的Prim算法的延时实现
//从顶点0开始 不断选出一个顶点在树中而另一顶点不在树中的最短的边来组成最小生成树
//这种延时实现会保留失效的边 如v-w-j已是树中的点  则v-j就是失效的
public class LazyPrimMST {

	private boolean[] marked;  //最小生成树的顶点
	private Queue<Edge> mst; //最小生成树的边
	private MinPQ<Edge> pq; //横切边 包括失效的边
	
	public LazyPrimMST(EdgeWeightedGraph G)
	{
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		
		visit(G, 0);  //假设G是连通的
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
		//将顶点v标记为已访问  并将与v相连的且另一顶点不在树中的边加入到优先队列中
		marked[v] = true;
		for(Edge e : G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
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
