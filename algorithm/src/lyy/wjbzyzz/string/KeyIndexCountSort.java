package lyy.wjbzyzz.string;


//����������������   ����ʱ�������  ����С����������ǳ���Ч
public class KeyIndexCountSort {

	//a[i].key()�ķ�Χ��[0��R)  a[i]Ԫ�ش���һ���ַ�����һ����  �����������ַ����ĵ�һ����ĸΪ��
	public static void sort(String[] a , int R)
	{
		int N = a.length;
		String[] aux = new String[N];
		int[] count = new int[R+1];
		
		//ͳ��ÿ�������ֵ�Ƶ��  ����count�����ֵ��һ��
		for(int i = 0; i < N; i++)
			count[a[i].charAt(0)+1]++;
		
		//��Ƶ��ת��Ϊ����
		for(int r = 0; r < R; r++)
			count[r+1] += count[r];
		
		//��Ԫ�ط���
		for(int i = 0; i < N; i++)
			aux[count[a[i].charAt(0)]++] = a[i];
		
		//��д��ԭ����
		for(int i = 0; i < N; i++)
			a[i] = aux[i];
		
	}
	
}
