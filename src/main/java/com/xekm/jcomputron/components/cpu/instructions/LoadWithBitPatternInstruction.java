/**
 * User: mike 
 * Date: 9/19/12 
 *
 * Instruction to load a register with a bit pattern.
 *
 * Form of 2RXY, 
 * 2 - opcode 
 * R - The register to load into 
 * XY - The bit pattern to load.
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class LoadWithBitPatternInstruction
        extends AbstractInstruction {
    public LoadWithBitPatternInstruction(
            com.xekm.jcomputron.components.basic.Byte highOrder, Byte lowOrder,
            RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());;
        this.getRegisters().set(this.getHighOrderByte().getLowOrderNibble(), this.getLowOrderByte());
    }

    @Override
    public String toString() {
        return "load with bit pattern instruction";
    }
}
