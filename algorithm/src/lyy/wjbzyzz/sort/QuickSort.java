package lyy.wjbzyzz.sort;
import lyy.wjbzyzz.algorithm.MyRandom;


public class QuickSort {

	//��������  ͨ���������ѡ��
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
		if(hi <= lo+10) 
		{
			InsertionSort.sort(a, lo, hi);  //С�����ò���  ���ݹ�  �������  
			return;
		}
		int j = partition(a, lo, hi);  //�з�
		sort(a, lo, j-1);   //С�벿������
		sort(a, j+1, hi);   //��Ĳ�����������  ֱ�����һ��
	}
	
	private static  int partition(Comparable[] a, int lo, int hi)
	{
		int i= lo, j = hi+1;  //����ɨ��ָ��
		Comparable v = a[lo];  //�з�Ԫ��
		
		while(true)
		{
			//ɨ������ ������Ƿ�ɨ�����������ɨ��Ԫ��
			while( less( a[++i], v ) ) if(i == hi) break;
			while( less( v, a[--j] ) ) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);  //���з�Ԫ�طŵ���ȷ��λ��
		
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
