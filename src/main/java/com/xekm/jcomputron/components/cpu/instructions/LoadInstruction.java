package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.*;

/**
 * User: mike
 * Date: 9/19/12
 */

public class LoadInstruction extends AbstractInstruction {

    public LoadInstruction(com.xekm.jcomputron.components.basic.Byte highOrder, com.xekm.jcomputron.components.basic.Byte lowOrder) {
        super(highOrder, lowOrder);
    }
}
