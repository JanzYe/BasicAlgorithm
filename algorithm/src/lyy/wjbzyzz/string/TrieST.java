package lyy.wjbzyzz.string;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Queue;

//这种简单的实现 效率是最高的  但需要的空间太大  R可自定义字母表缩减   不能用于处理来自大型字母表的大量长键  太耗空间
public class TrieST<Value> {

	private Node root;   //根节点
	private static int R = 256;  //基数   字母表的大小
	
	private static class Node
	{
		private Object value;  //值
		private Node[] next = new Node[R];  //
		private int N;  // 该节点为根节点的树的大小
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
		Node x = get(root, key, 0);
		if(x == null) return null;
		return (Value)x.value;
	}
	
	private Node get(Node node, String key, int d)
	{
			if(node == null) return null;
			if(d == key.length()) return node;
			Node x = node.next[key.charAt(d)];
			return get(x, key, d+1);
	}
	
	public void put(String key, Value value)
	{
		root = put(root, key, value, 0);
	}
	
	private Node put(Node node, String key, Value value, int d)
	{
		if(node == null)  node = new Node();
		if(d == key.length()) 
		{
			node.value = value;
			return node;
		}
		char c = key.charAt(d);
		node.next[c] =  put(node.next[c], key, value, d+1);
		
		return node;
		
	}
	
	//用于返回所有的键
	public Iterable<String> keys()
	{
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String pre)
	{
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}
	
	//用于找出所有以变量 pre中字符串为开头的字符串的字符串 键  这个函数已认为pre前的字符串是存在的
	private void collect(Node x, String pre, Queue<String> q)
	{
		if(x == null) return;
		if(x.value != null) q.enqueue(pre);
		for(char c = 0; c < R; c++)
			collect(x.next[c],pre+c,q);
	}
	
	
	//与含有通配符的字符串相匹配的所有键
	public Iterable<String> keysThatMatch(String pat)
	{
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		return q;
	}
	//通配符  '.'
	private void collect(Node x, String pre, String pat, Queue<String> q)
	{
		if(x == null) return;
		int d = pre.length();
		if(d == pat.length() && x.value != null) q.enqueue(pre);
		if(d == pat.length()) return;
		
		char next = pat.charAt(d);
		for(char c = 0; c < R; c++)
			if( next == '.' || next == c)
				collect(x.next[c],pre+c,q);
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
		
		int c = s.charAt(d);
		return search(x.next[c],s, d+1, length);
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
			int c = key.charAt(d);
			if(x.next[c] != null) x.next[c] = delete(x.next[c], key, d+1);
			
		}
		
		if(x.value != null) return x;  //value不为null则字符串是存在的  不能删
		
		for(int c = 0; c < R; c++)
			if(x.next[c] != null) return x;
		return null;  //value为null 且所有连接为null 删除结点
		
		
		
	}
	
	
}
