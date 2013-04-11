/**
 * User: mike 
 * Date: 10/18/12 
 *
 * Instruction to the bit pattern in register R one bit to the right X times.
 * Each time place the bit that started at the low-order end at the high order end.
 *
 * Form of AR0X, 
 * A - opcode
 * R - The register to rotate 
 * 0 - Unused
 * X - The amount to rotate
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class RotateInstruction
        extends AbstractInstruction {

    public RotateInstruction(Byte highOrder, Byte lowOrder,
                             RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "Rotate instruction";
    }

}
