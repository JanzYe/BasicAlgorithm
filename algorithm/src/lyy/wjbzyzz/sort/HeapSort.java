package lyy.wjbzyzz.sort;

public class HeapSort {

	public static void sort(Comparable[] a){
		
		for(int i = 0; i < a.length; i++){
			
			createMaxHeap(a, a.length-1-i); //�õ�һ�����ֵ�ڶѶ��Ķ�
			exch(a, 0, a.length-1-i);  //�����ֵ�ŵ����
			show(a);
		}
		
		
	}
	
	private static void createMaxHeap(Comparable[] a, int lastIndex){
		
		//lastIndex ��û��ȷ����Сλ�õ����һλԪ��
		
		//�ӵ��������ɶ� ��֤a[0]����ֵ������
		for(int i = (a.length-1)/2; i >= 0; i--){
			int k = i;
			
			while(2*k < lastIndex){
				int biggerIndex = 2*k+1;  //��ȡ���ӽ��
				
				//������ӽ�����
				if(biggerIndex < lastIndex){
					
					//������ڱ��ҽ���Ľ�� �±����� 
					if(less(a[biggerIndex], a[biggerIndex+1]) ){
						biggerIndex++;
					}
					
				}
				//������ڵ��δ������²����ڵ�С  ���� ��֤���ڵ����
				if(less(a[k], a[biggerIndex]) ){
					exch(a, biggerIndex, k);
					k = biggerIndex;
				}
				else break;
			}
			
		}
		
		
	}
	
	private static void exch(Comparable[] a, int i, int j){
		
		if(i == j) return;
		
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		
		
	}
	
	
	
	private static boolean less(Comparable ai, Comparable aj){
		
		return ai.compareTo(aj) < 0;
		
	}
	
	public static void show(Comparable[] a){
		
		for(int i = 0; i < a.length; i++){
			
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
	}
	
	
}
