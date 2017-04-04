package lyy.wjbzyzz.string;
import lyy.wjbzyzz.algorithm.MyRandom;
import lyy.wjbzyzz.sort.InsertionSort;

//三向字符串快速排序   比高位优先要友好  没那么限制 空间 等键值等所有高位优先字符串排序不擅长的都可以处理
public class Quick3string {

	
	//用于将短的字符串放到前面
		private static int charAt(String s, int d)
		{
			if(d < s.length()) return s.charAt(d);
			else return -1;
		}
		
	//快速排序
	public static void sort(String[] a)
	{
		//要随机打乱数组 防止出现最坏的情况
		MyRandom.random_array(a);
		//将a按升序排序
		sort(a, 0, a.length-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d)
	{
		//将a按升序排序
		//if(hi <= lo) return;
		if(hi-lo < 15) 
		{
			InsertionSort.sort(a, lo, hi,d);  //小数组用插入  不递归  提高性能  
			return;
		}
		
		int lt =lo, i = lo+1, gt = hi;
		int v = charAt(a[lo], d);  //切分元素
		
		while( i <= gt)
		{
			//将a分为了小于v的  等于v  大于v的三部分
			int cmp = charAt(a[i], d);
			if(cmp < v) exch(a, lt++, i++);
			else if(cmp > v) exch(a, i, gt--);
			else i++;
		}

		sort(a, lo, lt-1,d);
		if(v >=0) sort(a,lt, gt, d+1);
		sort(a, gt+1, hi,d);

	}
	

	
	public static boolean less(String v, String w)
	{
		return v.compareTo(w) < 0;
	}
	
	public static void exch(String[] a, int i, int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(String[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+"\t");
		}
	}
	
	public static boolean isSorted(String[] a)
	{
		for(int i = 0; i < a.length-1; i++) 
			if(less(a[i+1], a[i]))
				return false;
		return true;
	}
	
}
