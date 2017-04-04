package lyy.wjbzyzz.sort;

public class MergeSort {

	//�鲢����  ��Ҫ�����ȶ��ҿռ����ʱ���ѡ��
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];
		//��a����������
		sort(a, 0, a.length-1);
	}
	
	//�Զ�����  �ʺ����з���˼��
	private static void sort(Comparable[] a, int lo, int hi)
	{
		//��a����������
		//if(hi <= lo) return;
		
		if(hi <= lo+10) 
		{
			InsertionSort.sort(a, lo, hi);  //С�����ò���  ���ݹ�  �������  
			return;
		}
		
		int mid = lo+(hi-lo)/2;
		sort(a, lo, mid);   //��벿������
		sort(a,mid+1, hi);   //�ҵĲ�����������  ֱ�����һ��
		merge(a, lo, hi, mid); //���ݹ�鲢���
	}
	
/*	//�Ե׶��� �Ƚ��ʺ�������֯������  �����½��ڵ�
		public static void sort(Comparable[] a)
		{  //����lgN�������ݹ�
			//��a����������
			int N = a.length;
			aux = new Comparable[N];
			for(int sz = 1; sz < N; sz+=sz)  //�������С
			{
				for(int lo = 0; lo < N-sz; lo += sz+sz)  //����������
				{
					merge(a, lo, Math.min(lo+sz+sz-1, N-1), lo+sz-1);
				}
			}
		}
	*/
	//ԭ�ع鲢���󷽷�
	private static  void merge(Comparable[] a, int lo, int hi, int mid)
	{
		//��[ lo, mid ]��[mid +1, hi] �鲢����
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
