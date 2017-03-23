package com.niuchaoqun.example.basic;

import java.util.Arrays;

public class ArrayExample {
	public static void run(String[] args) {
		example();
	}
	
	public static void example() {
		int temp[] = {3,5,7,9,1,2,6,8};
		
		// 排序
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		
		// 查找，返回索引
		int index = Arrays.binarySearch(temp, 5);
		System.out.println(index);
		
		// hashcode
		int hashcode = Arrays.hashCode(temp);
		System.out.println(hashcode);
	}
}
