package lyy.wjbzyzz.graph;



//����ͼ�ж�����Ƿ�ɴ� 
//���ڳ���ʱ������ɲ�ѯ�Ƿ�ɴ�  �����캯��Ԥ������ҪVƽ���Ŀռ估V(V+E)��ʱ��
//���õķ�������
public class TransitiveClosure {

	private DirectedDFS[] all;   //���ڴ�����ͼ�����������������
	
	
	public TransitiveClosure(Digraph G)
	{
		all = new DirectedDFS[G.V()];
		for(int v = 0; v < G.V(); v++)
			all[v] = new DirectedDFS(G, v);
	}
	
	//v�Ƿ��ܵ���w
	public boolean reachable(int v, int w)
	{ return all[v].marked(w); }
}
