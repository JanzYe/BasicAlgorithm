package lyy.wjbzyzz.algorithm;

import lyy.wjbzyzz.sort.HeapSort;


public class Algorithm {

	public  static void main(String[] arg0)
	{
		System.out.println("Algorithm Start");
		
		
		/*//二分查找用例
		 * int index = BinarySearch(211,new int[]{1,3,5,7,9,99,999,2111314});
		System.out.println(""+index);*/
		
		

		//注意Stack Queue 等的长度为零时  不要调用iterator  因为没有数据  是null 会报错
		
		/*//下压栈(数组实现)用例
		ResizingArrayStack stack  = new ResizingArrayStack();*/
		/*//下压栈(链表实现)用例
		Stack stack  = new Stack();
		for(int i = 0; i < 10; i++)
		{
			stack.push(i*i);
			//System.out.println(stack.pop());
		}
		Iterator iterator = stack.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println(stack.pop());
		
		//队列用例 （链表实现）
		Queue queue  = new Queue();
		for(int i = 0; i < 10; i++)
			queue.enqueue(i*i);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		Iterator iterator1 = queue.iterator();
		while(iterator1.hasNext())
		{
			System.out.println(iterator1.next());
		}*/
		
		/*//加权quick union find 算法用例
		WeightedQuickUnionFind UF = new WeightedQuickUnionFind(10);
		UF.union(9, 0);
		UF.union(3, 4);
		UF.union(5, 8);
		UF.union(7, 2);
		UF.union(2, 1);
		UF.union(5, 7);
		UF.union(0, 3);
		UF.union(4, 2);
		UF.result();*/
		
		
		String[] s = {"k", "h", "i","y","i", "n", "g","z","i"
				, "w", "o","a","i", "n", "i","s","b"};
		//希尔排序用例
		/*System.out.println( ShellSort.isSorted(s));
		ShellSort.sort(s);
		System.out.println( ShellSort.isSorted(s));
		ShellSort.show(s);*/
		//插入排序用例
		/*MyRandom.random_array(s);
		System.out.println( InsertionSort.isSorted(s));
		InsertionSort.sort(s);
		System.out.println( InsertionSort.isSorted(s));
		InsertionSort.show(s);*/
		//MyRandom.random_array(s);
		/*System.out.println( InsertionSort.isSorted(s));
		InsertionSort.sort(s, 0, s.length-1);
		System.out.println( InsertionSort.isSorted(s));
		InsertionSort.show(s);*/
		
		//归并排序用例 
 		/*MyRandom.random_array(s);
		System.out.println( MergeSort.isSorted(s));
		MergeSort.sort(s);
		System.out.println( MergeSort.isSorted(s));
		MergeSort.show(s);*/
				
		//快速排序用例
		/*System.out.println( QuickSort.isSorted(s));
		QuickSort.sort(s);
		System.out.println( QuickSort.isSorted(s));
		QuickSort.show(s);*/
		//三分快速排序用例
		/*System.out.println( Quick3WaySort.isSorted(s));
		Quick3WaySort.sort(s);
		System.out.println( Quick3WaySort.isSorted(s));
		Quick3WaySort.show(s);*/
		
		/*System.out.println(MyRandom.random_lo_hi(0, 2));
		System.out.println(MyRandom.random_lo_hi(0, 2));
		System.out.println(MyRandom.random_lo_hi(0, 2));*/
		
		/*//最大优先队列用例
		MaxPQ maxpq= new MaxPQ(20);
		for(int i = 0; i < s.length; i++)
		{
			maxpq.insert(s[i]);
		}
		maxpq.show();
		
		System.out.println("\n"+maxpq.delMax()+"\n");
		maxpq.show();*/
		
		/*//最小优先队列用例
				MinPQ minpq= new MinPQ(20);
				for(int i = 0; i < s.length; i++)
				{
					minpq.insert(s[i]);
				}
				minpq.show();
				
				System.out.println("\n"+minpq.delMin()+"\n");
				minpq.show();*/
		
	/*	//顺序查找 基于无序链表用例
		SequentialSearchST<String, Integer> st = new  SequentialSearchST<String, Integer>();
		for(int i = 0; i < s.length; i++)
		{
			st.put(s[i], i);
		}
		st.show();
		st.delete("k");
		st.show();*/
		
		//二分查找树用例
		//BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		//红黑二叉查找树用例
		/*RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
		for(int i = 0; i < s.length; i++)
		{
			bst.put(s[i], i);
		}
		bst.show();
		System.out.println(bst.get("i"));
		System.out.println(bst.max());
		System.out.println(bst.min());
		System.out.println(bst.floor("c"));
		System.out.println(bst.ceiling("c"));
		System.out.println(bst.rank("c"));
		bst.delete("k");
		Iterator iterator = bst.keys("a","z");
		while(iterator.hasNext())
			System.out.print(iterator.next().toString() + "\t");*/
		
		/*//基于拉链法的散列表
				SeparateChaininghashST<String, Integer> st = new  SeparateChaininghashST<String, Integer>();
				for(int i = 0; i < s.length; i++)
				{
					st.put(s[i], i);
				}
				System.out.println(st.get("k"));
				System.out.println(st.get("b"));
				st.delete("b");
				System.out.println(st.get("b"));
				System.out.println(st.size());*/
		
		/*//基于线性探测法的散列表
		LinearProbingHashST<String, Integer> st = new  LinearProbingHashST<String, Integer>();
		for(int i = 0; i < s.length; i++)
		{
			st.put(s[i], i);
		}
		System.out.println(st.get("k"));
		System.out.println(st.get("b"));
		System.out.println(st.size());
		st.show();
		st.delete("b");
		System.out.println(st.get("b"));
		System.out.println(st.size());
		st.show();*/
		
		/*//无向图Graph用例
		Graph G = new Graph(9);
		for(int i = 0; i < 9; i++)
		{
			G.addEdge(i, i*11%9);
			//G.addEdge(i, (i+1)%9);
		}
		System.out.println(G.toString());*/
		/*//深度优先路径搜索用例
		DepthFirstPaths dfp = new DepthFirstPaths(G, 4);
		System.out.println(dfp.pathToString(1));
		//深度优先路径搜索用例
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, 4);
		System.out.println(bfp.pathToString(1));
		System.out.println(bfp.isAllConnected());*/
		//深度优先搜索所有连通分量
		/*ConnectedComponents cc = new ConnectedComponents(G);
		cc.result();*/
		
		/*//高位优先的字符串排序
		MyRandom.random_array(s);
		System.out.println( MergeSort.isSorted(s));
		MSD.sort(s);
		System.out.println( MergeSort.isSorted(s));
		MergeSort.show(s);*/
		
		//三向字符串快速排序
		/*MyRandom.random_array(s);
		System.out.println( MergeSort.isSorted(s));
		Quick3string.sort(s);
		System.out.println( MergeSort.isSorted(s));
		MergeSort.show(s);*/
		
		/*String string = "yabycdyefyghyzz";
		System.out.println("回文："+ (string.length()-subLength(string)));
		System.out.println("回文1："+ getLCS(string));*/
		
		HeapSort.sort(s);
		
		
		
		System.out.println("\nAlgorithm End");
	}
	
