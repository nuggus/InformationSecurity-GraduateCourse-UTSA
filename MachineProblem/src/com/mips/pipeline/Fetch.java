package com.mips.pipeline;

public class Fetch {

	public InstructionsList fetchStage(InstructionsList instructionsMemory) {
		Pipeline.fetched++;
		//System.out.println(instructionsMemory.getType());
		//System.out.println("in fetch:" + (instructionsMemory.getPc() / 4));
	
		return instructionsMemory;
	}

}
