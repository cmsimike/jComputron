/**
 * User: mike
 * Date: 9/19/12
 * The base for all other machine language instructions.
 * 16 bit instructions, requires two com.xekm.jcomputron.basic.Bytes.
 *
 */

package com.xekm.jcomputron.components.cpu.instructions;

import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.cpu.RegisterUnit;
import com.xekm.jcomputron.components.memory.Memory;

public abstract class AbstractInstruction {
    private Byte highOrder;
    private Byte lowOrder;

    private RegisterUnit registers;
    private Memory memory;

    public AbstractInstruction(Byte highOrder, Byte lowOrder,
                               RegisterUnit registers, Memory memory) {
        this.highOrder = highOrder;
        this.lowOrder = lowOrder;

        this.registers = registers;
        this.memory = memory;
    }

    public Byte getHighOrderByte() {
        return this.highOrder.clone();
    }

    public Byte getLowOrderByte() {
        return this.lowOrder.clone();
    }

    public abstract void execute();

    public abstract String toString();

    public static AbstractInstruction getInstruction(Byte highOrder,
                                                     Byte lowOrder, RegisterUnit registers, Memory memory) {
        int result = 0;
        int[] multiply = new int[]{8, 4, 2, 1};

        for (int i = 0; i < 4; i++) {
            result = result + (highOrder.getBitAt(i) ? multiply[i] : 0);
        }

        switch (result) {
            case 1:
                return new LoadFromMemoryInstruction(highOrder, lowOrder, registers,
                        memory);
            case 2:
                return new LoadWithBitPatternInstruction(highOrder, lowOrder,
                        registers, memory);
            case 3:
                return new StoreInstruction(highOrder, lowOrder, registers, memory);
            case 4:
                return new MoveInstruction(highOrder, lowOrder, registers, memory);
            case 5:
                return new AddSignedIntegerInstruction(highOrder, lowOrder,
                        registers, memory);
            case 6:
                return new AddFloatingPointInstruction(highOrder, lowOrder,
                        registers, memory);
            case 7:
                return new OrInstruction(highOrder, lowOrder, registers, memory);
            case 8:
                return new AndInstruction(highOrder, lowOrder, registers, memory);
            case 9:
                return new XorInstruction(highOrder, lowOrder, registers, memory);
            case 10:
                return new RotateInstruction(highOrder, lowOrder, registers, memory);
            case 11:
                return new JumpInstruction(highOrder, lowOrder, registers, memory);
            case 12:
                return new HaltInstruction(highOrder, lowOrder, registers, memory);
            default:
                throw new IllegalStateException("Unknown op code: " + result);
        }
    }

    public RegisterUnit getRegisters() {
        return this.registers;
    }

    public Memory getMemory() {
        return this.memory;
    }

    public String toHex() {
        return this.highOrder.toHex() + this.lowOrder.toHex();
    }
}
