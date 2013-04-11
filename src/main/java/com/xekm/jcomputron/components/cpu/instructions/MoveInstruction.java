/**
 * User: mike
 * Date: 9/19/12
 *
 * Instruction to move (copy, really) contents of one register to another.
 * Form of 40RS
 * 4 - opcode
 * 0 - Unused nibble
 * RS - Move the bit pattern found in register R to register S
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class MoveInstruction
        extends AbstractInstruction {
    public MoveInstruction(Byte highOrder, Byte lowOrder,
                           RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
        Byte b = this.getRegisters().get(this.getLowOrderByte().getHighOrderNibble());
        this.getRegisters().set(this.getLowOrderByte().getLowOrderNibble(), b);
    }

    @Override
    public String toString() {
        return "move instruction";
    }
}
