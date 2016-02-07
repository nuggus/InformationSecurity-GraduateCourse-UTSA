package com.mips.pipeline;

public class WriteBack {
	public void writeBackStage(InstructionsList instructionsMemory) {
		
		if (instructionsMemory.getType().contains("Q")) {
			//System.out.println("branch writeback");
		} else if (instructionsMemory.getType().equalsIgnoreCase("ST")) {
			//System.out.println("st write back");
		} else {
			if (instructionsMemory.getArg1().equals("R1"))
				Pipeline.R1 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R2"))
				Pipeline.R2 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R3"))
				Pipeline.R3 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R4"))
				Pipeline.R4 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R5"))
				Pipeline.R5 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R6"))
				Pipeline.R6 = MemoryAccess.exValue;
			if (instructionsMemory.getArg1().equals("R7"))
				Pipeline.R7 = MemoryAccess.exValue;
//			System.out.println("************************Register values*******************");
//			System.out.println("R0=" + Pipeline.R0);
//			System.out.println("R1=" + Pipeline.R1);
//			System.out.println("R2=" + Pipeline.R2);
//			System.out.println("R3=" + Pipeline.R3);
//			System.out.println("R4=" + Pipeline.R4);
//			System.out.println("R5=" + Pipeline.R5);
//			System.out.println("R6=" + Pipeline.R6);
//			System.out.println("R7=" + Pipeline.R7);
		}
	}
}
