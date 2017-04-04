package lyy.wjbzyzz.sort;
import lyy.wjbzyzz.algorithm.MyRandom;


public class Quick3WaySort {

	//快速排序
	public static void sort(Comparable[] a)
	{
		//要随机打乱数组 防止出现最坏的情况
		MyRandom.random_array(a);
		//将a按升序排序
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//将a按升序排序
		//if(hi <= lo) return;
		if(hi-lo < 10) 
		{
			InsertionSort.sort(a, lo, hi);  //小数组用插入  不递归  提高性能  
			return;
		}
		
		int lt =lo, i = lo+1, gt = hi;
		Comparable v = a[lo];  //切分元素
		
		while( i <= gt)
		{
			//将a分为了小于v的  等于v  大于v的三部分
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a, lt++, i++);
			else if(cmp >0) exch(a, i, gt--);
			else i++;
		}

		sort(a, lo, lt-1);
		sort(a, gt+1, hi);

	}
	

	
	public static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+"\t");
		}
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for(int i = 0; i < a.length-1; i++) 
			if(less(a[i+1], a[i]))
				return false;
		return true;
	}
	
}
