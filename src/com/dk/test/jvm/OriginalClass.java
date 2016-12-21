package com.dk.test.jvm;

public class OriginalClass {
	public void printSth() {
		System.out.println("This is original class speaking.");
	}

	public static void main(String[] args) {
		OriginalClass os = new OriginalClass();
		os.printSth();
	}

}
