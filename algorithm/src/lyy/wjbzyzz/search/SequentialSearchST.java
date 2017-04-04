package lyy.wjbzyzz.search;


//顺序查找  基于无序链表
public class SequentialSearchST<Key , Value> {

	private int N = 0;
	private Node head;
	
	private class Node
	{
		private Key key;
		private Value value;
		private Node next;
	
		public Node(Key key, Value value, Node node)
		{
			this.key = key;
		    this.value = value;
		    this.next = node;
		}
	}
	
	public int size()
	{
		return N;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public Value get(Key key)
	{
		if(isEmpty()) return null;
		Node temp = head;
		while(temp != null)
		{
			if(temp.key.equals(key)) return temp.value;
			temp = temp.next;
		}
		return null;
	}
	
	public void put(Key key, Value value)
	{
		for(Node temp = head; temp != null; temp = temp.next)
		{
			if(temp.key.equals(key)) 
			{
				temp.value = value;
				return;
			}
		}
		head = new Node(key, value, head);
		N++;
	}
	
	public void delete(Key key)
	{
		if(head.key.equals(key)) 
		{
			head = head.next;
			N--;
			return;
		}
		Node temp = head;
		while(temp.next != null)
		{
			if(temp.next.key.equals(key))
			{
				temp.next = temp.next.next;
				N--;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void show()
	{
		for(Node temp = head; temp != null; temp = temp.next)
		{
			System.out.print(temp.key+"\t");
		}
		System.out.println(size());
	}
	
	
}
