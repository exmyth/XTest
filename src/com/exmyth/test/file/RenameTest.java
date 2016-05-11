package com.exmyth.test.file;

import java.io.File;

public class RenameTest {
	public static void main(String[] args) {
		File file = new File("D:/APP/员工生日-v07-3 直接在背景上过度");
		File[] listFiles = file.listFiles();
		System.out.println(listFiles.length);
		for(int i = 0; i < listFiles.length; i++){
			String name = listFiles[i].getName();
			int num = Integer.parseInt(name.substring((name.length()-9),(name.length()-4)))-72;
			String format = format("0", 2, num);
			System.out.println();
//			System.out.println(num);
			listFiles[i].renameTo(new File(file, "celebration"+format+".png"));
		}
	}
	
	public static String format(String str, int length, int num) {
		String n = String.valueOf(num);
		if(n.length()>=length){
			return n;
		}
		else{
			return String.format("%1$s%2$0"+(length-str.length())+"d", str,num);
		}
	}
}
