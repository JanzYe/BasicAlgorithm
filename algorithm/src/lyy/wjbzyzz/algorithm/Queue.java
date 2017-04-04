package lyy.wjbzyzz.algorithm;
import java.util.Iterator;



//注意Stack Queue 等的长度为零时  不要调用iterator  因为没有数据  是null 会报错

//用链表实现
public class Queue<Item> implements Iterable<Item>{

	private Node first,last;
	private int N = 0;
	
	
	private class Node
	{
		Item item;
		Node next;
	};
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public int size()
	{
		return N;
	}
	
	public void enqueue(Item item)
	{
		//向队列尾部添加
			Node oldLast = last;
			last =  new Node();
			last.item = item;
			if(isEmpty())
				first = last;
			else
				oldLast.next = last;
		N++;
	}
	
	public Item dequeue()
	{
		if(isEmpty())
		{
			last = null;
			return null;
		}
		//将链表头弹出
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator()
	{
		return new ListIterator();
		
	}
	
	private class ListIterator implements Iterator<Item>
	{
		Node node = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return node != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = node.item;
			node = node.next;
			return item;  //后进先出原则
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
