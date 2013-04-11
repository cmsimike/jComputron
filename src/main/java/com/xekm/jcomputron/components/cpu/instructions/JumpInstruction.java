/**
 * User: mike 
 * Date: 10/18/12 
 *
 * Jump to the instruction located in the memory cell at address XY if the
 * bit pattern in register R is equal to the bit pattern in register number 0.
 * Otherwise continue with the normal sequence of execution.
 *
 * Form of BRXY, 
 * B - opcode
 * R - The register to compare with register 0 
 * XY - The memory address to jump to
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class JumpInstruction
        extends AbstractInstruction {

    public JumpInstruction(Byte highOrder, Byte lowOrder,
                           RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "Jump instruction";
    }
}
