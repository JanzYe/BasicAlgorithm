package lyy.wjbzyzz.string;

import java.util.Iterator;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import lyy.wjbzyzz.algorithm.Queue;
import lyy.wjbzyzz.sort.MinPQ;

//霍夫曼编码    变长前缀码   一个字符的编码不可能是另一个字符编码的前缀  这样可以不加分隔符而读出结果
public class HuffmanCode {

	private static int R = 256;  //基数   字母表的大小
	
	private static class Node implements Comparable<Node>
	{
		private char ch;  //编码字符
		private final Node left, right;  //左连接为零  右链接为一
		private int freq;  //字符出现的频率  用于决定哪个字符编码短哪个长
		
		public Node(char ch, int freq, Node left, Node right)
		{
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		
		//由于编码不能作为别的前缀  所以字符编码的最后一位后面肯定是没有其他字符的  left right必为null  
		//不为null则不是字符编码的最后一位
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
	
	
	//根据字符出现频率创建多棵单结点数   在此编码压缩
	private Node buildTrie(int[] freq)
	{
		
		MinPQ<Node> pq = new MinPQ<Node>();
		
		for(char c =0; c < R; c++)
			pq.insert(new Node(c, freq[c], null, null));
		
		while(pq.size() > 1)
		{
			//合并最小的两棵树   即概率最小的两个相加为一棵树
			Node left = pq.delMin();
			Node right = pq.delMin();
			pq.insert(new Node('\0', left.freq+right.freq, left, right));
		}
		
		return pq.delMin();
	}
	
	//将创建的单词查找树写入到输出流
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
	
	
	
	
	
	//获得编码结果
	private  void buildCode(String[] st, Node x, String s)
	{
		//使用单词查找树构造编译表(递归)
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
		
		//读取输入
		String s = BinaryStdIn.readString();
		char[] input = s.toCharArray();
		int[] freq = new int[R];
		//统计频率
		for(int i = 0; i < input.length; i++)
			freq[input[i]]++;
		
		//构建霍夫曼单词查找树
		Node root = buildTrie(freq);
		
		//构造编译表
		String[] st = new String[R];
		buildCode(st, root, "");
		
		//输出霍夫曼编码后的二进制编码
		writeHuffman(input, st);
		
		
	}
	
	//输出霍夫曼编码后的二进制编码
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
	
	//将创建的单词查找树写入到输出流
		private static Node readTrie()
		{
			if(BinaryStdIn.readBoolean())
				return new Node(BinaryStdIn.readChar(), 0, null, null);
			return new Node('\0', 0, readTrie(), readTrie());
			
		}
	
	
	//前缀码展开（解码）
	public static void expand()
	{
		Node root = readTrie();   //读取单词树
		int N = BinaryStdIn.readInt();  //字符数
		
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
