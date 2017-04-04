package lyy.wjbzyzz.search;


//������������ɢ�б�  M��ɢ��ֵ  ƽ��������ΪN/M  M��õ���N
//M<N �ڴ�ռ�ý�С �ٶ����½� M>N �˷��˵��ڴ� �ٶȿ�
public class SeparateChaininghashST<Key, Value> {

	private int N = 0;  // ��ֵ������
	private int M = 20; //ɢ�б��С
	private SequentialSearchST<Key, Value>[] st;
	

	public SeparateChaininghashST()
	{
		this(20);
	}
	
	public SeparateChaininghashST(int M)
	{
		this.M = M;
		st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
		for(int i = 0; i < M; i++)
		{
			st[i] = new SequentialSearchST();
		}
	}
	
	public int size()
	{
		N = 0;
		for(int i = 0; i < M; i++)
		{
			N += st[i].size();
		}
		return N ;
	}
	
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key)
	{
		return (Value)(st[hash(key)].get(key));
	}
	
	public void put(Key key, Value value)
	{
		st[hash(key)].put(key,value);
	}
	
	public void delete(Key key)
	{
		st[hash(key)].delete(key);
	}
	
}
