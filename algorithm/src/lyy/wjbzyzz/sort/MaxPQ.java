package lyy.wjbzyzz.sort;

//���ڶ���ѵ�������ȶ���
public class MaxPQ<Key extends Comparable<Key>> {

	private int N = 0;  //���г���
	private Key[] pq;  // �ѣ��±��1��ʼ������  pq[1]Ϊ���Ԫ��
	
	public MaxPQ(int maxN)
	{
		pq = (Key[])new Comparable[maxN+1];
	}
	
	public void insert(Key key)
	{
		if(N==pq.length)
			resize(2*N);
		pq[++N] = key;
		swim(N);
	}
	
	public Key delMax()
	{
		if(isEmpty())
			return null;
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		
		if( N > 0 && pq.length/4 == N)
			resize(pq.length/2);
		
		return max;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public int size()
	{
		return N;
	}
	
	private void resize(int max)
	{
		Key[] temp = (Key[])new Comparable[max];
		for(int i = 0; i < N; i++)
			temp[i] = pq[i];
		pq = temp;
	}
	
	public  boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j)
	{
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
    private void swim(int k)
    {
    	while(k > 1 && less(k/2, k))
    	{
    		exch(k/2, k);
    		k = k/2;
    	}
    }
    
    private void sink(int k)
    {
    	while(2*k <= N)
    	{
    		int j = 2*k;
    		if(j < N && less(j, j+1)) j++;
    		if(!less(k, j)) break;
    		exch(k, j);
    		k = j;
    	}
    }
    
    public  void show()
	{
		for(int i = 1; i <= N; i++)
		{
			System.out.print(pq[i]+"\t");
		}
	}
	
}
