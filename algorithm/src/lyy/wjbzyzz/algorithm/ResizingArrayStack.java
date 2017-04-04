package lyy.wjbzyzz.algorithm;
import java.util.Iterator;


//注意Stack Queue 等的长度为零时  不要调用iterator  因为没有数据  是null 会报错

//能够动态调整数组大小的实现
public class ResizingArrayStack<Item> {

	private Item[] a = (Item[])new Object[1];  //存储数据的数组
	private int N = 0;  //有效数据长度
	
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
		a[N] = null; //避免对象游离
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
			return a[--i];  //后进先出原则
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
