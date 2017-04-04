package lyy.wjbzyzz.string;


//键索引计数法排序   线性时间内完成  对于小整数键排序非常有效
public class KeyIndexCountSort {

	//a[i].key()的范围是[0，R)  a[i]元素存有一个字符串和一个键  这里暂且以字符串的第一个字母为键
	public static void sort(String[] a , int R)
	{
		int N = a.length;
		String[] aux = new String[N];
		int[] count = new int[R+1];
		
		//统计每个键出现的频率  存在count数组键值加一处
		for(int i = 0; i < N; i++)
			count[a[i].charAt(0)+1]++;
		
		//将频率转换为索引
		for(int r = 0; r < R; r++)
			count[r+1] += count[r];
		
		//将元素分类
		for(int i = 0; i < N; i++)
			aux[count[a[i].charAt(0)]++] = a[i];
		
		//回写到原数组
		for(int i = 0; i < N; i++)
			a[i] = aux[i];
		
	}
	
}
