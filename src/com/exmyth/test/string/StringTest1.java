package com.exmyth.test.string;

import org.apache.poi.util.ArrayUtil;

public class StringTest1 {
	public static void main(String[] args) {
		String str = "192.168.1.22";
		String[] split = str.split("\\.");
		System.out.println(split.length);
	}
}

