package lyy.wjbzyzz.search;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Queue;

//红黑二叉查找树
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private static boolean RED = true;
	private static boolean BLACK  = true;
	
	private class Node
	{
		private Key key;    //键
		private Value value;  //值
		private Node left, right;  //left 比该节点小的子节点树  right 比该结点大的子结点树
		private int N;  //已该结点为根的子结点总数
		private boolean color;  //父结点指向该结点的连接是否是红链接
		
		public Node(Key key, Value value, int N, boolean color)
		{
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}	
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node node)
	{
		if(node == null) return 0;
		return node.N;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	private boolean isRed(Node node)
	{
		if(node == null) return false;
		return node.color;
	}
	
	//右红链接转为左红链接 
	//父结点变为右子结点的左子结点 右子结点的的左子结点变为父节点的右子结点
	private Node rotateLeft(Node fa)
	{
		Node son = fa.right;
		fa.right = son.left;
		son.left = fa;
		son.color = fa.color;
		fa.color = RED;
		son.N = fa.N;
		fa.N = size(fa.left) + size(fa.right) +1;
		return son;
	}
	
	private Node rotateRight(Node fa)
	{
		Node son = fa.left;
		fa.left = son.right;
		son.right = fa;
		son.color = fa.color;
		fa.color = RED;
		son.N = fa.N;
		fa.N = size(fa.left) + size(fa.right) +1;
		return son;
	}
	
	private void flipColors(Node fa)
	{
		fa.left.color = BLACK;
		fa.right.color = BLACK;
		fa.color = RED;
	}
	
	public Value get(Key key)
	{
		return get(root, key);
	}
	
	private Value get(Node node, Key key)
	{
			if(node == null) return null;
			int cmp = key.compareTo(node.key);
			
			if(cmp == 0) return node.value;
			else if(cmp < 0) return get(node.left, key);
			else return get(node.right, key);
			
	}
	
	public void put(Key key, Value value)
	{
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	private Node put(Node node, Key key, Value value)
	{
		if(node == null)  return new Node(key, value, 1, RED);
		
		//这句移到这里能更适用于多线程  存在4结点
		//if(isRed(node.right) &&isRed(node.left)) flipColors(node);  
		
		int cmp = key.compareTo(node.key);
		if(cmp == 0) node.value = value;
		else if(cmp < 0)  node.left = put(node.left, key, value);
		else  node.right = put(node.right, key, value);
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if(node.left != null && isRed(node.left.left) && isRed(node.left)) node = rotateRight(node);
		if(isRed(node.right) &&isRed(node.left)) flipColors(node);
		
		node.N = size(node.left)+size(node.right)+1;
		return node;
		
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node node)
	{
		if(node == null) return null;
		else if(node.left == null) return node;
		else return min(node.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node node)
	{
		if(node == null) return null;
		else if(node.right == null) return node;
		else return max(node.right);
	}
	
	//小于等于key的最大键
	public Key floor(Key key)
	{
		Node node = floor(root,key);
		if(node == null) return null;
		return node.key;
	}
	
	private Node floor(Node node, Key key)
	{
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp ==0) return node;
		if(cmp < 0) return floor(node.left, key);
		Node temp = floor(node.right, key);
		if(temp != null) return temp;
		else return node;
		
	}
	
	//大于等于key的最小键
		public Key ceiling(Key key)
		{
			Node node = ceiling(root,key);
			if(node == null) return null;
			return node.key;
		}
		private Node ceiling(Node node, Key key)
		{
			if(node == null) return null;
			int cmp = key.compareTo(node.key);
			if(cmp ==0) return node;
			if(cmp > 0) return ceiling(node.right, key);
			Node temp = ceiling(node.left, key);
			if(temp != null) return temp;
			else return node;
			
		}
		
		public Key select(int k)
		{
			return select(root, k).key;
		}
		private Node select(Node node, int k)
		{
			if(node == null) return null;
			int temp = size(node.left);
			if(temp == k) return node;
			else if(k < temp) return select(node.left, k);
			else return select(node.right, k-temp-1);
		}
		
		//返回小于key的键的数量 也等于key的位置i
		public int rank(Key key)
		{
			return rank(root, key);
		}
		private int rank(Node node, Key key)
		{
			if(node == null) return 0;
			int cmp = key.compareTo(node.key);
			if(cmp == 0) return size(node.left);
			else if(cmp < 0) return rank(node.left, key);
			else return 1+size(node.left)+rank(node.right, key);
		}
		
		
		public void deleteMin()
		{
			root = deleteMin(root);
		}
		
		private Node deleteMin(Node node)
		{
			if(node == null) return null;
			if(node.left == null) return node.right;
			node.left = deleteMin(node.left);
			node.N = size(node.left) + size(node.right) + 1;
			return node;
		}
		
		//删除方法不改可以用 但就不是平衡的了
		public void delete(Key key)
		{
			root = delete(root , key);
		}
		private Node delete(Node node, Key key)
		{
			if(node == null) return null;
			int cmp = key.compareTo(node.key);
			if(cmp < 0) node.left = delete(node.left, key);
			else if(cmp > 0) node.right = delete(node.right, key);
			else 
			{
				if(node.right == null) return node.left;
				if(node.left == null) return node.right;
				Node temp = node;
				node = min(temp.right);
				node.right = deleteMin(temp.right);
				node.left = temp.left;
			}
			node.N = size(node.left) + size(node.right) +1;
			return node;
		}
		
		public Iterator<Key> keys()
		{
			return keys(min(), max());
		}
		public Iterator<Key> keys(Key lo, Key hi)
		{
			Queue<Key> queue = new Queue<Key>();
			keys(root, queue, lo, hi);
			return queue.iterator();
		}
		private void keys(Node node, Queue queue, Key lo, Key hi)
		{
			if(node == null) return ;
			int cmplo = lo.compareTo(node.key);
			int cmphi = hi.compareTo(node.key);
			if(cmplo < 0) keys(node.left, queue, lo, hi);
			if(cmplo <=0 && cmphi >= 0) queue.enqueue(node.key);
			if(cmphi > 0) keys(node.right, queue, lo, hi);
			
		}
		
		public void show()
		{
			for(int i = 0; i < size(root); i++)
			{
				System.out.print(select(i) + "\t");
			}
			System.out.print("\n");
		}
	
}
