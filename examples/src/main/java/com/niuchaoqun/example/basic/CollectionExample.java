package com.niuchaoqun.example.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionExample {

	public static void run(String[] args) {
		arrayList();
		linkList();
		stackList();
		set();
		map();
		collections();
	}

	public static void arrayList() {
		// 列表
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("Hello");
		stringList.add("World");
		stringList.add(1, "Insert");
		System.out.println(stringList);
		System.out.println(stringList.contains("World"));
		System.out.println(stringList.subList(0, 1));
		System.out.println(stringList.get(2));
		System.out.println(stringList.indexOf("Insert"));
		System.out.println(stringList.remove(1));
		System.out.println(stringList);
		System.out.println("=====");

		for (int i = 0; i < stringList.size(); i++) {
			System.out.println(stringList.get(i));
		}
		for (String string : stringList) {
			System.out.println(string);
		}
		System.out.println("=====");

		Object[] objAry = stringList.toArray();
		for (int i = 0; i < objAry.length; i++) {
			System.out.println(objAry[i]);
		}
		String[] strAry = stringList.toArray(new String[] {});
		for (int i = 0; i < strAry.length; i++) {
			System.out.println(strAry[i]);
		}
		System.out.println("=====");

		stringList.add("Demo");
		System.out.println(stringList);
		Iterator<String> iterator = stringList.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if (string.equals("World")) {
				iterator.remove();
			}
		}
		System.out.println(stringList);
		ListIterator<String> listIterator = stringList.listIterator();
		// 若实现从后向前输出，首先得从先向后输出
		while (listIterator.hasPrevious()) {
			String string = listIterator.previous();
			System.out.println(string);
		}

		System.out.println("=====");

		// Vector 是 List 的前身，性能低但线程安全
		Vector<String> vector = new Vector<String>();
		vector.add("1");
		vector.add("2");
		vector.add("3");
		System.out.println(vector);
		System.out.println("=====");
	}

	public static void linkList() {
		// 链表
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("first");
		linkedList.add("second");
		linkedList.add("third");
		System.out.println(linkedList);
		linkedList.addFirst("head");
		linkedList.addLast("last");
		System.out.println(linkedList);
		System.out.println("=====");

		// 出队列
		int size = linkedList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(linkedList.poll());
		}
		System.out.println(linkedList);
		System.out.println("=====");
	}

	public static void stackList() {
		// 栈
		Stack<String> stack = new Stack<String>();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		System.out.println(stack);
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.println(stack.pop());
		}
		System.out.println("=====");
	}

	public static void set() {
		// 集合
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("D");
		hashSet.add("B");
		hashSet.add("A");
		hashSet.add("B");
		System.out.println(hashSet);

		// 有序集合
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("C");
		treeSet.add("B");
		treeSet.add("A");
		treeSet.add("B");
		System.out.println(treeSet);
		System.out.println("=====");
	}

	public static void map() {
		// HashMap为新的操作类，HashTable 旧的操作类，HashTable性能低但线程安全
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("key1", "value1");
		hashMap.put("key2", "value2");
		hashMap.put("key3", "value3");
		hashMap.put("key4", "value3");
		System.out.println(hashMap);
		if (hashMap.containsKey("key2")) {
			System.out.println(hashMap.get("key2"));
		}

		// all key
		Set<String> keys = hashMap.keySet();
		Iterator<String> kiterator = keys.iterator();
		while (kiterator.hasNext()) {
			System.out.println(kiterator.next());
		}

		// all value
		Collection<String> values = hashMap.values();
		Iterator<String> viterator = values.iterator();
		while (viterator.hasNext()) {
			System.out.println(viterator.next());
		}

		// all key and value
		Set<Entry<String, String>> entrySet = hashMap.entrySet();
		Iterator<Entry<String, String>> eiterator = entrySet.iterator();
		while (eiterator.hasNext()) {
			Entry<String, String> map = eiterator.next();
			System.out.println(map.getKey() + ":" + map.getValue());
		}

		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("=====");

		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("key1", "value1");
		treeMap.put("key2", "value2");
		treeMap.put("key3", "value3");
		treeMap.put("key4", "value3");
		Set<String> tkeys = treeMap.keySet();
		Iterator<String> titerator = tkeys.iterator();
		while (titerator.hasNext()) {
			System.out.println(titerator.next());
		}
		System.out.println("=====");
	}

	public static void collections() {
		// 一些工具
		ArrayList<String> arrayList = new ArrayList<String>();
		Collections.addAll(arrayList, "Hello", "World", "Java");
		System.out.println(arrayList);
		Collections.reverse(arrayList);
		System.out.println(arrayList);

		int binarySearch = Collections.binarySearch(arrayList, "World");
		System.out.println(binarySearch);

		Collections.replaceAll(arrayList, "Java", "PHP");
		System.out.println(arrayList);
	}
}
