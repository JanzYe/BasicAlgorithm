package lyy.wjbzyzz.string;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;



//此实现还不够高效  当编码表满后（即压缩时 code >= L   解压时i >= L）清空 大于R之后的编码表重用  可提高效率
public class LZW {

	private static final int R = 256;  //字符表大小
	private static final int L = 4096;  //编码总数 2^12
	private static final int W = 12;  //编码宽度
	
	
	public static void compress()
	{
		String input = BinaryStdIn.readString();
		
		TST<Integer> st = new TST<Integer>();
		
		for(int i = 0; i < R; i++)
			st.put(""+(char)i, i);
		
		int code = R+1;  // R所在位置为文件结束处   后面位置用于编码
		
		while(input.length() > 0)
		{
			String s = st.longestPrefixOf(input);
			
			BinaryStdOut.write(st.get(s), W);
			
			int t = s.length();  //符号表中已有的前缀的最长长度
			
			if( t < input.length() && code < L)
				st.put(input.substring(0,t+1), code++);   //将s加上下一个字符存入符号表
			input = input.substring(t);
		}
		BinaryStdOut.write(R, W);   //写入结束符
		BinaryStdOut.close();
	}
	
	
	public static void expand()
	{
		String[] st = new String[L]; 
		int i;  //下一个待补全的编码值
		
		for( i = 0; i < R; i++)
			st[i] = ""+(char)i;
		st[i++] = "";  //(未使用 )  文件结束标志的前瞻字符
		
		int codeword = BinaryStdIn.readInt(W);
		String val = st[codeword];
		
		while(true)
		{
			BinaryStdOut.write(val);  //输出当前子字符串
			codeword = BinaryStdIn.readInt(W);  //读取下一个编码
			
			if(codeword == R) break;   //文件结束
			
			String s = st[codeword];  //下一个子字符串
			if( i == codeword)  //前瞻码的字符串与下一个子字符串相同   s == ""
				s = val+val.charAt(0);    //则根据上一个字符的首字母的到下一个编码的字符串
			if( i < L)
				st[i++] = val + s.charAt(0);  
			val = s;
		}
		BinaryStdOut.close();
		
	}
	
}
