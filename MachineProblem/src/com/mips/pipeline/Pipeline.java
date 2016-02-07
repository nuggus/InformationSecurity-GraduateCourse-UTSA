package com.mips.pipeline;

import java.util.Scanner;

public class Pipeline {
	final static int InstructionsMemorySIZE = 256;
	final static int DMEMSIZE = 597;
	final static int TOTALCYCLE = 1000;
	final static int TOTAL_REGISTER_TYPE = 8;
	static int totalInstructions = 0;
	public static int dmem[] = new int[DMEMSIZE];
	static int clockCycle=3;
	int stallCycle;
	int fetchedIns;
	int finishedIns;
	public static int storeTargetAddress = 0;
	public static int loadTargetAddress = 0;
	String registerNames[] = { "R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7" };
	public static int R0 = 0, R1 = 0, R2 = 0, R3 = 0, R4 = 0, R5 = 0, R6 = 0, R7 = 0;
	public static int stall = 4;
	public static int fetched = 0;
	public static int completed = 1;
	static int tempCycle=3;
	public static boolean hltFetched = false;
	public static int hltCount = 0;

	// main method start
	public static void main(String[] args) {
		System.out.println("Enter programno from 1 to 6:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int progno = input.nextInt();
		// asking user to select which set of
		System.out.println(progno);
		// Instructions Memory
		InstructionsList[] InstructionsMemory = new InstructionsList[InstructionsMemorySIZE];
		for (int i = 0; i < InstructionsMemorySIZE; i++) {
			InstructionsMemory[i] = new InstructionsList(null, "", "", "", 0, "nostage");
		}
		for (int i = 0; i < DMEMSIZE; i++) {
			dmem[i] = 0;
		}

		clockCycle = 1;
		int i;
		switch (progno) {
		// Program 1
		case 1:

			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R1", "R0", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R5", "R0", "2", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R0", "196", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R0", "396", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R1", "R2", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("MUL", "R4", "R1", "R5", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R4", "R3", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R2", "R2", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R3", "R3", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R1", "R1", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BNEQZ", "R1", "-7", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R0", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R0", "196", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R0", "396", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R0", "596", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("LD", "R5", "R2", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("LD", "R6", "R3", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADD", "R5", "R5", "R6", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R7", "R0", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("DIV", "R5", "R5", "R7", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R5", "R4", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R2", "R2", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R3", "R3", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R4", "R4", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R1", "R1", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BNEQZ", "R1", "-11", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			break;

		// Program 2
		case 2:
			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R7", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R0", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R2", "R1", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R2", "12", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R0", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R0", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUB", "R2", "R4", "R1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R2", "R2", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R2", "3", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("MUL", "R3", "R3", "R4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R4", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-6", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R3", "R7", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R7", "R7", "4", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R1", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-14", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			break;
		// Program 3
		case 3:
			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R1", "R0", "10", i, "nostage");
			totalInstructions = totalInstructions + 1;
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R0", "8", i, "nostage");
			totalInstructions = totalInstructions + 1;
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R0", "16", i, "nostage");
			totalInstructions = totalInstructions + 1;
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R1", "R1", "4", i, "nostage");
			totalInstructions = totalInstructions + 1;
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			totalInstructions = totalInstructions + 1;
			break;

		// Program 4
		case 4:

			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R4", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R5", "R1", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R5", "13", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R5", "R2", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R5", "8", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R5", "R3", "5", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R5", "3", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R4", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R3", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-5", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R2", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-10", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R1", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-15", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			break;

		// Program 5
		case 5:
			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R1", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R0", "1023", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R3", "R0", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R7", "R0", "2", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R5", "R4", "32", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R5", "6", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("AND", "R6", "R2", "R3", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R6", "1", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R1", "R1", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("MUL", "R3", "R3", "R7", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R4", "R4", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BEQZ", "R0", "-8", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			break;
		// Program 6
		case 6:

			i = 0;
			InstructionsMemory[i] = new InstructionsList("ADDI", "R1", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R2", "R0", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADDI", "R5", "R0", "10", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADD", "R3", "R1", "R2", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADD", "R1", "R2", "R0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ADD", "R2", "R3", "R0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("SUBI", "R5", "R5", "1", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("BNEQZ", "R5", "-5", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("ST", "R3", "R0", "0", i, "nostage");
			i += 4;
			InstructionsMemory[i / 4] = new InstructionsList("HLT", "0", "0", "0", i, "nostage");
			break;

		default:
			System.out.println("No program exists!!!");
			break;
		}

		Fetch fetch = new Fetch();
		Decode decode = new Decode();
		Execute execution = new Execute();
		MemoryAccess memoryAccess = new MemoryAccess();
		WriteBack wb = new WriteBack();
		String previousLast = "";
		String prevStage = "";
		int lastCycle = 3;
		// loops through each stage for each instruction
		for (clockCycle = 1; clockCycle <= TOTALCYCLE; clockCycle++) {
			// System.out.println("****************************clockcycle" +
			// clockCycle + "*************");
			i = 0;

			while (!previousLast.equalsIgnoreCase("HLT")) {
				boolean decodeStage = false;
				boolean executeStage = false;
				boolean memoryStage = false;
				boolean writebackStage = false;
				// fetch
				if ((InstructionsMemory[i].getStage() == "nostage")) {
					if ((i - 1) >= 0) {
						if (!InstructionsMemory[i - 1].getType().contains("Q")) {
							fetch.fetchStage(InstructionsMemory[i]);
							InstructionsMemory[i].setStage("FETCH");
							break;
						} else {
							if (InstructionsMemory[i - 1].getStage().equalsIgnoreCase("DECODE")
									|| InstructionsMemory[i - 1].getStage().equalsIgnoreCase("EXECUTE")) {
								stall = stall + 1;
								// System.out.println("stall in fetch");
								break;
							} else {
								fetch.fetchStage(InstructionsMemory[i]);
								InstructionsMemory[i].setStage("FETCH");
								break;
							}

						} // end nested if

					} else {
						fetch.fetchStage(InstructionsMemory[i]);
						InstructionsMemory[i].setStage("FETCH");
						break;
					}
				} // end if for nostage fetch branch
					// decode functionality
				if (InstructionsMemory[i].getStage().equalsIgnoreCase("FETCH")) {
					if ((i - 1) >= 0) {
						if (!InstructionsMemory[i - 1].getType().equalsIgnoreCase("ST")) {
							if ((InstructionsMemory[i].getArg2() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("EXECUTE")) {
								stall = stall + 1;
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg2() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg3() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("EXECUTE")) {
								stall = stall + 1;
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg3() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								break;
							} // end nested if
						}
					} // end if
					if ((i - 2) >= 1) {
						if (!InstructionsMemory[i - 2].getType().equalsIgnoreCase("ST")) {
							if ((InstructionsMemory[i].getArg2() == InstructionsMemory[i - 2].getArg1())
									&& InstructionsMemory[i - 2].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg3() == InstructionsMemory[i - 2].getArg1())
									&& InstructionsMemory[i - 2].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								break;
							} // end nested if
						}
					} // end if

					// for branch in decode stage verify data data dependency

					if ((i - 1) >= 0) {
						if (InstructionsMemory[i].getType().contains("Q")) {
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("EXECUTE")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
						} // end
							// InstructionsMemory[i].getType().equalsIgnoreCase("BNEQZ")

					} // end if (i-1)>=0 IF

					if ((i - 2) >= 1) {
						if (InstructionsMemory[i].getType().contains("Q")) {
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 2].getArg1())
									&& InstructionsMemory[i - 2].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
						} // end
							// InstructionsMemory[i].getType().equalsIgnoreCase("BNEQZ")
							// IF

					} // end if (i-2)>=1 IF

					if ((i - 1) >= 0) {
						if (InstructionsMemory[i].getType().equalsIgnoreCase("ST")) {
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("EXECUTE")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 1].getArg1())
									&& InstructionsMemory[i - 1].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
						} // end
							// InstructionsMemory[i].getType().equalsIgnoreCase("BNEQZ")

					} // end if (i-1)>=0 IF

					if ((i - 2) >= 1) {
						if (InstructionsMemory[i].getType().equalsIgnoreCase("ST")) {
							if ((InstructionsMemory[i].getArg1() == InstructionsMemory[i - 2].getArg1())
									&& InstructionsMemory[i - 2].getStage().equalsIgnoreCase("MEMORYACCESS")) {
								stall = stall + 1;
								// System.out.println("stall");
								break;
							} // end nested if
						} // end
							// InstructionsMemory[i].getType().equalsIgnoreCase("BNEQZ")
							// IF

					} // end if (i-2)>=1 IF

					decode.decodeStage(InstructionsMemory[i]);
					decodeStage = true;
				} // DECODE END
					// execution stage
				if (InstructionsMemory[i].getStage().equalsIgnoreCase("DECODE")) {
					execution.executionStage(InstructionsMemory[i]);
					executeStage = true;
				} // EXECUTE END
					// memory access stage
				if (InstructionsMemory[i].getStage().equalsIgnoreCase("EXECUTE")) {
					memoryAccess.memoryStage(InstructionsMemory[i]);
					memoryStage = true;
				} // MEMORY ACCESS END
					// WB stage
				if (InstructionsMemory[i].getStage().equalsIgnoreCase("MEMORYACCESS")) {
					wb.writeBackStage(InstructionsMemory[i]);
					writebackStage = true;
				} // WB END
				if (decodeStage)
					InstructionsMemory[i].setStage("DECODE");
				if (executeStage)
					InstructionsMemory[i].setStage("EXECUTE");
				if (memoryStage)
					InstructionsMemory[i].setStage("MEMORYACCESS");
				if (writebackStage) {

					if (InstructionsMemory[i].getType().contains("Q")
							&& InstructionsMemory[i].getArg3().equalsIgnoreCase("1")) {
						InstructionsMemory[i].setStage("nostage");
					} else
						InstructionsMemory[i].setStage("WRITEBACK");
				}
				// if(InstructionsMemory[i].getType().equalsIgnoreCase("HLT")&&InstructionsMemory[i].getStage().equalsIgnoreCase("WRITEBACK"))
				previousLast = InstructionsMemory[i].getType();
				if (previousLast.equalsIgnoreCase("HLT")) {
					if (InstructionsMemory[i].getStage().equalsIgnoreCase("WRITEBACK")) {
						prevStage = "WRITEBACK";
					}
				}

				if (InstructionsMemory[i].getType().contains("Q")
						&& InstructionsMemory[i].getArg3().equalsIgnoreCase("1")) {
					if (InstructionsMemory[i].getStage().equalsIgnoreCase("MEMORYACCESS")) {
						int curPc = i;
						i = (Execute.nextPC) / 4;
						// System.out.println("old i :" + curPc);
						// System.out.println("New i:" + i);
						int npc = i;
						// while (npc < curPc) {
						for (int k = npc; k <= curPc; k++) {
							InstructionsMemory[k].setStage("nostage");
							// System.out.println(InstructionsMemory[k].getStage());
						}
						// }
					} else {
						i++;
					}

				} else {
					i++;
				}
		
				if (clockCycle == 1000)
					lastCycle = 1000;
				else
					lastCycle = tempCycle+clockCycle;
			} // end while

		} // end for
		System.out.println("Name: Viswanath Nuggu, ID: tef771");
		System.out.println("Fetched Instructions" + fetched + "\n" + "completed instructions:" + completed + "\n"
				+ "Total Cycles" + lastCycle + "\n" + "Stall Cycles:" + stall + "\n");
		// System.out.println("R0=" + Pipeline.R0);
		System.out.println("R1=" + Pipeline.R1);
		System.out.println("R2=" + Pipeline.R2);
		System.out.println("R3=" + Pipeline.R3);
		System.out.println("R4=" + Pipeline.R4);
		System.out.println("R5=" + Pipeline.R5);
		System.out.println("R6=" + Pipeline.R6);
		System.out.println("R7=" + Pipeline.R7);

	}// end
		// main

}// end class
