/**
 * User: mike
 * Date: 10/16/12
 *
 * Instruction to halt the computer from executing the program
 * Form of C000,
 * C - opcode
 * 000 - NOOP
 *
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class HaltInstruction
        extends AbstractInstruction {
    public HaltInstruction(Byte highOrder, Byte lowOrder,
                           RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        this.getRegisters().stop();
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "halt instruction";
    }
}
