package lyy.wjbzyzz.algorithm;
import java.util.Random;


public class MyRandom {

	//����[lo,hi)���������
	public static int random_lo_hi(int lo, int hi)
	{
		Random random = new Random();
		return random.nextInt(hi-lo)+lo;
	}
	
	//������Ԫ��˳�������
	public static void random_array(Comparable[] a)
	{
		for(int i =0; i < a.length; i++)
		{
			exch(a, i, random_lo_hi(0, a.length));
		}
	}
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
