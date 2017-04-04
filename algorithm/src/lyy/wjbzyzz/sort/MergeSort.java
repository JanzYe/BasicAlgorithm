package lyy.wjbzyzz.sort;

public class MergeSort {

	//归并排序  需要排序稳定且空间充足时最佳选择
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];
		//将a按升序排序
		sort(a, 0, a.length-1);
	}
	
	//自顶而下  适合所有分治思想
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//将a按升序排序
		//if(hi <= lo) return;
		
		if(hi <= lo+10) 
		{
			InsertionSort.sort(a, lo, hi);  //小数组用插入  不递归  提高性能  
			return;
		}
		
		int mid = lo+(hi-lo)/2;
		sort(a, lo, mid);   //左半部分再切
		sort(a,mid+1, hi);   //右的部分再往下切  直到变成一个
		merge(a, lo, hi, mid); //逐层递归归并结果
	}
	
/*	//自底而上 比较适合链表组织的数据  不用新建节点
		public static void sort(Comparable[] a)
		{  //进行lgN次两两递归
			//将a按升序排序
			int N = a.length;
			aux = new Comparable[N];
			for(int sz = 1; sz < N; sz+=sz)  //子数组大小
			{
				for(int lo = 0; lo < N-sz; lo += sz+sz)  //子数组索引
				{
					merge(a, lo, Math.min(lo+sz+sz-1, N-1), lo+sz-1);
				}
			}
		}
	*/
	//原地归并抽象方法
	private static  void merge(Comparable[] a, int lo, int hi, int mid)
	{
		//将[ lo, mid ]和[mid +1, hi] 归并排序
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
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
