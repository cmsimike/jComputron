/**
 * User: mike
 * Date: 9/19/12
 * The base for all other machine language instructions. 16 bit instructions, requires two com.xekm.jcomputron.basic.Bytes.
 *
 */

package com.xekm.jcomputron.components.cpu.instructions;
import com.xekm.jcomputron.components.basic.Byte;

public abstract class AbstractInstruction {
    private Byte highOrder;
    private Byte lowOrder;

    public AbstractInstruction(Byte highOrder, Byte lowOrder) {
        this.highOrder = highOrder;
        this.lowOrder = lowOrder;
    }
}
