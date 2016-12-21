package com.dk.test.jvm;

import java.lang.instrument.Instrumentation;

public class DkAgent {
	public static void premain(String agentArgs, Instrumentation inst) {
		DkClassFileTransformerImpl transformer = new DkClassFileTransformerImpl();
		inst.addTransformer(transformer);
	}
}
