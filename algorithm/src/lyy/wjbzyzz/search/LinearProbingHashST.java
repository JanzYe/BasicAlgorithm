package lyy.wjbzyzz.search;
import java.util.Iterator;



//线性探测法散列表  N/M < 1/2较好 即空元素要多  这样才不会产生过长数簇  导致效率过低
public class LinearProbingHashST<Key, Value> implements Iterable<Key>{

	private int N = 0;
	private int M = 40;
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingHashST()
	{
		this(40);
	}
	
	public LinearProbingHashST(int M)
	{
		this.M = M;
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}
	
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void resize(int Msize)
	{
		LinearProbingHashST<Key, Value> st =
				 new LinearProbingHashST<Key, Value>(Msize);
		for(int i =0; i < M; i++)
		{
			if(keys[i] != null) st.put(keys[i], values[i]);
		}
		keys = st.keys;
		values = st.values;
		M = st.M;
	}
	
	public int size()
	{
		return N;
	}
	
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	public Value get(Key key)
	{
		int i = hash(key);
		while(keys[i] != null)
		{
			if(keys[i].equals(key)) return values[i];
			i = (i+1)%M;
		}
		return null;
	}
	
	public void put(Key key, Value value)
	{
		if(N >= M/2) resize(2*M);
		int i = hash(key);
		while(keys[i] != null)
		{
			if(keys[i].equals(key)) 
			{
				values[i] = value;
				return;
			}
			i++;
			if(i >= M) i = 0;
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}
	
	public void delete(Key key)
	{
		if(!contains(key)) return;
		int i = hash(key);
		while(!keys[i].equals(key))
		{
			i = (i+1)%M;
		}
		keys[i] = null;
		values[i] = null;
		i = (i+1)%M;
		while(keys[i] != null)
		{
			Key tempKey = keys[i];
			Value tempValue = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			put(tempKey, tempValue);
			i = (i+1)%M;
		}
		N--;
		
		if(N > 0 && N ==  M/8) resize(M/2);
	}
	
	public void show()
	{
		for(int i = 0; i < M; i++)
		{
			if(keys[i] != null) System.out.print(keys[i]+"\t");
		}
	}

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
		
	}
	
	private class ListIterator implements Iterator<Key>
	{
		int i = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while( i < N)
			{
				if(keys[i] == null) i++;
				return true;
			}
			return false;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return keys[i++];  
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
