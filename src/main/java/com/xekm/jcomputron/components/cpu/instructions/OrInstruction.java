/**
 * User: mike
 * Date: 10/18/12
 *
 * Instruction to OR two registers together, putting the output in
 * another register
 *
 * Form of 7RST,
 * 7 - opcode
 * R - The register to store the output to
 * ST - The two registers to OR
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class OrInstruction
        extends AbstractInstruction {
    public OrInstruction(Byte highOrder, Byte lowOrder, RegisterUnit registers,
                         Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "OR instruction";
    }
}
