package lyy.wjbzyzz.string;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;



//��ʵ�ֻ�������Ч  ����������󣨼�ѹ��ʱ code >= L   ��ѹʱi >= L����� ����R֮��ı��������  �����Ч��
public class LZW {

	private static final int R = 256;  //�ַ����С
	private static final int L = 4096;  //�������� 2^12
	private static final int W = 12;  //������
	
	
	public static void compress()
	{
		String input = BinaryStdIn.readString();
		
		TST<Integer> st = new TST<Integer>();
		
		for(int i = 0; i < R; i++)
			st.put(""+(char)i, i);
		
		int code = R+1;  // R����λ��Ϊ�ļ�������   ����λ�����ڱ���
		
		while(input.length() > 0)
		{
			String s = st.longestPrefixOf(input);
			
			BinaryStdOut.write(st.get(s), W);
			
			int t = s.length();  //���ű������е�ǰ׺�������
			
			if( t < input.length() && code < L)
				st.put(input.substring(0,t+1), code++);   //��s������һ���ַ�������ű�
			input = input.substring(t);
		}
		BinaryStdOut.write(R, W);   //д�������
		BinaryStdOut.close();
	}
	
	
	public static void expand()
	{
		String[] st = new String[L]; 
		int i;  //��һ������ȫ�ı���ֵ
		
		for( i = 0; i < R; i++)
			st[i] = ""+(char)i;
		st[i++] = "";  //(δʹ�� )  �ļ�������־��ǰհ�ַ�
		
		int codeword = BinaryStdIn.readInt(W);
		String val = st[codeword];
		
		while(true)
		{
			BinaryStdOut.write(val);  //�����ǰ���ַ���
			codeword = BinaryStdIn.readInt(W);  //��ȡ��һ������
			
			if(codeword == R) break;   //�ļ�����
			
			String s = st[codeword];  //��һ�����ַ���
			if( i == codeword)  //ǰհ����ַ�������һ�����ַ�����ͬ   s == ""
				s = val+val.charAt(0);    //�������һ���ַ�������ĸ�ĵ���һ��������ַ���
			if( i < L)
				st[i++] = val + s.charAt(0);  
			val = s;
		}
		BinaryStdOut.close();
		
	}
	
}
