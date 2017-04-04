package lyy.wjbzyzz.string;


//低位优先的字符串排序能稳定地将定长字符串排序  基于键索引计数法排序

public class LSD {

	//a[i].key()的范围是[0，R)  a[i]元素存有一个字符串和一个键  这里依次从右到左以字符串的字母为键
		public static void sort(String[] a , int W)
		{
			//通过前W个字符将a[]排序
			int N = a.length;
			int R = 256;
			String[] aux = new String[N];
			
			
			for(int d = W-1; d >= 0; d--)
			{
				int[] count = new int[R+1];
				//统计每个键出现的频率  存在count数组键值加一处
				for(int i = 0; i < N; i++)
					count[a[i].charAt(d)+1]++;
				
				//将频率转换为索引
				for(int r = 0; r < R; r++)
					count[r+1] += count[r];
				
				//将元素分类
				for(int i = 0; i < N; i++)
					aux[count[a[i].charAt(d)]++] = a[i];
				
				//回写到原数组
				for(int i = 0; i < N; i++)
					a[i] = aux[i];
			}
			
			
		}
	
}
