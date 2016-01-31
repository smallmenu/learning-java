package com.niuchaoqun.example.pattern;

import com.niuchaoqun.pattern.Singleton;
import com.niuchaoqun.pattern.SingletonInside;

public class SingletonExample {
	public static void run(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		System.out.println(instance1);

		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance2);

		SingletonInside instance3 = SingletonInside.getSingleton();
		System.out.println(instance3);
		System.out.println(instance3.getSomething());

		SingletonInside instance4 = SingletonInside.getSingleton();
		System.out.println(instance4);
		System.out.println(instance4.getSomething());

		instance4.setSomething("changed");
		System.out.println(instance3.getSomething());
		System.out.println(instance4.getSomething());
	}
}
