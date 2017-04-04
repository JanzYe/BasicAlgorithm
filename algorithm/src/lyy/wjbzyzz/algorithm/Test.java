package lyy.wjbzyzz.algorithm;

import java.util.*;

public class Test {
    
    
    
    public static void main(String[] arg){
    	
    	//String arr = "3,1,1,1,3,1,1,1";
    	String arr = "3,4,2,1,3,1";
    	arr = jump(arr);
    	
    	System.out.println(arr);
    	
    }
    
    static String jump(String arr) {
    	
    	String result = "";
    	Stack<Integer> stack = new Stack<Integer>();
    	//System.out.println(arr);
    	String[] str = arr.split(",");
    	
    	int len = str.length;
    	
    	if(len < 1) return "";
    	
    	//System.out.println(String.valueOf(str));
    	
    	int[] array = new int[len];
    	for(int  i = 0; i < len; i++){
    		
    		array[i] = Integer.valueOf(str[i]);
    		
    	}
    	
    	
    	int max;
    	int index = 0;
    	stack.push(array[0]);
    	int temp, t_idx;
    	while(!stack.isEmpty()){
    		
    		temp = array[index];
    		if(temp+index >= len-1){
    			
    			while(!stack.isEmpty()){
    				result = stack.pop()+","+result;
    				
    			}
    			if(temp+index == len){
    				result = result.substring(0, result.length()-1);
    				result += array[len-1];
    			}
    			else{
    				//result = result.substring(0, result.length()-1);
    				result += array[len-1];
    			}
    			
    			
    			return result;
    			
    		}
    		max = array[index+1];
    		t_idx = index+1;
    		for(int i = index+2; i <= index+temp; i++ ){
    			
    			if(array[i] >= max){
    				
    				max = array[i];
    				t_idx = i;
    				
    			}
    		}
    		stack.push(max);
    		index = t_idx;
    		
    		
    	}
    	
    	
    	
    	
		return result;
        

    	  
    }
    
    
    
}