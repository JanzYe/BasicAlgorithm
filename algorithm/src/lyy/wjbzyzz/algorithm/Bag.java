package lyy.wjbzyzz.algorithm;
import java.util.Iterator;



//注意Stack Queue 等的长度为零时  不要调用iterator  因为没有数据  是null 会报错

//用链表实现  
public class Bag<Item> implements Iterable<Item>{

	private Node first;
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
	
	public void add(Item item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next =oldFirst;
		N++;
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
