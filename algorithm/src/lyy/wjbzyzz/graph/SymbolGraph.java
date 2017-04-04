package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.search.LinearProbingHashST;
import edu.princeton.cs.algs4.In;


//二分图能自动反向索引
//符号图  顶点为字符串（如电影名和演员名都是顶点之间的关联）
// 用指定分隔符分割  输入文件中同一行的为互相连通的  文件中没有显式给定V和E  
public class SymbolGraph {

	private LinearProbingHashST<String, Integer> st;  //用于通过顶点名得到索引（数组下标）
	private String[] keys; //索引-》顶点名  通过下标得到顶点名
	private Graph G;
	
	public SymbolGraph(String filename, String delim)  //文件名   分隔符
	{
		st = new LinearProbingHashST<String, Integer>();  //创建符号表
		In in = new In(filename);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(delim);
			for(String s : a)
				if(!st.contains(s)) st.put(s, st.size());   //将每个顶点对应一个数值索引
		}
		
		keys = new String[st.size()];
		for(String name : st)
			keys[st.get(name)] = name;  //根据符号表得到反向索引
		
		G = new Graph(keys.length);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(delim);
			int v  = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));   //无向图添加边连通顶点
		}
	}

	public boolean contains(String key)
	{ return st.contains(key); }
	
	public int index(String key)
	{ return st.get(key); }
	
	public String name(int v)
	{ return keys[v]; }
	
	public Graph G()
	{ return G; }
	
	
	
}
