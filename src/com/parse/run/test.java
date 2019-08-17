package com.parse.run;

import javax.annotation.Resource;

/**
 * @author Leslie
 *这是类ClassDemo的注释
 */
public class test {
	public test() {
		System.out.println("I love Java");
	}
	

	public static void main(String args[]) {
		test testJava = new test();
		ClsA clsA = new ClsA();
		boolean bool = true;
		int num = 4;
		char charac = '|';
		System.out.println(testJava instanceof test);
		switch (num) {
		case 1:
			System.out.println("case1 out");
			break;
		default:
			break;
		}
		for (int j = 0; j < 5; ++j) {
			if (j > 3)
				break;
		}
		int cd = 0;
		while (cd < 5)
			cd++;
		System.out.println(1 > 2 ? 3 : 4);
		try {
			System.out.println("tryout");
		} catch (Exception e) {
			e.setStackTrace(null);
		}
	}
}
/**
 * @author Leslie
 *这是类ClsC的注释
 */
class ClsC extends ClsA {}


class ClsA {
	int a;
	int b;

	class ClsB {
		int c;
		int d;
	}

	public int method(int s, int e) //test method
	{
		ClsA clsA = new ClsA();
		for (int i = 1; i < 10; i++)
			clsA.a += i;
		s += e;
		return s + e;
	}
}
