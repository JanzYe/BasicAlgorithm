package lyy.wjbzyzz.search;


//基于拉链法的散列表  M个散列值  平均链表长度为N/M  M最好等于N
//M<N 内存占用较小 速度略下降 M>N 浪费了点内存 速度快
public class SeparateChaininghashST<Key, Value> {

	private int N = 0;  // 键值对总数
	private int M = 20; //散列表大小
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
