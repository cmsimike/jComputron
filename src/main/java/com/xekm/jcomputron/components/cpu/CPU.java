/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.components.cpu
 *
 * Public class:
 *   CPU.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Sep 21, 2012 - mike - Created
 */

package com.xekm.jcomputron.components.cpu;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.instructions.AbstractInstruction;
import com.xekm.jcomputron.components.memory.Memory;

public class CPU {
    private Memory memory;
    private RegisterUnit registers;

    public CPU(String program) {
        this.memory = new Memory(program);
        this.registers = new RegisterUnit();
    }

    public void run() {
        // Keep the machine running until we hit the HaltInstruction
        while (registers.isRunning()) {
            System.err.println("");
            System.err.println("");
            System.err.println("");
            // Fetch
            // Two fetches
            Byte highOrder = memory.get(registers.getProgramCounter());
            Byte lowOrder = memory.get(registers.getProgramCounter());

            // Decode
            AbstractInstruction ins = AbstractInstruction.getInstruction(highOrder,
                    lowOrder, registers, memory);
            // Execute
            System.err.println(ins.toHex());
            ins.execute();
        }
    }
}
