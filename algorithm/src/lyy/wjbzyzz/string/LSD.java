package lyy.wjbzyzz.string;


//��λ���ȵ��ַ����������ȶ��ؽ������ַ�������  ���ڼ���������������

public class LSD {

	//a[i].key()�ķ�Χ��[0��R)  a[i]Ԫ�ش���һ���ַ�����һ����  �������δ��ҵ������ַ�������ĸΪ��
		public static void sort(String[] a , int W)
		{
			//ͨ��ǰW���ַ���a[]����
			int N = a.length;
			int R = 256;
			String[] aux = new String[N];
			
			
			for(int d = W-1; d >= 0; d--)
			{
				int[] count = new int[R+1];
				//ͳ��ÿ�������ֵ�Ƶ��  ����count�����ֵ��һ��
				for(int i = 0; i < N; i++)
					count[a[i].charAt(d)+1]++;
				
				//��Ƶ��ת��Ϊ����
				for(int r = 0; r < R; r++)
					count[r+1] += count[r];
				
				//��Ԫ�ط���
				for(int i = 0; i < N; i++)
					aux[count[a[i].charAt(d)]++] = a[i];
				
				//��д��ԭ����
				for(int i = 0; i < N; i++)
					a[i] = aux[i];
			}
			
			
		}
	
}
