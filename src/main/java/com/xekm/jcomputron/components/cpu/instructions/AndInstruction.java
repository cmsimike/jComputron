/**
 * User: mike 
 * Date: 10/18/12 
 *
 * Instruction to AND two registers together,
 * storing the result in a third register
 *
 * Form of 8RST, 
 * 8 - opcode
 * R - The register to store the result into 
 * S - The first register to and
 * T - The second register to and
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.Util;
import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class AndInstruction
        extends AbstractInstruction {

    public AndInstruction(Byte highOrder, Byte lowOrder,
                          RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return "AND instruction";
    }

}
