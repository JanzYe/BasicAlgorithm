package lyy.wjbzyzz.graph;

//加权无向的边
public class DirectedEdge implements Comparable<DirectedEdge> {

	private final int v;  //顶点
	private final int w;  //另一个顶点
	private final double weight;  //两个顶点间边的权重
	
	public DirectedEdge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight()
	{ return weight; }
	
	public int from()
	{return v; }
	
	public int to()
	{
		return w;
	}
	
	@Override
	public int compareTo(DirectedEdge edge) {
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
