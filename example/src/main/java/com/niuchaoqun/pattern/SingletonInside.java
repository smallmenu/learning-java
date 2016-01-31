package com.niuchaoqun.pattern;

public class SingletonInside {
	private static class SingletonHolder {
		private static final SingletonInside INSTANCE = new SingletonInside();
	}

	private String something = null;

	private SingletonInside() {
		setSomething("singleton");
	}

	public static final SingletonInside getSingleton() {
		return SingletonHolder.INSTANCE;
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}
}
