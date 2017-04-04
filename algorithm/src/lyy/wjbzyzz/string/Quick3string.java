package lyy.wjbzyzz.string;
import lyy.wjbzyzz.algorithm.MyRandom;
import lyy.wjbzyzz.sort.InsertionSort;

//�����ַ�����������   �ȸ�λ����Ҫ�Ѻ�  û��ô���� �ռ� �ȼ�ֵ�����и�λ�����ַ��������ó��Ķ����Դ���
public class Quick3string {

	
	//���ڽ��̵��ַ����ŵ�ǰ��
		private static int charAt(String s, int d)
		{
			if(d < s.length()) return s.charAt(d);
			else return -1;
		}
		
	//��������
	public static void sort(String[] a)
	{
		//Ҫ����������� ��ֹ����������
		MyRandom.random_array(a);
		//��a����������
		sort(a, 0, a.length-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d)
	{
		//��a����������
		//if(hi <= lo) return;
		if(hi-lo < 15) 
		{
			InsertionSort.sort(a, lo, hi,d);  //С�����ò���  ���ݹ�  �������  
			return;
		}
		
		int lt =lo, i = lo+1, gt = hi;
		int v = charAt(a[lo], d);  //�з�Ԫ��
		
		while( i <= gt)
		{
			//��a��Ϊ��С��v��  ����v  ����v��������
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
