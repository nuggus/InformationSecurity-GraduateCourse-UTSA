package com.mips.pipeline;

public class Execute {
	static int arg1 = 0;
	static int arg2 = 0;
	static int arg3 = 0;
	static int nextPC = 0;

	public InstructionsList executionStage(InstructionsList instructionsMemory) {
		// identifying value of argument1
		if (instructionsMemory.getArg1().equals("R0"))
			arg1 = 0;
		else if (instructionsMemory.getArg1().equals("R1"))
			arg1 = Pipeline.R1;
		else if (instructionsMemory.getArg1().equals("R2"))
			arg1 = Pipeline.R2;
		else if (instructionsMemory.getArg1().equals("R3"))
			arg1 = Pipeline.R3;
		else if (instructionsMemory.getArg1().equals("R4"))
			arg1 = Pipeline.R4;
		else if (instructionsMemory.getArg1().equals("R5"))
			arg1 = Pipeline.R5;
		else if (instructionsMemory.getArg1().equals("R6"))
			arg1 = Pipeline.R6;
		else if (instructionsMemory.getArg1().equals("R7"))
			arg1 = Pipeline.R7;
		else
			arg1 = Integer.parseInt(instructionsMemory.getArg2());
		// identifying value of argument2
		if (instructionsMemory.getArg2().equals("R0"))
			arg2 = 0;
		else if (instructionsMemory.getArg2().equals("R1"))
			arg2 = Pipeline.R1;
		else if (instructionsMemory.getArg2().equals("R2"))
			arg2 = Pipeline.R2;
		else if (instructionsMemory.getArg2().equals("R3"))
			arg2 = Pipeline.R3;
		else if (instructionsMemory.getArg2().equals("R4"))
			arg2 = Pipeline.R4;
		else if (instructionsMemory.getArg2().equals("R5"))
			arg2 = Pipeline.R5;
		else if (instructionsMemory.getArg2().equals("R6"))
			arg2 = Pipeline.R6;
		else if (instructionsMemory.getArg2().equals("R7"))
			arg2 = Pipeline.R7;
		else
			arg2 = Integer.parseInt(instructionsMemory.getArg2());
		// identifying value of argument3
		if (instructionsMemory.getArg3().equals("R0"))
			arg3 = 0;
		else if (instructionsMemory.getArg3().equals("R1"))
			arg3 = Pipeline.R1;
		else if (instructionsMemory.getArg3().equals("R2"))
			arg3 = Pipeline.R2;
		else if (instructionsMemory.getArg3().equals("R3"))
			arg3 = Pipeline.R3;
		else if (instructionsMemory.getArg3().equals("R4"))
			arg3 = Pipeline.R4;
		else if (instructionsMemory.getArg3().equals("R5"))
			arg3 = Pipeline.R5;
		else if (instructionsMemory.getArg3().equals("R6"))
			arg3 = Pipeline.R6;
		else if (instructionsMemory.getArg3().equals("R7"))
			arg3 = Pipeline.R7;
		else
			arg3 = Integer.parseInt(instructionsMemory.getArg3());

		if (instructionsMemory.getType().equalsIgnoreCase("ADDI")) {
			arg1 = arg2 + arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("ADD")) {
			arg1 = arg2 + arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("ST")) {
			Pipeline.storeTargetAddress = arg2 + arg3;
		//	System.out.println("Store target address:" + Pipeline.storeTargetAddress);
		} else if (instructionsMemory.getType().equalsIgnoreCase("LD")) {
			Pipeline.loadTargetAddress = arg2 + arg3;
		//	System.out.println("*********************************" + Pipeline.loadTargetAddress
			//		+ "************************************");
		} else if (instructionsMemory.getType().equalsIgnoreCase("SUBI")) {
			arg1 = arg2 - arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("SUB")) {
			arg1 = arg2 - arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("MUL")) {
			arg1 = arg2 * arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("DIV")) {
			arg1 = arg2 / arg3;
		} else if (instructionsMemory.getType().equalsIgnoreCase("BNEQZ")) {
			if (arg1 != 0) {
				//System.out.println("Branch Taken");
				instructionsMemory.setArg3("1");
				nextPC = instructionsMemory.getPc() + 4 + (arg2 * 4);

			} else {
				//System.out.println("Branch Not Taken");
				instructionsMemory.setArg3("0");
				nextPC = instructionsMemory.getPc();
			}
		} else if (instructionsMemory.getType().equalsIgnoreCase("BEQZ")) {
			if (arg1 == 0) {
				//System.out.println("Branch Taken");
				instructionsMemory.setArg3("1");
				nextPC = instructionsMemory.getPc() + 4 + (arg2 * 4);

			} else {
				//System.out.println("Branch Not Taken");
				instructionsMemory.setArg3("0");
				nextPC = instructionsMemory.getPc();
			}
		} else if (instructionsMemory.getType().equalsIgnoreCase("AND")) {
			arg1 = arg2 & arg3;

		} else {
			//System.out.println("new type");
		}

//		System.out.println("ex:" + arg1);
//		System.out.println("ex1:" + instructionsMemory.getArg1());
		Pipeline.completed+=1;
		return instructionsMemory;
	}
}
