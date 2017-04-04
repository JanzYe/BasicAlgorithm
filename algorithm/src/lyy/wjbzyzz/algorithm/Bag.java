package lyy.wjbzyzz.algorithm;
import java.util.Iterator;



//ע��Stack Queue �ȵĳ���Ϊ��ʱ  ��Ҫ����iterator  ��Ϊû������  ��null �ᱨ��

//������ʵ��  
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
			return item;  //����ȳ�ԭ��
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
