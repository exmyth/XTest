package com.exmyth.test.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URITest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String url = "a中国%2";
		String decode = URLDecoder.decode(url, "utf8");
		System.out.println(decode);
	}
}
