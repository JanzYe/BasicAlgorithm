package lyy.wjbzyzz.algorithm;
import java.util.Iterator;


//ע��Stack Queue �ȵĳ���Ϊ��ʱ  ��Ҫ����iterator  ��Ϊû������  ��null �ᱨ��

//�ܹ���̬���������С��ʵ��
public class ResizingArrayStack<Item> {

	private Item[] a = (Item[])new Object[1];  //�洢���ݵ�����
	private int N = 0;  //��Ч���ݳ���
	
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
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	
	public void push(Item item)
	{
		if(N==a.length)
			resize(2*N);
		a[N++] = item;
	}
	
	public Item pop()
	{
		if(isEmpty())
			return null;
		Item item = a[--N];
		a[N] = null; //�����������
		if( N > 0 && a.length/4 == N)
			resize(a.length/2);
		return item;
	}
	
	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
		
	}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		int i =N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];  //����ȳ�ԭ��
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