	//回文   动态规划

	public static int subLength(String s) {

		int len = s.length();

		int[][] data = new int[len + 1][len + 1];

		for (int i = 0; i < len + 1; i++) {

			data[i][0] = 0;

			data[0][i] = 0;
		}

		for (int i = 1; i < len + 1; i++) {

			for (int j = 1; j < len + 1; j++) {

				if (s.charAt(i - 1) == s.charAt(len - j)) {

					data[i][j] = data[i - 1][j - 1] + 1;
				} else if (data[i - 1][j] >= data[i][j - 1]) {

					data[i][j] = data[i - 1][j];

				} else {

					data[i][j] = data[i][j - 1];
				}
			}
		}

		return data[len][len];
	}
	
	public static int getLCS(String s) {

		if (s == null || s.equals("")) {
			return 0;
		}
		// 转为字符数组        
		char[] arr = s.toCharArray();
		int length = arr.length;
		// 生成dp矩阵        
		int[][] dp = new int[length][length];
		// 初始化左上角的值        
		dp[0][0] = arr[0] == arr[length - 1] ? 1 : 0;
		// 初始化第一列的值        
		for (int i = 1; i < length; i++) {
			if (arr[i] == arr[length - 1]) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}
		// 初始化第一行的值，注意变量j，表示是从后面往前面扫描字符数组        
		for (int i = 1, j = length - 2; i < length && j > -1; i++, j--) {
			if (arr[j] == arr[0]) {
				dp[0][i] = 1;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}
		// 生成dp        
		for (int i = 1; i < length; i++) {
			for (int j = 1, k = length - 2; j < length && k > -1; j++, k--) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (arr[i] == arr[k]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return length - dp[length - 1][length - 1];
	}
	
	
	
	//二分查找  int可以换成其他数据类型
	public static int BinarySearch(int key, int[] array)
	{
		int lo =0, hi = array.length-1;
		
		while(lo <= hi)
		{
			int mid = lo+(hi-lo)/2;
			if(key > array[mid])
				lo = mid+1;
			else if(key < array[mid])
				hi = mid-1;
			else
				return mid;
		}
		return -1;
	}
	
}
