/**
 * User: mike 
 * Date: 10/18/12 
 *
 * Instruction to XOR two registers together,
 * storing the result in a third register
 *
 * Form of 9RST, 
 * 9- opcode
 * R - The register to store the result into 
 * S - The first register to XOR
 * T - The second register to XOR
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class XorInstruction
        extends AbstractInstruction {

    public XorInstruction(Byte highOrder, Byte lowOrder,
                          RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "XOR instruction";
    }

}
