package lyy.wjbzyzz.algorithm;
import java.util.Random;


public class MyRandom {

	//产生[lo,hi)的随机整数
	public static int random_lo_hi(int lo, int hi)
	{
		Random random = new Random();
		return random.nextInt(hi-lo)+lo;
	}
	
	//将数组元素顺序随机化
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
