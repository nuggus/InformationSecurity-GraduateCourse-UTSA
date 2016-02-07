package com.mips.pipeline;

public class MemoryAccess {
	public static int exValue = 0;

	public void memoryStage(InstructionsList instructionsMemory) {

		int arg1 = 0;
		if (instructionsMemory.getArg1().equals("R1"))
			arg1 = Pipeline.R1;
		if (instructionsMemory.getArg1().equals("R2"))
			arg1 = Pipeline.R2;
		if (instructionsMemory.getArg1().equals("R3"))
			arg1 = Pipeline.R3;
		if (instructionsMemory.getArg1().equals("R4"))
			arg1 = Pipeline.R4;
		if (instructionsMemory.getArg1().equals("R5"))
			arg1 = Pipeline.R5;
		if (instructionsMemory.getArg1().equals("R6"))
			arg1 = Pipeline.R6;
		if (instructionsMemory.getArg1().equals("R7"))
			arg1 = Pipeline.R7;
		if (instructionsMemory.getType().equalsIgnoreCase("ST")) {
			//System.out.println("value at:"+Pipeline.storeTargetAddress );
			Pipeline.dmem[Pipeline.storeTargetAddress] = arg1;
		}
	

		//System.out.println("memory access:" + "at address" + Pipeline.storeTargetAddress + "value"
		//		+ Pipeline.dmem[Pipeline.storeTargetAddress]);
		// get values from execution stage

		if (instructionsMemory.getArg1().equals("R1"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R2"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R3"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R4"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R5"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R6"))
			exValue = Execute.arg1;
		if (instructionsMemory.getArg1().equals("R7"))
			exValue = Execute.arg1;
		if (instructionsMemory.getType().equalsIgnoreCase("LD")) {
			//System.out.println("value at:"+Pipeline.loadTargetAddress );
			exValue=Pipeline.dmem[Pipeline.loadTargetAddress];
		}
		//System.out.println("in memort test:" + exValue);
	}
}
