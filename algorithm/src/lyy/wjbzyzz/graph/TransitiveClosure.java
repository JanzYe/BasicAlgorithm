package lyy.wjbzyzz.graph;



//有向图中顶点对是否可达 
//能在常数时间内完成查询是否可达  但构造函数预处理需要V平方的空间及V(V+E)的时间
//更好的方法暂无
public class TransitiveClosure {

	private DirectedDFS[] all;   //用于存有向图深度优先搜索的引用
	
	
	public TransitiveClosure(Digraph G)
	{
		all = new DirectedDFS[G.V()];
		for(int v = 0; v < G.V(); v++)
			all[v] = new DirectedDFS(G, v);
	}
	
	//v是否能到达w
	public boolean reachable(int v, int w)
	{ return all[v].marked(w); }
}
