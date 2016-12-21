package com.dk.test.jvm;

public class OriginalClassInvoker {
	
	public static void main(String[] args) throws ClassNotFoundException {
		DkLaggingAgent.initialize();
		
		OriginalClass oc = new OriginalClass();
		for (int i = 0; i < 10; i++) {
			// can not initiate agent after vm started like this way
//			if (i == 5) {
//				ClassLoader cl = ClassLoader.getSystemClassLoader();
//				URLClassLoader urlcl = new URLClassLoader(new URL[] { new URL(
//						"jar:file:lagging-agent.jar!/") }, cl);
//				Class<?> c = urlcl.loadClass("com.dk.test.jvm.DkLaggingAgent");
//				System.out.println(c.getName());
//			}
			oc.printSth();
		}
	}

}
