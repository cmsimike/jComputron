/**
 * User: mike 
 * Date: 9/19/12 
 *
 * Instruction to load a register from a memory
 * address. 
 *
 * Form of 1RXY, 
 * 1 - opcode
 * R - The register to load into 
 * XY - The memory address to load from.
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

import java.util.Arrays;

public class LoadFromMemoryInstruction
        extends AbstractInstruction {
    public LoadFromMemoryInstruction(Byte highOrder, Byte lowOrder,
                                     RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
        Byte fromMemory = this.getMemory().get(this.getLowOrderByte());
        this.getRegisters().set(this.getHighOrderByte().getLowOrderNibble(), fromMemory);
    }

    @Override
    public String toString() {
        return "load from memory instruction";
    }
}
