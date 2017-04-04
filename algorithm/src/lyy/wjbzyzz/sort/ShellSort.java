package lyy.wjbzyzz.sort;

public class ShellSort {

	//希尔排序
	public static void sort(Comparable[] a)
	{
		//将a按升序排序
		int N  = a.length;
		int h =1;
		while(h < N/3) h = 3*h+1;  //1 4 13 .......
		while(h >= 1)
		{
			//将数组变为h有序
			for (int i = h; i < N; i++)
			{
				//将a[j] 插入到 a[j-h] a[j-2*h] ,,,,,,
				for(int j = i; (j >= h) && (less( a[j] , a[j-h])); j -= h )
					exch(a, j, j-h);
			}
			h = h/3;
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
