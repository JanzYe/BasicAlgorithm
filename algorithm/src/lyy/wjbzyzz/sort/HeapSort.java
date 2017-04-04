package lyy.wjbzyzz.sort;

public class HeapSort {

	public static void sort(Comparable[] a){
		
		for(int i = 0; i < a.length; i++){
			
			createMaxHeap(a, a.length-1-i); //得到一个最大值在堆顶的堆
			exch(a, 0, a.length-1-i);  //将最大值放到最后
			show(a);
		}
		
		
	}
	
	private static void createMaxHeap(Comparable[] a, int lastIndex){
		
		//lastIndex 还没有确定大小位置的最后一位元素
		
		//从低往上做成堆 保证a[0]处的值是最大的
		for(int i = (a.length-1)/2; i >= 0; i--){
			int k = i;
			
			while(2*k < lastIndex){
				int biggerIndex = 2*k+1;  //获取左子结点
				
				//如果右子结点存在
				if(biggerIndex < lastIndex){
					
					//如果存在比右结点大的结点 下标增大 
					if(less(a[biggerIndex], a[biggerIndex+1]) ){
						biggerIndex++;
					}
					
				}
				//如果根节点比未排序的下层最大节点小  交换 保证根节点最大
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
