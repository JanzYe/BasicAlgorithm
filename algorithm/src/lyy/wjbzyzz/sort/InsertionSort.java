package lyy.wjbzyzz.sort;

public class InsertionSort {

	//��������
	public static void sort(Comparable[] a)
	{
		//��a����������
		int N  = a.length;
		for(int i = 1; i < N; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if( less( a[j], a[j-1] ) )
				{
					exch(a, j, j-1);
				}
			}
		}
	}
	
	//�����Ż���������͹鲢����
	public static void sort(Comparable[] a, int lo, int hi)
	{
		//��a����������
		for(int i = lo+1; i <= hi; i++)
		{
			for(int j = i; j > lo; j--)
			{
				if( less( a[j], a[j-1] ) )
				{
					exch(a, j, j-1);
				}
			}
		}
	}
	
	
	//�����Ż���λ���ȵ��ַ�������
	public static void sort(String[] a, int lo, int hi, int d)
	{
		//��a����������   ǰd���ַ��ѱȽϹ�����ͬ��  less�в����ٱȽ���  ���ٱȽ���
		for(int i = lo+1; i <= hi; i++)
		{
			for(int j = i; j > lo; j--)
			{
				if( less( a[j], a[j-1] , d) )
				{
					exch(a, j, j-1);
				}
			}
		}
	}
	//�����Ż���λ���ȵ��ַ�������
	public static boolean less(String v, String w, int d)
	{
		return v.substring(d).compareTo(w.substring(d)) < 0;
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
