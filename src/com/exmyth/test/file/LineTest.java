package com.exmyth.test.file;

public class LineTest {
	public static void main(String[] args) {
		String str = "a\nb";
		String[] split = str.split("\\n");
		System.out.println(str);
		System.out.println(split.length);
	}
}
