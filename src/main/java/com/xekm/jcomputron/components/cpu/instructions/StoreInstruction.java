/**
 * User: mike
 * Date: 9/19/12
 *
 * Instruction to store a bit pattern to memory
 * Form of 3RXY,
 * 3 - opcode
 * R - The register to store data from.
 * XY - The memory address to store to.
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class StoreInstruction
        extends AbstractInstruction {
    public StoreInstruction(Byte highOrder, Byte lowOrder,
                            RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    /**
     * TODO
     * definitely doc this up and change the code to better match the machine lang def
     */
    @Override
    public void execute() {
        System.err.println(this.toString());
        Byte fromRegister = this.getRegisters().get(this.getHighOrderByte().getLowOrderNibble());
        this.getMemory().set(this.getLowOrderByte().toHex(), fromRegister);
    }

    @Override
    public String toString() {
        return "store instruction";
    }
}
