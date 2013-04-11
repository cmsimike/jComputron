/**
 * User: mike
 * Date: 9/19/12
 *
 * Instruction to add two registers as if they were floating point values.
 * Form of 6RST,
 * 6 - opcode
 * R - The register to store the result into
 * ST - Add registers S and T as if they were floating point values
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class AddFloatingPointInstruction
        extends AbstractInstruction {
    public AddFloatingPointInstruction(Byte highOrder, Byte lowOrder,
                                       RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "floating point add instruction";
    }
}
