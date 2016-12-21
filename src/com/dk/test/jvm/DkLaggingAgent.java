package com.dk.test.jvm;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;

import com.sun.tools.attach.VirtualMachine;

public class DkLaggingAgent {

	private static Instrumentation instrumentation;

	public static void agentmain(String agentArgs, Instrumentation inst) {
		System.out.println("agentmain");
		DkClassFileTransformerImpl transformer = new DkClassFileTransformerImpl();
		instrumentation = inst;
		instrumentation.addTransformer(transformer);
	}

	public static void initialize() {
		System.out.println("prepare 2 init");
		if (instrumentation == null) {
			System.out.println("initializing");
			try {
				String nameOfRunningVm = ManagementFactory.getRuntimeMXBean()
						.getName();
				String pid = nameOfRunningVm.substring(0,
						nameOfRunningVm.indexOf("@"));
				System.out.println(pid);
				VirtualMachine vm = VirtualMachine.attach(pid);
				System.out.println(vm.id());
				vm.loadAgent("F:\\workspaces\\luna-jee\\[haveEyesOn]masterJVM\\target\\classes\\lagging-agent.jar");
				vm.detach();
				System.out.println("initialization complete");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
