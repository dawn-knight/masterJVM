package com.dk.test.jvm;

import java.lang.reflect.InvocationTargetException;

public class ClassSubstitutionTest {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		ClassSubstitutionTest t = new ClassSubstitutionTest();
		Class c = t.getClass().getClassLoader()
				.loadClass("com.dk.test.jvm.ClassA");
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("classb")) {
				c = t.getClass()
						.getClassLoader()
						.loadClass(
								"com.dk.test.jvm.ClassB");
			}
		}
		c.getMethod("printSth").invoke(c.newInstance());
	}
}
