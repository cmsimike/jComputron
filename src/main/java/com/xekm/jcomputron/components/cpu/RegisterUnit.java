/**
 *
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.components.cpu
 *
 * Public class:
 *   RegisterUnit.java
 *
 * Overview:
 *   The class that maintains all of the CPU's registers.
 *
 * Development history:
 *   Sep 20, 2012 - mike - Created
 */

package com.xekm.jcomputron.components.cpu;

import com.xekm.jcomputron.Util;
import com.xekm.jcomputron.components.basic.Byte;
import com.xekm.jcomputron.components.basic.Register;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterUnit {
    private static final int GENERAL_PURPOSE_REGISTER_COUNT = 16;
    private List<Register> cpuRegisters = new ArrayList<Register>();
    private int programCounter = 0;
    private boolean running = true;

    public RegisterUnit() {
        for (int i = 0; i < GENERAL_PURPOSE_REGISTER_COUNT; i++) {
            cpuRegisters.add(i, new Register());
        }
    }

    public Byte get(boolean[] nibble) {
        return this.get(Util.boolToHex(nibble));
    }
    public Byte get(char hexRegisterNumber) {
        Byte b = this.cpuRegisters.get(Integer.parseInt(Character.toString(hexRegisterNumber), 16)).getValue();
        System.err.println("Getting " + b + " from register: " + hexRegisterNumber);
        return b;
    }

    public void set(boolean nibble[], Byte theByte) {
        this.set(Util.boolToHex(nibble), theByte);
    }

    public void set(char hexRegisterNumber, Byte theByte) {
        System.err.println("register: " + hexRegisterNumber + " adding " + theByte);
        this.cpuRegisters.get(Integer.parseInt(Character.toString(hexRegisterNumber), 16)).setValue(
                theByte);
    }

    /**
     * Returns the current state of the program counter, then increments it by 2
     *
     * @return The hex value for the program counter
     */
    public String getProgramCounter() {
        String current = Util.intToHex(this.programCounter);
        this.programCounter++;
        return current;
    }

    /**
     * Sets the running flag to stop
     */
    public void stop() {
        this.running = false;
    }

    public boolean isRunning() {
        return this.running;
    }
}
