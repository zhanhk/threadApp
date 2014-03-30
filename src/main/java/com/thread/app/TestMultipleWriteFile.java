package com.thread.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestMultipleWriteFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileOutputStream out = new FileOutputStream(new File("F:"
				+ File.separator + "test.txt"), true);
		
		
		
		TestMultipleWriteFile t = new TestMultipleWriteFile();
		
		//t.testThread(queue, out);
		t.test(out);
		
		String temp = "00001111111";
		
		BigInteger big = new BigInteger(temp,10);
		System.out.println(big);
	}
	
	public void test(FileOutputStream out) {
		for(int i=1 ; i< 5000000; i++) {
			try {
				System.out.println(i);
				out.write(this.general().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public String general() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < 200 ; i++) {
			sb.append((int)(Math.random()*10));
		}
		return sb.append("\n").toString();
	}
	
	

}
