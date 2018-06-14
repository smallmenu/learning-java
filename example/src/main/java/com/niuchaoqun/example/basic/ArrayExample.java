package com.niuchaoqun.example.basic;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ArrayExample {
	public static void run(String[] args) {
		array();
		function();
	}

	public static void array() {
		// 声明
		int[] array1 = null;

		// 声明
		array1 = new int[10];

		// 声明初始化
		int[] array2 = { 1, 2, 3, 4, 5 };

		// 多维数组
		int[][] array3 = null;
		array3 = new int[3][4];

		// 遍历数组
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		for (int v : array2) {
			System.out.println(v);
		}

		// 返回数组的字符串表示
		System.out.println(Arrays.toString(array2));

		System.out.println("----- array -----");
	}
	
	public static void function() {
		int[] map = new int[5];
 	    int array1[] = {3,5,7,9,1,2,6,8};

 	    // Arrays.toString对带null输出的null，可以使用common-lang中ArrayUtils替代
        int[] nullArray = null;
        System.out.println(Arrays.toString(nullArray));
        System.out.println(ArrayUtils.toString(nullArray));

 	    // 填充
 	    Arrays.fill(map, 2);
        System.out.println(Arrays.toString(map));
        System.out.println(ArrayUtils.toString(map));

        // 复制
        int[] array2 = Arrays.copyOf(array1, 7);
        System.out.println(Arrays.toString(array2));

        // 排序
        // 对于普通类型，通过经过调优的快速排序法
        // 对于对象类型，使用归并排序算法，要实现 Comparable 接口
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));
		
		// 查找，返回索引
		int index = Arrays.binarySearch(array2, 5);
		System.out.println(index);
		
		// hashcode
		int hashcode = Arrays.hashCode(array1);
		System.out.println(hashcode);
	}
}
