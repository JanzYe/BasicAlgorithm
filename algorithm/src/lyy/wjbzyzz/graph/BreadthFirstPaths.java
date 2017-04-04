package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.algorithm.Stack;


//�������s�����ж�������·��
public class BreadthFirstPaths {

	private boolean[] marked; //���ڱ�־�±�����Ӧ�Ķ�������������Ƿ���ͨ
	private int[] edgeTo;  //����㵽һ��������֪·�������һ������  ����union find
	private final int s;  //���
	
	public BreadthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	//�������붥��s��ͨ�Ķ�����Ϊtrue 
	private void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty())
		{
			int v = queue.dequeue();
			for(int w : G.adj(v))
			{
				if(!marked[w])
				{
					marked[w] = true;
					edgeTo[w] = v;
					queue.enqueue(w);
				}
			}
		}
		
	}
	
	public boolean hasPathTo(int v)
	{ return marked[v]; }
	
	public Iterable<Integer> pathTo(int v)
	{ 
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		while(v != s)
		{
			//System.out.println(v);
			path.push(v);
			v = edgeTo[v];
		}
		path.push(s);
		//System.out.println("path length:"+path.size());
		return path;
	}
	
	public String pathToString(int v)
	{
		String str = s +"->"+ v + ":\n";
		for(int w : pathTo(v))
			str += w+"->";
		return str;
	}
	
	//ͼ�Ƿ�ȫ��ͨ
	public boolean isAllConnected()
	{
		for(int i = 0; i < marked.length; i++)
			if(!marked[i]) return false;
		return true;
	}
	
}
