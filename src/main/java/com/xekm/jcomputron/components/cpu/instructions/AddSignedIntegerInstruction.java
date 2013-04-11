/**
 * User: mike
 * Date: 9/19/12
 *
 * Instruction to add two registers as if they were two's compliment.
 * Form of 5RXY,
 * 5 - opcode
 * R - The register to store the result into
 * ST - Add registers S and T as if they were two's compliment
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.Util;
import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public class AddSignedIntegerInstruction
        extends AbstractInstruction {
    public AddSignedIntegerInstruction(Byte highOrder, Byte lowOrder,
                                       RegisterUnit registers, Memory memory) {
        super(highOrder, lowOrder, registers, memory);
    }

    @Override
    public void execute() {
        System.err.println(this.toString());
        Byte a = this.getRegisters().get(this.getLowOrderByte().getHighOrderNibble());
        Byte b = this.getRegisters().get(this.getLowOrderByte().getLowOrderNibble());
        int total = a.toInt() + b.toInt();
        System.err.println(" Total: " + total);
        if(total % 256 < total) {
            System.err.println(" ERM MAH GERD OVERFLREW");
            total = total % 256;
        }
        System.err.println(" Final Total: " + total);

        this.getRegisters().set(this.getHighOrderByte().getLowOrderNibble(), Util.getByteFromHexString(Util.intToHex(total)));
    }

    @Override
    public String toString() {
        return "signed int add instruction";
    }
}
