package com.dk.test.jvm;

public class CopyOfOriginalClass {
	public void printSth() {
		System.out.println("This is original class speaking.");
	}

	public static void main(String[] args) {
		CopyOfOriginalClass os = new CopyOfOriginalClass();
		os.printSth();
	}

}
