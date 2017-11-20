package com.ylsh.study.datastruct.sort;

import org.junit.Test;

import com.ylsh.study.datastruct.sort.bubble.BubbleSort;
/**
 * http://www.cnblogs.com/skywang12345/p/3603935.html   数据结构与算法目录
 * @author YePengPeng--2017年11月17日
 *
 */
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
