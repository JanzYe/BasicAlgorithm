package lyy.wjbzyzz.string;

import java.util.Iterator;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;

//����������    �䳤ǰ׺��   һ���ַ��ı��벻��������һ���ַ������ǰ׺  �������Բ��ӷָ������������
public class HuffmanCode {

	private static int R = 256;  //����   ��ĸ��Ĵ�С
	
	private static class Node implements Comparable<Node>
	{
		private char ch;  //�����ַ�
		private final Node left, right;  //������Ϊ��  ������Ϊһ
		private int freq;  //�ַ����ֵ�Ƶ��  ���ھ����ĸ��ַ�������ĸ���
		
		public Node(char ch, int freq, Node left, Node right)
		{
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		
		//���ڱ��벻����Ϊ���ǰ׺  �����ַ���������һλ����϶���û�������ַ���  left right��Ϊnull  
		//��Ϊnull�����ַ���������һλ
		public boolean isLeaf()
		{
			return left == null && right == null;
		}

		@Override
		public int compareTo(Node that) {
			// TODO Auto-generated method stub
			return this.freq - that.freq;
		}
		
	}
	
	
	//�����ַ�����Ƶ�ʴ�����õ������   �ڴ˱���ѹ��
	private Node buildTrie(int[] freq)
	{
		
		MinPQ<Node> pq = new MinPQ<Node>();
		
		for(char c =0; c < R; c++)
			pq.insert(new Node(c, freq[c], null, null));
		
		while(pq.size() > 1)
		{
			//�ϲ���С��������   ��������С���������Ϊһ����
			Node left = pq.delMin();
			Node right = pq.delMin();
			pq.insert(new Node('\0', left.freq+right.freq, left, right));
		}
		
		return pq.delMin();
	}
	
	//�������ĵ��ʲ�����д�뵽�����
	private void writeTrie(Node x)
	{
		if(x.isLeaf())
		{
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch);
			return;
		}
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
		
	}
	
	
	
	
	
	//��ñ�����
	private  void buildCode(String[] st, Node x, String s)
	{
		//ʹ�õ��ʲ�������������(�ݹ�)
		if(x.isLeaf())
		{
			st[x.ch] = s;
			return;
		}
		buildCode(st, x.left, s+"0");
		buildCode(st, x.right, s+"1");
		
	}
	
	
	public void compress()
	{
		
		//��ȡ����
		String s = BinaryStdIn.readString();
		char[] input = s.toCharArray();
		int[] freq = new int[R];
		//ͳ��Ƶ��
		for(int i = 0; i < input.length; i++)
			freq[input[i]]++;
		
		//�������������ʲ�����
		Node root = buildTrie(freq);
		
		//��������
		String[] st = new String[R];
		buildCode(st, root, "");
		
		//��������������Ķ����Ʊ���
		writeHuffman(input, st);
		
		
	}
	
	//��������������Ķ����Ʊ���
	private   void writeHuffman(char[] input, String[] st)
	{
		for(int i = 0; i < input.length; i++)
		{
			String code = st[input[i]]; 
			for(int j = 0; j < code.length(); j++)
				if(code.charAt(j) == '1')  BinaryStdOut.write(true);
				else BinaryStdOut.write(false);
		}
		BinaryStdOut.close();
	}
	
	//�������ĵ��ʲ�����д�뵽�����
		private static Node readTrie()
		{
			if(BinaryStdIn.readBoolean())
				return new Node(BinaryStdIn.readChar(), 0, null, null);
			return new Node('\0', 0, readTrie(), readTrie());
			
		}
	
	
	//ǰ׺��չ�������룩
	public static void expand()
	{
		Node root = readTrie();   //��ȡ������
		int N = BinaryStdIn.readInt();  //�ַ���
		
		for(int i = 0; i < N; i++)
		{
			Node x = root;
			while(!x.isLeaf())
				if(BinaryStdIn.readBoolean())
					x = x.right;
				else x = x.left;
			BinaryStdOut.write(x.ch);
		}
		BinaryStdOut.close();
		
	}

	
	

	
}
