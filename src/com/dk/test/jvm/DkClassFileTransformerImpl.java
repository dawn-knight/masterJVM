package com.dk.test.jvm;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.management.ManagementFactory;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.Descriptor;

public class DkClassFileTransformerImpl implements ClassFileTransformer {

	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		if (className.endsWith("com/dk/test/jvm/OriginalClass")) {
			try {
				ClassPool classPool = ClassPool.getDefault();
				CtClass clazz = classPool.get("com.dk.test.jvm.OriginalClass");
				String processName = ManagementFactory.getRuntimeMXBean()
						.getName();
				String sth2Append = "System.out.println(\"" + processName
						+ "\");";
				clazz.getMethod("printSth",
						Descriptor.ofMethod(CtClass.voidType, null))
						.insertAfter(sth2Append);
				byte[] byteCode = clazz.toBytecode();
				clazz.detach();
				return byteCode;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
