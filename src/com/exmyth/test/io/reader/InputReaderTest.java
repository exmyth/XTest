package com.exmyth.test.io.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderTest {
	public static void main(String[] args) {
		InputReaderTest tester = new InputReaderTest();
		tester.test();
	}

	private void test() {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
			String inputContent;
			while (!(inputContent = inputReader .readLine()).equals("bye")) {
				System.out.println(inputContent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
