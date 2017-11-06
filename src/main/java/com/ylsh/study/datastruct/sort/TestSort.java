package com.ylsh.study.datastruct.sort;

import org.junit.Test;

public class TestSort {
	
	@Test
	public void bubbleTest(){
		int[] arr = {1,2,7,4,676,99,6,87};
		
		BubbleSort.sort(arr);
		for(int i = 0; i < arr.length; i ++){
			System.out.println(arr[i]);
		}
	}

}
