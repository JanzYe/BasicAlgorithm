package lyy.wjbzyzz.graph;

//加权无向的边
public class Edge implements Comparable<Edge> {

	private final int v;  //顶点
	private final int w;  //另一个顶点
	private final double weight;  //两个顶点间边的权重
	
	public Edge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight()
	{ return weight; }
	
	public int either()
	{return v; }
	
	public int other(int x)
	{
		if(x==v) return w;
		else if(x==w) return v;
		else return -1;
	}
	
	@Override
	public int compareTo(Edge edge) {
		// TODO Auto-generated method stub
		if(this.weight() < edge.weight()) return -1;
		else if(this.weight() > edge.weight()) return +1;
		else return 0;
	}
	
	public String toString()
	{
		return String.format("%d-%d %.2f", v, w, weight);
	}

}
