package com.mips.pipeline;

public class InstructionsList {
	String type;
	String arg1;
	String arg2;
	String arg3;
	int pc;
	String stage;

	public InstructionsList(String type, String arg1, String arg2, String arg3, int pc, String stage) {
		super();
		this.type = type;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.pc = pc;
		this.stage = stage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArg1() {
		return arg1;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}

	public String getArg3() {
		return arg3;
	}

	public void setArg3(String arg3) {
		this.arg3 = arg3;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

}
