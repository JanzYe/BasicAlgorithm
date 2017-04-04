package lyy.wjbzyzz.string;

import lyy.wjbzyzz.sort.InsertionSort;

//高位优先的字符串排序能稳定地将不定长字符串排序  基于键索引计数法排序
//等值键过多影响性能    空间也是要考虑的  count数组递归中创建很多  限制多

public class MSD {

	// a[i].key()的范围是[0，R) a[i]元素存有一个字符串和一个键 这里依次从左到右以字符串的字母为键

	private static int N;
	private static int R = 256, M =15;
	private static String[] aux;

	
	//用于将短的字符串放到前面
	private static int charAt(String s, int d)
	{
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
	
	public static void sort(String[] a) {
		N = a.length;
		aux = new String[N];
		sort(a, 0, N-1, 0);
	}

	public static void sort(String[] a, int lo, int hi, int d) {

		//小数组切换为插入排序
		if(hi < lo+M)
		{
			InsertionSort.sort(a, lo, hi,d); 
			return;
		}
		
		int[] count = new int[R + 2];
		// 统计每个键出现的频率 存在count数组键值加一处
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i],d)+2]++;

		// 将频率转换为索引
		for (int r = 0; r < R+1; r++)
			count[r + 1] += count[r];

		// 将元素分类
		for (int i = lo; i <= hi; i++)
			aux[count[charAt(a[i],d)+1]++] = a[i];

		// 回写到原数组
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i-lo];
		
		//递归以每个字符为键进行排序
		for(int r = 0; r < R; r++)
			sort(a, lo+count[r], lo+count[r+1]-1, d+1);

	}

}
