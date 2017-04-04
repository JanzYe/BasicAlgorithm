package lyy.wjbzyzz.graph;
import lyy.wjbzyzz.search.LinearProbingHashST;
import edu.princeton.cs.algs4.In;


//����ͼ���Զ���������
//����ͼ  ����Ϊ�ַ��������Ӱ������Ա�����Ƕ���֮��Ĺ�����
// ��ָ���ָ����ָ�  �����ļ���ͬһ�е�Ϊ������ͨ��  �ļ���û����ʽ����V��E  
public class SymbolGraph {

	private LinearProbingHashST<String, Integer> st;  //����ͨ���������õ������������±꣩
	private String[] keys; //����-��������  ͨ���±�õ�������
	private Graph G;
	
	public SymbolGraph(String filename, String delim)  //�ļ���   �ָ���
	{
		st = new LinearProbingHashST<String, Integer>();  //�������ű�
		In in = new In(filename);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(delim);
			for(String s : a)
				if(!st.contains(s)) st.put(s, st.size());   //��ÿ�������Ӧһ����ֵ����
		}
		
		keys = new String[st.size()];
		for(String name : st)
			keys[st.get(name)] = name;  //���ݷ��ű�õ���������
		
		G = new Graph(keys.length);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(delim);
			int v  = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));   //����ͼ��ӱ���ͨ����
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
