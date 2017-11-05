package com.ylsh.study.datastruct.redblacktree;

import java.util.TreeMap;

public class test {
	
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		/**
		 * 异或 的特殊性
		 * 1^0=1 1^1=0 0^0=1
		 * 一个数连续两次异或一个相同的数，等于它自己
		 * 例如：a^b^b = a
		 * 利用这个特性进行数据交换
		 * 		
		 * 
		 */
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);
		System.out.println(b);
		
		TreeMap trMap = new TreeMap();
		
		trMap.remove("");
		
	}

}
