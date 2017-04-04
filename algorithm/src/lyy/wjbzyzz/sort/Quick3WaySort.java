package lyy.wjbzyzz.sort;
import lyy.wjbzyzz.algorithm.MyRandom;


public class Quick3WaySort {

	//��������
	public static void sort(Comparable[] a)
	{
		//Ҫ����������� ��ֹ����������
		MyRandom.random_array(a);
		//��a����������
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//��a����������
		//if(hi <= lo) return;
		if(hi-lo < 10) 
		{
			InsertionSort.sort(a, lo, hi);  //С�����ò���  ���ݹ�  �������  
			return;
		}
		
		int lt =lo, i = lo+1, gt = hi;
		Comparable v = a[lo];  //�з�Ԫ��
		
		while( i <= gt)
		{
			//��a��Ϊ��С��v��  ����v  ����v��������
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
