package lyy.wjbzyzz.string;

import java.util.Iterator;

import lyy.wjbzyzz.algorithm.Queue;

//���ּ򵥵�ʵ�� Ч������ߵ�  ����Ҫ�Ŀռ�̫��  R���Զ�����ĸ������   �������ڴ������Դ�����ĸ��Ĵ�������  ̫�Ŀռ�
public class TrieST<Value> {

	private Node root;   //���ڵ�
	private static int R = 256;  //����   ��ĸ��Ĵ�С
	
	private static class Node
	{
		private Object value;  //ֵ
		private Node[] next = new Node[R];  //
		private int N;  // �ýڵ�Ϊ���ڵ�����Ĵ�С
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
	
	//���ڷ������еļ�
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
	
	//�����ҳ������Ա��� pre���ַ���Ϊ��ͷ���ַ������ַ��� ��  �����������Ϊpreǰ���ַ����Ǵ��ڵ�
	private void collect(Node x, String pre, Queue<String> q)
	{
		if(x == null) return;
		if(x.value != null) q.enqueue(pre);
		for(char c = 0; c < R; c++)
			collect(x.next[c],pre+c,q);
	}
	
	
	//�뺬��ͨ������ַ�����ƥ������м�
	public Iterable<String> keysThatMatch(String pat)
	{
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		return q;
	}
	//ͨ���  '.'
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
	
	//�ڷ��ű��в��Ҹ����ַ���s���ǰ׺
	//�� s = shells  ���ű����У�she sea shell  ��ô���ҽ��Ϊ shell 
	public String longestPrefixOf(String s)
	{
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}
	private int search(Node x, String s, int d, int length)
	{
		if(x == null) return length;
		if(x.value != null) length = d;  //ֻ��ֵ��Ϊ�� �ַ������Ǵ��ڵ�  ��ʱ�����ж��ǰ׺�ĳ���Ϊd
		if(d == s.length()) return length;
		
		int c = s.charAt(d);
		return search(x.next[c],s, d+1, length);
	}
	
	//ɾ��һ����
	public void delete(String key)
	{
		root = delete(root, key, 0);
	}
	private Node delete(Node x, String key, int d)
	{
		if(x == null) return null;
		
		if(d == key.length()) //ֱ�����ȱ����� ���������ݹ�
			x.value = null;    
		else{
			int c = key.charAt(d);
			if(x.next[c] != null) x.next[c] = delete(x.next[c], key, d+1);
			
		}
		
		if(x.value != null) return x;  //value��Ϊnull���ַ����Ǵ��ڵ�  ����ɾ
		
		for(int c = 0; c < R; c++)
			if(x.next[c] != null) return x;
		return null;  //valueΪnull ����������Ϊnull ɾ�����
		
		
		
	}
	
	
}
