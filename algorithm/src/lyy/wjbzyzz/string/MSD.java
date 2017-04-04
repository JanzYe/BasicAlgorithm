package lyy.wjbzyzz.string;

import lyy.wjbzyzz.sort.InsertionSort;

//��λ���ȵ��ַ����������ȶ��ؽ��������ַ�������  ���ڼ���������������
//��ֵ������Ӱ������    �ռ�Ҳ��Ҫ���ǵ�  count����ݹ��д����ܶ�  ���ƶ�

public class MSD {

	// a[i].key()�ķ�Χ��[0��R) a[i]Ԫ�ش���һ���ַ�����һ���� �������δ��������ַ�������ĸΪ��

	private static int N;
	private static int R = 256, M =15;
	private static String[] aux;

	
	//���ڽ��̵��ַ����ŵ�ǰ��
	private static int charAt(String s, int d)
	{
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
	
	public static void sort(String[] a) {
		N = a.length;
		aux = new String[N];
		sort(a, 0, N-1, 0);
	}

	public static void sort(String[] a, int lo, int hi, int d) {

		//С�����л�Ϊ��������
		if(hi < lo+M)
		{
			InsertionSort.sort(a, lo, hi,d); 
			return;
		}
		
		int[] count = new int[R + 2];
		// ͳ��ÿ�������ֵ�Ƶ�� ����count�����ֵ��һ��
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i],d)+2]++;

		// ��Ƶ��ת��Ϊ����
		for (int r = 0; r < R+1; r++)
			count[r + 1] += count[r];

		// ��Ԫ�ط���
		for (int i = lo; i <= hi; i++)
			aux[count[charAt(a[i],d)+1]++] = a[i];

		// ��д��ԭ����
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i-lo];
		
		//�ݹ���ÿ���ַ�Ϊ����������
		for(int r = 0; r < R; r++)
			sort(a, lo+count[r], lo+count[r+1]-1, d+1);

	}

}
