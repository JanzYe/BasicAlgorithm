package lyy.wjbzyzz.string;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Queue;


//基于三向单词查找树的符号表

public class TST<Value> {

	private Node root;
	
	private class Node
	{
		private char c;    //键
		private Value value;  //值
		private Node left, right, mid;  //left 比该节点小的子节点树  right 比该结点大的子结点树  mid 和结点相等的
		private int N;  //已该结点为根的子结点总数
		
		
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
	
	
	public Value get(String key)
	{
		Node node = get(root, key, 0);
		if(node == null) return null;
		return node.value;
	}
	
	private Node get(Node node, String key, int d)
	{
			if(node == null) return null;
			char c = key.charAt(d);
			if(c < node.c)  return get(node.left, key,d);
			else if(c > node.c)  return get(node.right, key, d);
			else if(d < key.length()) return get(node.mid, key, d+1);
			else return node;
			
			
	}
	
	public void put(String key, Value value)
	{
		root = put(get(root,key,0), key, value, 0);
	}
	
	private Node put(Node node, String key, Value value, int d)
	{
		char c = key.charAt(d);
		if(node == null)  
		{
			node = new Node();
			node.c = c;
		}
		
		if(c < node.c)  node.left = put(node.left, key, value,d);
		else if(c > node.c)  node.right = put(node.right, key, value, d);
		else if(d < key.length()) node.mid = put(node.mid, key, value, d+1);
		else node.value = value;
		
		node.N = size(node.left)+size(node.right)+1;
		return node;
		
	}
	
	//在符号表中查找给定字符串s的最长前缀
		//如 s = shells  符号表中有：she sea shell  那么查找结果为 shell 
		public String longestPrefixOf(String s)
		{
			int length = search(root, s, 0, 0);
			return s.substring(0, length);
		}
		private int search(Node x, String s, int d, int length)
		{
			if(x == null) return length;
			if(x.value != null) length = d;  //只有值不为空 字符串才是存在的  此时才能判定最长前缀的长度为d
			if(d == s.length()) return length;
			
			int cmp = s.charAt(d) - x.c;
			
			if(cmp > 0) return search(x.right,s, d, length);
			else if(cmp < 0) return search(x.left,s, d, length);
			else return search(x.mid,s, d+1, length);
			
		}
	
	
		//删除一个键
		public void delete(String key)
		{
			root = delete(root, key, 0);
		}
		private Node delete(Node x, String key, int d)
		{
			if(x == null) return null;
			
			if(d == key.length()) //直到长度遍历完 结束继续递归
				x.value = null;    
			else{
				int cmp = key.charAt(d) - x.c;
				if(cmp > 0 && x.right != null) x.right = delete(x.right, key, d);
				else if(cmp < 0 && x.left != null) x.left = delete(x.left, key, d);
				else if(x.mid != null) x.mid = delete(x.mid, key, d+1);
				
			}
			
			if(x.value != null) return x;  //value不为null则字符串是存在的  不能删
			
			if(x.left != null || x.right != null || x.mid != null) return x;
			
			return null;  //value为null 且所有连接为null 删除结点
			
			
			
		}
		
	
}
