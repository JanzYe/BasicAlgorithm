package lyy.wjbzyzz.sort;
import lyy.wjbzyzz.algorithm.MyRandom;


public class QuickSort {

	//快速排序  通用排序最佳选择
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
		if(hi <= lo+10) 
		{
			InsertionSort.sort(a, lo, hi);  //小数组用插入  不递归  提高性能  
			return;
		}
		int j = partition(a, lo, hi);  //切分
		sort(a, lo, j-1);   //小半部分再切
		sort(a, j+1, hi);   //大的部分再往下切  直到变成一个
	}
	
	private static  int partition(Comparable[] a, int lo, int hi)
	{
		int i= lo, j = hi+1;  //左右扫描指针
		Comparable v = a[lo];  //切分元素
		
		while(true)
		{
			//扫描左右 并检查是否扫描结束并交换扫描元素
			while( less( a[++i], v ) ) if(i == hi) break;
			while( less( v, a[--j] ) ) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);  //将切分元素放到正确的位置
		
		return j;
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
